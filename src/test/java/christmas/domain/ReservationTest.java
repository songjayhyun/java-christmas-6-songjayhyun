package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.exception.DuplicateOrderMenuException;
import christmas.exception.OrderedOnlyDrinksException;
import christmas.exception.OverMenuSizeAtOnceException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ReservationTest {

    private final int VISIT_DATE = 4;

    @DisplayName("중복 메뉴를 주문하면 예외 발생")
    @Test
    void name() {
        //given
        Order order1 = Order.of("양송이수프", 1);
        Order order2 = Order.of("양송이수프", 1);

        List<Order> orders = new ArrayList<>();
        orders.add(order1);
        orders.add(order2);

        //when then
        assertThatThrownBy(() -> Reservation.from(VISIT_DATE, orders))
                .isInstanceOf(DuplicateOrderMenuException.class);
    }

    @DisplayName("음료만 주문하면 예외 발생.")
    @Test
    void orderOnlyDrinks() {
        //given
        Order order1 = Order.of("제로콜라", 1);
        Order order2 = Order.of("레드와인", 1);

        List<Order> orders = new ArrayList<>();
        orders.add(order1);
        orders.add(order2);

        //when then
        assertThatThrownBy(() -> Reservation.from(VISIT_DATE, orders))
                .isInstanceOf(OrderedOnlyDrinksException.class);
    }

    @DisplayName("메뉴의 개수가 20개 초과면 예외 발생.")
    @Test
    void overMenuMaxSize() {
        //given
        Order order1 = Order.of("제로콜라", 19);
        Order order2 = Order.of("티본스테이크", 10);

        List<Order> orders = new ArrayList<>();
        orders.add(order1);
        orders.add(order2);

        //when then
        assertThatThrownBy(() -> Reservation.from(VISIT_DATE, orders))
                .isInstanceOf(OverMenuSizeAtOnceException.class);
    }

    @DisplayName("총 금액이 10000원 이상이 아니면 이벤트 적용되지 않는다")
    @Test
    void inActive() {
        //given
        List<Order> orders = new ArrayList<>();
        orders.add(Order.of("양송이수프", 1));

        //when
        Reservation reservation = Reservation.from(VISIT_DATE, orders);

        //then
        assertThat(reservation.isEvenActive()).isFalse();

    }
}