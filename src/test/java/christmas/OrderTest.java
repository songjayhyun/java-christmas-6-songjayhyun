package christmas;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.domain.Order;
import christmas.exception.NoMenuExistsException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderTest {

    @DisplayName("메뉴판에 없는 메뉴를 주문하면 예외 발생.")
    @Test
    void orderDishNotInMenu() {
        assertThatThrownBy(() -> Order.of("루꼴라", 1))
                .isInstanceOf(NoMenuExistsException.class);
    }

    @DisplayName("메뉴 개수가 최소 메뉴 개수보다 낮으면 예외 발생")
    @Test
    void sizeUnderMinMenuSize() {
        assertThatThrownBy(() -> Order.of("루꼴라", 0))
                .isInstanceOf(NoMenuExistsException.class);
    }
}