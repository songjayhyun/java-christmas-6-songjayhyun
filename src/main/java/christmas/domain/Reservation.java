package christmas.domain;

import christmas.Order;
import java.util.List;

public class Reservation {
    private final List<Order> orders;

    private Reservation(List<Order> orders) {
        this.orders = orders;
    }

    private static Reservation of(List<Order> orders) {
        return new Reservation(orders);
    }

}
