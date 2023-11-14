package christmas.domain;

import christmas.Order;
import java.util.List;

public class Reservation {
    private final Amount amount;
    private final List<Order> orders;

    private Reservation(Amount amount, List<Order> orders) {
        this.orders = orders;
        this.amount = amount;
    }

    private static Reservation of(Amount amount, List<Order> orders) {
        return new Reservation(amount, orders);
    }

}
