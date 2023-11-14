package christmas.domain.event;

import java.text.ParseException;

public class ChristmasDdayEvent extends Event {
    public ChristmasDdayEvent(String start, String end) throws ParseException {
        super(start, end);
    }
}
