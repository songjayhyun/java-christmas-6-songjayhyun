package christmas.domain;

import christmas.exception.InvalidDateException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class VisitDate {

    private static final int START_DATE_OF_MONTH = 1;
    private static final int END_DATE_OF_MONTH = 31;
    private final LocalDate date;

    private VisitDate(int date) {
        validateDate(date);
        this.date = LocalDate.of(2023, 12, date);
    }

    public static VisitDate from(int date) {
        return new VisitDate(date);
    }

    public boolean isAfter(LocalDate date) {
        return this.date.isAfter(date);
    }

    public boolean isBefore(LocalDate date) {
        return this.date.isBefore(date);
    }

    private void validateDate(int date) {
        if (date < START_DATE_OF_MONTH || date > END_DATE_OF_MONTH) {
            throw new InvalidDateException();
        }
    }

    public Integer getDayOfMonth() {
        return this.date.getDayOfMonth();
    }

    public DayOfWeek getDayOfWeek() {
        return this.date.getDayOfWeek();
    }

    public int getBetweenDays(LocalDate date) {
        return (int) ChronoUnit.DAYS.between(date, this.date);
    }
}
