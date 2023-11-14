package christmas.domain.event;

import christmas.domain.Amount;
import christmas.domain.Reservation;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Event {

    private final LocalDate startDate;
    private final LocalDate endDate;

    private final String name;

    public Event(String start, String end, String name) {
        this.startDate = parseDate(start);
        this.endDate = parseDate(end);
        this.name = name;
    }

    private static LocalDate parseDate(String date) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy.MM.dd"));
    }

    boolean isEventActive(LocalDate localDate) {
        if (localDate.isAfter(endDate) || localDate.isBefore(startDate)) {
            return false;
        }
        return true;
    }

    Amount process(LocalDate date, Amount amount, Reservation reservation) {
        return new Amount(0);
    }

    public String getName() {
        return name;
    }
}
