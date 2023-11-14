package christmas.domain;

import christmas.exception.InvalidDateException;
import java.time.LocalDate;

public class VisitDate {

    private static final int START_DATE_OF_MONTH = 1;
    private static final int END_DATE_OF_MONTH = 31;
    private final LocalDate date;

    private VisitDate(int date) {
        validateDate(date);
        this.date = LocalDate.of(2023, 12, date);
    }

    private void validateDate(int date) {
        if (date < START_DATE_OF_MONTH || date > END_DATE_OF_MONTH) {
            throw new InvalidDateException();
        }
    }

    public static VisitDate from(int date) {
        return new VisitDate(date);
    }
}
