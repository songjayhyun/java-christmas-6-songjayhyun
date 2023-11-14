package christmas.domain.event;

import java.text.ParseException;

public class WeekdayEvent extends Event {

    private static final String EVENT_NAME = "주말 할인";

    public WeekdayEvent(String start, String end) throws ParseException {
        super(start, end, EVENT_NAME);
    }
}
