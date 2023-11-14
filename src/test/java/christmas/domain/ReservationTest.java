package christmas.domain;

import static org.junit.jupiter.api.Assertions.*;

import christmas.Order;
import christmas.exception.DuplicateOrderMenuException;
import christmas.exception.OverMenuSizeAtOnceException;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ReservationTest {

    @DisplayName("중복 메뉴를 주문하면 예외 발생")
    @Test
    void name() {
        Order order1 = Order.of("양송이수프", 1);
        Order order2 = Order.of("양송이수프", 1);

        List<Order> orderList = new ArrayList<>();
        orderList.add(order1);
        orderList.add(order2);

        Assertions.assertThatThrownBy(() -> Reservation.of(orderList))
                .isInstanceOf(DuplicateOrderMenuException.class);
    }

    @DisplayName("음료만 주문하면 예외 발생.")
    @Test
    void orderOnlyDrinks() {
        Order order1 = Order.of("제로콜라", 1);
        Order order2 = Order.of("레드와인", 1);

        List<Order> orderList = new ArrayList<>();
        orderList.add(order1);
        orderList.add(order2);

        Assertions.assertThatThrownBy(() -> Reservation.of(orderList))
                .isInstanceOf(OrderedOnlyDrinksException.class);
    }

    @DisplayName("메뉴의 개수가 20개 초과면 예외 발생.")
    @Test
    void overMenuMaxSize() {
        Order order1 = Order.of("제로콜라", 19);
        Order order2 = Order.of("티본스테이크", 10);

        List<Order> orderList = new ArrayList<>();
        orderList.add(order1);
        orderList.add(order2);

        Assertions.assertThatThrownBy(() -> Reservation.of(orderList))
                .isInstanceOf(OverMenuSizeAtOnceException.class);
    }
}