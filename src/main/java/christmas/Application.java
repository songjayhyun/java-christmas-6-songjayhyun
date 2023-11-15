package christmas;

import christmas.config.AppConfig;
import christmas.config.Config;
import christmas.controller.ChristmasPromotion;

public class Application {
    public static void main(String[] args) {
        Config appConfig = createConfig();
        ChristmasPromotion christmasPromotion = appConfig.christmasPromotion();
        christmasPromotion.run();
    }
    private static Config createConfig() {
        return AppConfig.getInstance();
    }
}
