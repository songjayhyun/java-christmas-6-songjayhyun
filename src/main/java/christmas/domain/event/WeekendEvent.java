package christmas.domain.event;

import christmas.domain.Amount;
import christmas.domain.Reservation;
import christmas.domain.category.Category;
import christmas.domain.discountpolicy.DiscountPoilcy;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class WeekendEvent extends Event {

    private static final String EVENT_NAME = "주말 할인";
    private static final int FRIDAY = DayOfWeek.FRIDAY.getValue();
    private static final int SATURDAY = DayOfWeek.SATURDAY.getValue();
    private final Category category;
    private final DiscountPoilcy discountPolicy;

    public WeekendEvent(String start,
                        String end,
                        Category category,
                        DiscountPoilcy discountPolicy) {
        super(start, end, EVENT_NAME);
        this.category = category;
        this.discountPolicy = discountPolicy;
    }

    @Override
    boolean isEventActive(LocalDate localDate) {
        boolean isActivePeriod = super.isEventActive(localDate);

        boolean isWeekday = false;
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        int day = dayOfWeek.getValue();
        if (day >= FRIDAY || day <= SATURDAY) {
            isWeekday = true;
        }
        return (isActivePeriod && isWeekday);
    }

    @Override
    Amount process(LocalDate date, Amount amount, Reservation reservation) {
        if (isEventActive(date)) {
            int discount = discountPolicy.discount();
            int count = reservation.countDish(category);
            return new Amount(discount * count);
        }
        return new Amount(0);
    }
}
