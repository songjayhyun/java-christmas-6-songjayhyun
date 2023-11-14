package christmas.domain.event;

import java.text.ParseException;

public class SpecialEvent extends Event {

    public SpecialEvent(String start, String end) throws ParseException {
        super(start, end);
    }
}
