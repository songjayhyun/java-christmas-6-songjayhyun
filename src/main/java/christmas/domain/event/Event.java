package christmas.domain.event;

import christmas.domain.Amount;
import christmas.domain.Reservation;
import christmas.domain.VisitDate;
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

    public boolean isEventActive(VisitDate visitDate) {
        if (visitDate.isAfter(endDate) || visitDate.isBefore(startDate)) {
            return false;
        }
        return true;
    }

    public Amount process(VisitDate date, Amount amount, Reservation reservation) {
        return new Amount(0);
    }

    public String getName() {
        return name;
    }
}
