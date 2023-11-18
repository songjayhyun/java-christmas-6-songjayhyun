package christmas.domain.event;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.Amount;
import christmas.domain.VisitDate;
import christmas.domain.dish.Dish;
import christmas.fixtures.ReservationFixtures;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GiveawayEventTest {

    private final Event giveawayEvent = new GiveawayEvent(
            "2023.12.01",
            "2023.12.25",
            List.of(new Dish("샴페인", 25_000)));

    private final VisitDate VISIT_DATE = VisitDate.from(4);

    @DisplayName("총 주문 금액이 12만원 이상이면 이벤트가 적용된다")
    @Test
    void eventActive() {
        //given
        Amount amount = new Amount(13_0000);

        //when
        Amount giveawayAmount = giveawayEvent.process(
                VisitDate.from(4),
                amount,
                ReservationFixtures.createReservation());

        //then
        assertThat(giveawayAmount.isEqualTo(25_000)).isEqualTo(true);
    }

    @DisplayName("총 주문 금액이 12만원 미만이면 이벤트가 적용되지 않는다.")
    @Test
    void eventInActive() {
        //given
        Amount amount = new Amount(10_0000);

        //when
        Amount giveawayAmount = giveawayEvent.process(
                VISIT_DATE,
                amount,
                ReservationFixtures.createReservation());

        //then
        assertThat(giveawayAmount.isEqualTo(25_000)).isEqualTo(false);
    }

    @DisplayName("증정 아이템은 샴페인이어야 한다.")
    @Test
    void differentGiveawayItem() {
        //given
        Amount amount = new Amount(13_0000);

        //when
        Amount giveawayAmount = giveawayEvent.process(
                VISIT_DATE,
                amount,
                ReservationFixtures.createReservation());

        //then
        assertThat(giveawayAmount.isEqualTo(25_000)).isEqualTo(true);
    }

    @DisplayName("12월 1일에서 12월 31일이면 이벤트 적용이 된다.")
    @Test
    void eventActiveDate() {
        //when then
        assertThat(giveawayEvent.isEventActive(VISIT_DATE)).isTrue();
    }
}