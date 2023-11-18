package christmas.domain;

import christmas.domain.category.Category;
import christmas.domain.dish.Dish;
import christmas.domain.dish.Drink;
import christmas.exception.DuplicateOrderMenuException;
import christmas.exception.NoMenuExistsException;
import christmas.exception.OrderedOnlyDrinksException;
import christmas.exception.OverMenuSizeAtOnceException;
import java.util.List;
import java.util.Optional;

public class Reservation {

    private static final int MAX_MENU_SIZE_AT_ONCE = 20;
    private final List<Order> orders;
    private final VisitDate visitDate;
    private final Amount amount;

    private Reservation(VisitDate visitDate, List<Order> orders) {
        validateDuplicate(orders);
        validateMenuSize(orders);
        validateOnlyDrinks(orders);
        this.orders = orders;
        this.amount = calAmount(orders);
        this.visitDate = visitDate;
    }

    public static Reservation of(VisitDate date, List<Order> orders) {
        return new Reservation(date, orders);
    }

    private static int countDrinkDish(List<Order> orders) {
        Menu menu = Menu.getInstance();

        int count = 0;
        for (Order order : orders) {
            Dish dish = menu.findDish(order.getDish())
                    .orElseThrow(NoMenuExistsException::new);
            if (dish instanceof Drink) {
                count++;
            }
        }
        return count;
    }

    private Amount calAmount(List<Order> orders) {
        int totalAmount = 0;
        for (Order order : orders) {
            totalAmount += order.totalAmount();
        }
        return new Amount(totalAmount);
    }

    private void validateOnlyDrinks(List<Order> orders) {
        int count = countDrinkDish(orders);

        if (count == orders.size()) {
            throw new OrderedOnlyDrinksException();
        }
    }

    private void validateMenuSize(List<Order> orders) {
        int size = orders.stream()
                .mapToInt(Order::getCount)
                .sum();

        if (size > MAX_MENU_SIZE_AT_ONCE) {
            throw new OverMenuSizeAtOnceException();
        }
    }

    private void validateDuplicate(List<Order> orders) {
        if (orders.size() != orders.stream().map(Order::getDish).distinct().count()) {
            throw new DuplicateOrderMenuException();
        }
    }

    public int countDish(Category category) {
        return (int) orders.stream()
                .map(order -> category.findDish(order.getDish()))
                .filter(Optional::isPresent)
                .count();
    }

    public boolean isEvenActive() {
        return amount.isEventActive();
    }

    public Amount getAmount() {
        return amount;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public VisitDate getVisitDate() {
        return visitDate;
    }
}
