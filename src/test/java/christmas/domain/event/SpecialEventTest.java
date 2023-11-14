package christmas.domain.event;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import christmas.config.AppConfig;
import christmas.domain.Amount;
import christmas.fixtures.AmountFixtures;
import christmas.fixtures.LocalDateFixtures;
import christmas.fixtures.ReservationFixtures;
import java.time.LocalDate;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SpecialEventTest {

    private final AppConfig appConfig = AppConfig.getInstance();
    private final Event specialEvent = appConfig.specialEvent();


    @DisplayName("별이 있으면 할인 된다")
    @Test
    void isEventActive() {
        //given
        LocalDate specialDate = LocalDateFixtures.createSpecialDate();

        //when then
        assertThat(specialEvent.isEventActive(specialDate)).isTrue();
    }

    @DisplayName("별이 없으면 할인이 안된다")
    @Test
    void isEventInActive() {
        //given
        LocalDate notSpecialDate = LocalDateFixtures.createNotSpecialDate();

        //when then
        assertThat(specialEvent.isEventActive(notSpecialDate)).isFalse();
    }

    @DisplayName("할인 금액이 다르다")
    @Test
    void validTotalDiscountAmount() {
        //when
        Amount amount = specialEvent.process(
                LocalDateFixtures.createSpecialDate(),
                AmountFixtures.createAmount(),
                ReservationFixtures.createReservation()
        );

        //then
        assertThat(amount.isEqualTo(1000));
    }
}