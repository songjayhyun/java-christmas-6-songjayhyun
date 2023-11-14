package christmas.config;

import christmas.domain.Menu;
import christmas.domain.event.ChristmasDdayEvent;
import christmas.domain.event.GiveawayEvent;
import christmas.domain.event.SpecialEvent;
import christmas.domain.event.WeekdayEvent;
import christmas.domain.event.WeekendEvent;

public interface Config {

    Menu menu();

    WeekendEvent weekendEvent();

    WeekdayEvent weekdayEvent();

    SpecialEvent specialEvent();

    GiveawayEvent giveawayEvent();

    ChristmasDdayEvent christmasDdayEvent();

}
