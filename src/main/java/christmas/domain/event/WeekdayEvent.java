package christmas.domain.event;

import christmas.domain.Amount;
import christmas.domain.Reservation;
import christmas.domain.VisitDate;
import christmas.domain.category.Category;
import christmas.domain.discountpolicy.DiscountPoilcy;
import java.time.DayOfWeek;

public class WeekdayEvent extends Event {

    private static final String EVENT_NAME = "평일 할인";
    private static final int SUNDAY = DayOfWeek.SUNDAY.getValue();
    private static final int THURSDAY = DayOfWeek.THURSDAY.getValue();
    private final Category category;
    private final DiscountPoilcy discountPolicy;

    public WeekdayEvent(
            String startDate,
            String endDate,
            Category category,
            DiscountPoilcy discountPolicy) {
        super(startDate, endDate, EVENT_NAME);
        this.category = category;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public boolean isEventActive(VisitDate visitDate) {
        boolean isActivePeriod = super.isEventActive(visitDate);

        boolean isWeekend = false;
        DayOfWeek dayOfWeek = visitDate.getDayOfWeek();
        int day = dayOfWeek.getValue();
        if (day >= SUNDAY || day <= THURSDAY) {
            isWeekend = true;
        }
        return (isActivePeriod && isWeekend);
    }

    @Override
    public Amount process(VisitDate date, Amount amount, Reservation reservation) {
        if (isEventActive(date)) {
            int discount = discountPolicy.discount();
            int count = reservation.countDish(category);
            return new Amount(discount * count);
        }
        return new Amount(0);
    }
}
