package christmas.domain.event;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.config.AppConfig;
import christmas.domain.Amount;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ChristmasDDayEventTest {

    private final AppConfig appConfig = AppConfig.getInstance();
    private Event christmasDDayEvent;

    @BeforeEach
    void setUp() {
        christmasDDayEvent = appConfig.christmasDDayEvent();
    }

    @DisplayName("이벤트 기간에 이벤트가 적용되지 않는다.")
    @Test
    void eventActiveDate() {
        //given
        LocalDate localDate = LocalDate.of(2023, 11, 4);

        //when then
        assertThat(christmasDDayEvent.isEventActive(localDate)).isFalse();
    }

    @DisplayName("1일에 1000원으로 시작한다.")
    @Test
    void checkStartAmount() {
        //given
        LocalDate localDate = LocalDate.of(2023, 12, 1);
        Amount amount = new Amount(0);

        //when
        Amount discount = christmasDDayEvent.process(localDate, amount);

        //then
        assertThat(discount.isEqualTo(1000)).isTrue();
    }

    @DisplayName("매일 100원씩 증가한다.")
    @Test
    void checkDayIncreaseAmount() {
        //given
        LocalDate localDate = LocalDate.of(2023, 12, 2);
        Amount amount = new Amount(0);

        //when
        Amount discount = christmasDDayEvent.process(localDate, amount);

        //then
        assertThat(discount.isEqualTo(1100)).isTrue();
    }

    @DisplayName("총 할인 금액이 정확해야 한다.")
    @Test
    void validTotalDiscountAmount() {
        //given
        LocalDate localDate = LocalDate.of(2023, 12, 25);
        Amount amount = new Amount(0);

        //when
        Amount discount = christmasDDayEvent.process(localDate, amount);

        //then
        assertThat(discount.isEqualTo(3400)).isTrue();
    }
}