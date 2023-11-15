package christmas.domain.event;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.Amount;
import christmas.domain.category.DessertCategory;
import christmas.domain.discountpolicy.FixDiscountPolicy;
import christmas.fixtures.LocalDateFixtures;
import christmas.fixtures.ReservationFixtures;
import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WeekdayEventTest {

    private final Event weekdayEvent = new WeekdayEvent(
            "2023.12.01",
            "2023.12.31",
            createDessertCategory(),
            new FixDiscountPolicy(2023)
    );

    private DessertCategory createDessertCategory() {
        DessertCategory dessertCategory = new DessertCategory();
        dessertCategory.register("초코케이크", 15_000);
        dessertCategory.register("아이스크림", 5_000);
        return dessertCategory;
    }

    @DisplayName("일요일부터 목요일이라면 이벤트가 적용된다.")
    @Test
    void eventActiveDuringWeekday() {
        //when
        LocalDate weekdayDate = LocalDateFixtures.createWeekdayDate();

        //then
        assertThat(weekdayEvent.isEventActive(weekdayDate)).isTrue();
    }

    @DisplayName("주문에 디저트 메뉴가 없다면 할인 대상이 안된다.")
    @Test
    void noDessertNoDiscount() {
        Amount amount = weekdayEvent.process(
                LocalDateFixtures.createWeekdayDate(),
                new Amount(10000),
                ReservationFixtures.createReservationWithNoDessert()
        );
        assertThat(amount.isEqualTo(0)).isTrue();
    }

    @DisplayName("총 할인 금액이 다르다")
    @Test
    void checkValidDiscountAmount() {
        Amount amount = weekdayEvent.process(
                LocalDateFixtures.createWeekdayDate(),
                new Amount(10000),
                ReservationFixtures.createReservationWithDesserts()
        );
        assertThat(amount.isEqualTo(4046)).isTrue();
    }

}