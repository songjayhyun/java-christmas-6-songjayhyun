package christmas.domain;

import christmas.Order;
import christmas.domain.category.DrinkCategory;
import christmas.domain.dish.Dessert;
import christmas.domain.dish.Dish;
import christmas.domain.dish.Drink;
import christmas.exception.DuplicateOrderMenuException;
import christmas.exception.NoMenuExistsException;
import christmas.exception.OverMenuSizeAtOnceException;
import java.util.List;
import java.util.Optional;

public class Reservation {

    private static final int MENU_SIZE_AT_ONCE = 20;
    private Amount amount;
    private final List<Order> orders;

    private Reservation(List<Order> orders) {
        validateDuplicate(orders);
        validateMenuSize(orders);
        validateOnlyDrinks(orders);
        this.orders = orders;
    }

    private void validateOnlyDrinks(List<Order> orders) {
        Menu menu = Menu.getInstance();

        int count = 0;
        for (Order order : orders) {
            Dish dish = menu.findDish(order.getDish())
                    .orElseThrow(NoMenuExistsException::new);
            if (dish instanceof Drink) {
                count++;
            }
        }

        if (count == orders.size()) {
            throw new OrderedOnlyDrinksException();
        }
    }

    private void validateMenuSize(List<Order> orders) {
        if (orders.size() > MENU_SIZE_AT_ONCE) {
            throw new OverMenuSizeAtOnceException();
        }
    }

    private void validateDuplicate(List<Order> orders) {
        if (orders.size() != orders.stream().map(Order::getDish).distinct().count()) {
            throw new DuplicateOrderMenuException();
        }
    }

    public static Reservation of(List<Order> orders) {
        return new Reservation(orders);
    }

}
