package christmas.domain;

import christmas.Order;
import christmas.exception.DuplicateOrderMenuException;
import java.util.List;

public class Reservation {
    private final Amount amount;
    private final List<Order> orders;

    private Reservation(Amount amount, List<Order> orders) {
        validateDuplicate(orders);
        this.orders = orders;
        this.amount = amount;
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
