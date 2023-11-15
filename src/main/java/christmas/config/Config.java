package christmas.config;

import christmas.controller.ChristmasPromotion;
import christmas.domain.Menu;

public interface Config {

    ChristmasPromotion christmasPromotion();

    Menu menu();

}
