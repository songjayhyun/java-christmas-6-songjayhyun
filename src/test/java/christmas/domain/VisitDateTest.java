package christmas.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.exception.InvalidDateException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class VisitDateTest {

    @DisplayName("방문 날짜가 1 이상 31 이하의 숫자가 아닌 경우 예외 발생")
    @Test
    void invalidVisitDate() {
        assertThatThrownBy(() -> VisitDate.from(32))
                .isInstanceOf(InvalidDateException.class);
    }
}