package christmas.domain.event;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.config.AppConfig;
import christmas.domain.Amount;
import christmas.fixtures.LocalDateFixtures;
import christmas.fixtures.ReservationFixtures;
import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WeekdayEventTest {

    private final AppConfig appConfig = AppConfig.getInstance();
    private final Event weekdayEvent = appConfig.weekdayEvent();


    @DisplayName("금요일부터 토요일이라면 이벤트가 적용된다.")
    @Test
    void eventActiveDuringWeekend() {
        //when
        LocalDate weekdayDate = LocalDateFixtures.createWeekdayDate();

        //then
        assertThat(weekdayEvent.isEventActive(weekdayDate)).isTrue();
    }

    @DisplayName("주문에 메인 메뉴가 없다면 할인 대상이 안된다.")
    @Test
    void noDessertNoDiscount() {
        Amount amount = weekdayEvent.process(
                LocalDateFixtures.createWeekdayDate(),
                new Amount(10000),
                ReservationFixtures.createReservationWithNoMain()
        );
        assertThat(amount.isEqualTo(0)).isTrue();
    }

    @DisplayName("총 할인 금액이 다르다")
    @Test
    void checkValidDiscountAmount() {
        Amount amount = weekdayEvent.process(
                LocalDateFixtures.createWeekdayDate(),
                new Amount(10000),
                ReservationFixtures.createReservationWithMains()
        );
        assertThat(amount.isEqualTo(4046)).isTrue();
    }
}