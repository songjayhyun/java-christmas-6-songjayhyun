package christmas.domain.event;

import christmas.domain.Amount;
import christmas.domain.Reservation;
import christmas.domain.discountpolicy.DiscountPoilcy;
import java.time.LocalDate;
import java.util.List;

public class SpecialEvent extends Event {

    private static final String EVENT_NAME = "특별 할인";
    private final List<Integer> starDays;
    private final DiscountPoilcy discountPolicy;

    public SpecialEvent(String start,
                        String end,
                        List<Integer> starDays,
                        DiscountPoilcy discountPolicy) {

        super(start, end, EVENT_NAME);
        this.starDays = starDays;
        this.discountPolicy = discountPolicy;
    }

    @Override
    boolean isEventActive(LocalDate localDate) {
        boolean isActivePeriod = super.isEventActive(localDate);

        boolean isStarDay = starDays.stream()
                .anyMatch(day -> day.equals(localDate.getDayOfMonth()));

        return (isActivePeriod && isStarDay);
    }

    @Override
    Amount process(LocalDate date, Amount amount, Reservation reservation) {
        if (isEventActive(date)) {
            int discount = discountPolicy.discount();
            return new Amount(discount);
        }
        return new Amount(0);
    }
}
