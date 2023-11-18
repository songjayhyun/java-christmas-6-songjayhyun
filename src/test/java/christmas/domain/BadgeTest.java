package christmas.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BadgeTest {

    @DisplayName("총 혜택 금액에 따른 배지 부여가 되어야 한다")
    @Test
    void name() {
        //given
        Amount amount = new Amount(5000);

        //when
        Badge badge = Badge.from(amount);

        //then
        Assertions.assertThat(badge).isEqualTo(Badge.STAR);
    }
}