package christmas.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AmountTest {

    @DisplayName("총 금액은 10000원 이상이어야 이벤트가 적용된다.")
    @Test
    void isEventable() {
        //given
        Amount amount = new Amount(5000);

        //when then
        Assertions.assertThat(amount.isEventActive()).isFalse();
    }
}