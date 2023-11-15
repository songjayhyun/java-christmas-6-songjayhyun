package christmas.domain.event;

import christmas.domain.Amount;
import christmas.domain.Reservation;
import christmas.domain.VisitDate;
import christmas.domain.discountpolicy.DiscountPoilcy;
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
    public boolean isEventActive(VisitDate visitDate) {
        boolean isActivePeriod = super.isEventActive(visitDate);

        boolean isStarDay = starDays.stream()
                .anyMatch(day -> day.equals(visitDate.getDayOfMonth()));

        return (isActivePeriod && isStarDay);
    }

    @Override
    public Amount process(VisitDate date, Amount amount, Reservation reservation) {
        if (isEventActive(date)) {
            int discount = discountPolicy.discount();
            return new Amount(discount);
        }
        return new Amount(0);
    }
}
