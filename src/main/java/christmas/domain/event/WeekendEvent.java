package christmas.domain.event;

import java.text.ParseException;

public class WeekendEvent extends Event {
    public WeekendEvent(String start, String end) throws ParseException {
        super(start, end);
    }

}
