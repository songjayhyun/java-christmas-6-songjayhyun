package christmas.config;

import christmas.domain.Menu;
import christmas.domain.event.Event;

public interface Config {

    Menu menu();

    Event weekendEvent();

    Event weekdayEvent();

    Event specialEvent();

    Event giveawayEvent();

    Event christmasDDayEvent();

}
