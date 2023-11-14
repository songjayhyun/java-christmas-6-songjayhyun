package christmas.domain.event;

import java.text.ParseException;

public class WeekendEvent extends Event {

    private static final String EVENT_NAME = "평일 할인";
    public WeekendEvent(String start, String end) throws ParseException {
        super(start, end,EVENT_NAME);
    }

}
