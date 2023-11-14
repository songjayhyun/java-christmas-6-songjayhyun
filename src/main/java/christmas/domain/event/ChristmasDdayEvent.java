package christmas.domain.event;

import java.text.ParseException;

public class ChristmasDdayEvent extends Event {

    private static final String EVENT_NAME = "크리스마스 디데이 할인";

    public ChristmasDdayEvent(String start, String end) throws ParseException {
        super(start, end, EVENT_NAME);
    }
}
