package christmas.config;

import christmas.controller.ChristmasPromotion;
import christmas.domain.Menu;
import christmas.domain.event.Events;

public interface Config {

    ChristmasPromotion christmasPromotion();

    Menu menu();

    Events events();

}
