package christmas.domain.event;

import java.text.ParseException;

public class SpecialEvent extends Event {

    private static final String EVENT_NAME = "특별 할인";

    public SpecialEvent(String start, String end) throws ParseException {

        super(start, end, EVENT_NAME);
    }
}
