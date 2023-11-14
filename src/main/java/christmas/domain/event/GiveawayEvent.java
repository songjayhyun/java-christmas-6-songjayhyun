package christmas.domain.event;

import java.text.ParseException;

public class GiveawayEvent extends Event {

    private static final int GIVEAWAY_EVENT_MIN_PRICE = 120_000;

    public GiveawayEvent(String startDate, String endDate) throws ParseException {
        super(startDate, endDate);
    }

}
