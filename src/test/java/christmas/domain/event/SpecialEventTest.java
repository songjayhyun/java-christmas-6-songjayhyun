package christmas.domain.event;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.Amount;
import christmas.domain.discountpolicy.FixDiscountPolicy;
import christmas.fixtures.AmountFixtures;
import christmas.fixtures.LocalDateFixtures;
import christmas.fixtures.ReservationFixtures;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SpecialEventTest {

    private final Event specialEvent = new SpecialEvent(
            "2023.12.01",
            "2023.12.31",
            List.of(3, 10, 17, 24, 25, 31),
            new FixDiscountPolicy(1000)
    );

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
        assertThat(amount.isEqualTo(1000)).isTrue();
    }
}