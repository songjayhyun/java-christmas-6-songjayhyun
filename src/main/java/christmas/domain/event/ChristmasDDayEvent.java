package christmas.domain.event;

import christmas.domain.Amount;
import christmas.domain.Reservation;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ChristmasDDayEvent extends Event {

    private static final String EVENT_NAME = "크리스마스 디데이 할인";
    private static final int START_AMOUNT = 1000;
    private static final int DAY_INCREASE_AMOUNT = 100;

    private final LocalDate startDate = LocalDate.of(2023, 12, 1);

    public ChristmasDDayEvent(String start, String end) throws ParseException {
        super(start, end, EVENT_NAME);
    }

    @Override
    Amount process(LocalDate date, Amount amount, Reservation reservation) {
        if (isEventActive(date)) {
            int days = (int) ChronoUnit.DAYS.between(startDate, date);
            int totalAmount = START_AMOUNT + (days * DAY_INCREASE_AMOUNT);
            return new Amount(totalAmount);
        }
        return new Amount(0);
    }
}
