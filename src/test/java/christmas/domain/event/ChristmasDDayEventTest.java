package christmas.domain.event;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.Amount;
import christmas.domain.VisitDate;
import christmas.fixtures.ReservationFixtures;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ChristmasDDayEventTest {

    private final Event christmasDDayEvent = new ChristmasDDayEvent("2023.12.01", "2023.12.25");

    @DisplayName("이벤트 기간이= 이벤트가 적용되어야 한다.")
    @Test
    void eventActiveDate() {
        //when then
        assertThat(christmasDDayEvent.isEventActive(VisitDate.from(24))).isTrue();
    }

    @DisplayName("1일에 1000원으로 시작한다.")
    @Test
    void checkStartAmount() {
        //given
        Amount amount = new Amount(0);

        //when
        Amount discount = christmasDDayEvent.process(
                VisitDate.from(1),
                amount,
                ReservationFixtures.createReservation());

        //then
        assertThat(discount.isEqualTo(1000)).isTrue();
    }

    @DisplayName("매일 100원씩 증가한다.")
    @Test
    void checkDayIncreaseAmount() {
        //given
        Amount amount = new Amount(0);

        //when
        Amount discount = christmasDDayEvent.process(
                VisitDate.from(2),
                amount,
                ReservationFixtures.createReservation());

        //then
        assertThat(discount.isEqualTo(1100)).isTrue();
    }

    @DisplayName("총 할인 금액이 정확해야 한다.")
    @Test
    void validTotalDiscountAmount() {
        //given
        Amount amount = new Amount(0);

        //when
        Amount discount = christmasDDayEvent.process(
                VisitDate.from(25),
                amount,
                ReservationFixtures.createReservation());

        //then
        assertThat(discount.isEqualTo(3400)).isTrue();
    }
}