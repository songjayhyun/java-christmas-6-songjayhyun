package christmas.domain.event;

import java.text.ParseException;

public class WeekdayEvent extends Event {

    public WeekdayEvent(String start, String end) throws ParseException {
        super(start, end);
    }
}
