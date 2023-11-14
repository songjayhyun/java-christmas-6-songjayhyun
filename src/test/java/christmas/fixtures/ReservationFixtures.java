package christmas.fixtures;

import christmas.domain.Order;
import christmas.domain.Reservation;
import java.util.ArrayList;
import java.util.List;

public class ReservationFixtures {

    public static Reservation createReservation() {
        List<Order> orders = new ArrayList<>();
        orders.add(Order.of("티본스테이크", 1));
        orders.add(Order.of("양송이수프", 1));
        orders.add(Order.of("초코케이크", 1));
        orders.add(Order.of("제로콜라", 1));

        return Reservation.from(orders);
    }

    public static Reservation createReservationWithNoDessert() {
        List<Order> orders = new ArrayList<>();
        orders.add(Order.of("티본스테이크", 1));
        orders.add(Order.of("양송이수프", 1));
        orders.add(Order.of("제로콜라", 1));

        return Reservation.from(orders);
    }

    public static Reservation createReservationWithDesserts() {
        List<Order> orders = new ArrayList<>();
        orders.add(Order.of("초코케이크", 2));
        orders.add(Order.of("아이스크림", 1));

        return Reservation.from(orders);
    }
}
