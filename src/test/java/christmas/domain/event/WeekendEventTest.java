package christmas.domain.event;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.config.AppConfig;
import christmas.domain.Amount;
import christmas.fixtures.LocalDateFixtures;
import christmas.fixtures.ReservationFixtures;
import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WeekendEventTest {

    private final AppConfig appConfig = AppConfig.getInstance();
    private final Event weekendEvent = appConfig.weekendEvent();


    @DisplayName("일요일부터 목요일이라면 이벤트가 적용된다.")
    @Test
    void eventActiveDuringWeekend() {
        //when
        LocalDate weekendDate = LocalDateFixtures.createWeekendDate();

        //then
        assertThat(weekendEvent.isEventActive(weekendDate)).isTrue();
    }

    @DisplayName("주문에 디저트 메뉴가 없다면 할인 대상이 안된다.")
    @Test
    void noDessertNoDiscount() {
        Amount amount = weekendEvent.process(
                LocalDateFixtures.createWeekendDate(),
                new Amount(10000),
                ReservationFixtures.createReservationWithNoDessert()
        );
        assertThat(amount.isEqualTo(0)).isTrue();
    }

    @DisplayName("총 할인 금액이 다르다")
    @Test
    void checkValidDiscountAmount() {
        Amount amount = weekendEvent.process(
                LocalDateFixtures.createWeekendDate(),
                new Amount(10000),
                ReservationFixtures.createReservationWithDesserts()
        );
        assertThat(amount.isEqualTo(4046)).isTrue();
    }

}