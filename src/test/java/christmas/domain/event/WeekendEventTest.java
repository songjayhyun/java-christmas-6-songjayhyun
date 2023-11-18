package christmas.domain.event;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.Amount;
import christmas.domain.VisitDate;
import christmas.domain.category.MainCategory;
import christmas.domain.discountpolicy.FixDiscountPolicy;
import christmas.fixtures.ReservationFixtures;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WeekendEventTest {

    private final Event weekendEvent = new WeekendEvent(
            "2023.12.01",
            "2023.12.31",
            createMainCategory(),
            new FixDiscountPolicy(2023)
    );

    private final VisitDate VISIT_DATE = VisitDate.from(9);

    private MainCategory createMainCategory() {
        MainCategory mainCategory = new MainCategory();
        mainCategory.register("티본스테이크", 55_000);
        mainCategory.register("바비큐립", 54_000);
        mainCategory.register("해산물파스타", 35_000);
        mainCategory.register("크리스마스파스타", 25_000);
        return mainCategory;
    }

    @DisplayName("금요일부터 토요일이라면 이벤트가 적용된다.")
    @Test
    void eventActiveDuringWeekend() {
        assertThat(weekendEvent.isEventActive(VISIT_DATE)).isTrue();
    }

    @DisplayName("주문에 메인 메뉴가 없다면 할인 대상이 안된다.")
    @Test
    void noDessertNoDiscount() {
        Amount amount = weekendEvent.process(
                VISIT_DATE,
                new Amount(10000),
                ReservationFixtures.createReservationWithNoMain()
        );
        assertThat(amount.isEqualTo(0)).isTrue();
    }

    @DisplayName("총 할인 금액이 다르다")
    @Test
    void checkValidDiscountAmount() {
        Amount amount = weekendEvent.process(
                VISIT_DATE,
                new Amount(10000),
                ReservationFixtures.createReservationWithMains()
        );
        assertThat(amount.isEqualTo(4046)).isTrue();
    }
}