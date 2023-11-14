package christmas.domain.event;

import christmas.domain.Amount;
import christmas.domain.Reservation;
import christmas.domain.category.Category;
import christmas.domain.discountpolicy.FixDiscountPolicy;
import java.text.ParseException;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class WeekendEvent extends Event {

    private static final String EVENT_NAME = "평일 할인";
    private static final int SUNDAY = DayOfWeek.SUNDAY.getValue();
    private static final int THURSDAY = DayOfWeek.THURSDAY.getValue();
    private final Category category;
    private final FixDiscountPolicy fixDiscountPolicy;

    public WeekendEvent(
            String startDate,
            String endDate,
            Category category,
            FixDiscountPolicy fixDiscountPolicy) throws ParseException {
        super(startDate, endDate, EVENT_NAME);
        this.category = category;
        this.fixDiscountPolicy = fixDiscountPolicy;
    }

    @Override
    boolean isEventActive(LocalDate localDate) {
        boolean isActivePeriod = super.isEventActive(localDate);

        boolean isWeekend = false;
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        int day = dayOfWeek.getValue();
        if (day >= SUNDAY || day <= THURSDAY) {
            isWeekend = true;
        }
        return (isActivePeriod && isWeekend);
    }

    @Override
    Amount process(LocalDate date, Amount amount, Reservation reservation) {
        if (isEventActive(date)) {
            int discount = fixDiscountPolicy.discount();
            int count = reservation.countDish(category);
            return new Amount(discount * count);
        }
        return new Amount(0);
    }
}
