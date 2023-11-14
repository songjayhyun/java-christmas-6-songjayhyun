package christmas.domain.event;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.config.AppConfig;
import christmas.domain.Amount;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GiveawayEventTest {

    private final AppConfig appConfig = AppConfig.getInstance();
    private Event giveawayEvent;

    @BeforeEach
    void setUp() {
        giveawayEvent = appConfig.giveawayEvent();
    }

    @DisplayName("총 주문 금액이 12만원 이상이면 이벤트가 적용된다")
    @Test
    void eventActive() {
        //given
        LocalDate localDate = LocalDate.of(2023, 12, 4);
        Amount amount = new Amount(13_0000);

        //when
        Amount giveawayAmount = giveawayEvent.process(localDate, amount);

        //then
        assertThat(giveawayAmount.isEqualTo(25_000)).isEqualTo(true);
    }

    @DisplayName("총 주문 금액이 12만원 미만이면 이벤트가 적용되지 않는다.")
    @Test
    void eventInActive() {
        //given
        LocalDate localDate = LocalDate.of(2023, 12, 4);
        Amount amount = new Amount(10_0000);

        //when
        Amount giveawayAmount = giveawayEvent.process(localDate, amount);

        //then
        assertThat(giveawayAmount.isEqualTo(25_000)).isEqualTo(false);
    }

    @DisplayName("증정 아이템은 샴페인이어야 한다.")
    @Test
    void differentGiveawayItem() {
        //when then
        if (giveawayEvent instanceof GiveawayEvent giveawayEvent1) {
            assertThat(giveawayEvent1.getDish().getPrice()).isEqualTo(25_000);
        }
    }

    @DisplayName("12월 1일에서 12월 31일이 아니면 이벤트 적용이 되지 않는다.")
    @Test
    void eventActiveDate() {
        //given
        LocalDate localDate = LocalDate.of(2023, 11, 4);

        //when then
        assertThat(giveawayEvent.isEventActive(localDate)).isFalse();
    }
}