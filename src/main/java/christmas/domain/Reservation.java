package christmas.domain;

import christmas.Order;
import christmas.domain.dish.Dish;
import christmas.domain.dish.Drink;
import christmas.exception.DuplicateOrderMenuException;
import christmas.exception.NoMenuExistsException;
import christmas.exception.OverMenuSizeAtOnceException;
import java.util.List;

public class Reservation {

    private static final int MAX_MENU_SIZE_AT_ONCE = 20;
    private final List<Order> orders;
    private Amount amount;

    private Reservation(List<Order> orders) {
        validateDuplicate(orders);
        validateMenuSize(orders);
        validateOnlyDrinks(orders);
        this.orders = orders;
        this.amount = calAmount(orders);
    }

    private Amount calAmount(List<Order> orders) {
        int totalAmount = orders.stream()
                .map(Order::getDish)
                .mapToInt(Dish::getPrice)
                .sum();
        return new Amount(totalAmount);
    }

    public static Reservation from(List<Order> orders) {
        return new Reservation(orders);
    }

    private void validateOnlyDrinks(List<Order> orders) {
        int count = countDrinkDish(orders);

        if (count == orders.size()) {
            throw new OrderedOnlyDrinksException();
        }
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

}
