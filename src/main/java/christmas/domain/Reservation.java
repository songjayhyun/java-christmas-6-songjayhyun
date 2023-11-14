package christmas.domain;

import christmas.Order;
import christmas.exception.DuplicateOrderMenuException;
import christmas.exception.OverMenuSizeAtOnceException;
import java.util.List;

public class Reservation {

    private static final int MENU_SIZE_AT_ONCE = 20;
    private final Amount amount;
    private final List<Order> orders;

    private Reservation(Amount amount, List<Order> orders) {
        validateDuplicate(orders);
        validateMenuSize(orders);
        this.orders = orders;
        this.amount = amount;
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

    private static Reservation of(Amount amount, List<Order> orders) {
        return new Reservation(amount, orders);
    }

}
