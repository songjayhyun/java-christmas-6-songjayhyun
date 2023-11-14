package christmas.config;

import christmas.domain.Menu;
import christmas.domain.category.AppetizerCategory;
import christmas.domain.category.DessertCategory;
import christmas.domain.category.DrinkCategory;
import christmas.domain.category.MainCategory;
import christmas.domain.event.ChristmasDdayEvent;
import christmas.domain.event.GiveawayEvent;
import christmas.domain.event.SpecialEvent;
import christmas.domain.event.WeekdayEvent;
import christmas.domain.event.WeekendEvent;

public class AppConfig implements Config {

    public static AppConfig getInstance() {
        return LazyHolder.INSTANCE;
    }

    @Override
    public Menu menu() {
        return LazyHolder.menu;
    }

    @Override
    public WeekendEvent weekendEvent() {
        return LazyHolder.weekendEvent;
    }

    @Override
    public WeekdayEvent weekdayEvent() {
        return LazyHolder.weekdayEvent;
    }

    @Override
    public SpecialEvent specialEvent() {
        return LazyHolder.specialEvent;
    }

    @Override
    public GiveawayEvent giveawayEvent() {
        return LazyHolder.giveawayEvent;
    }

    @Override
    public ChristmasDdayEvent christmasDdayEvent() {
        return LazyHolder.christmasDdayEvent;
    }

    private static class LazyHolder {
        public static final WeekdayEvent weekdayEvent = createWeekdayEvent();
        public static final SpecialEvent specialEvent = createSpecialEvent();
        public static final GiveawayEvent giveawayEvent = createGiveawayEvent();
        public static final ChristmasDdayEvent christmasDdayEvent = createChristmasDdayEvent();
        private static final AppConfig INSTANCE = new AppConfig();
        private static final Menu menu = createMenu();
        private static final WeekendEvent weekendEvent = createWeekendEvent();

        private static Menu createMenu() {
            Menu menu = Menu.getInstance();
            menu.register(appetizerCategory());
            menu.register(drinkCategory());
            menu.register(mainCategory());
            menu.register(dessertCategory());
            return menu;
        }

        private static AppetizerCategory appetizerCategory() {
            AppetizerCategory appetizerCategory = new AppetizerCategory();
            appetizerCategory.register("양송이수프", 6000);
            appetizerCategory.register("타파스", 5500);
            appetizerCategory.register("시저샐러드", 8000);
            return appetizerCategory;
        }

        private static DrinkCategory drinkCategory() {
            DrinkCategory drinkCategory = new DrinkCategory();
            drinkCategory.register("제로콜라", 3000);
            drinkCategory.register("레드와인", 60_000);
            drinkCategory.register("샴페인", 25_000);
            return drinkCategory;
        }

        private static MainCategory mainCategory() {
            MainCategory mainCategory = new MainCategory();
            mainCategory.register("티본스테이크", 55_000);
            mainCategory.register("바비큐립", 54_000);
            mainCategory.register("해산물파스타", 35_000);
            mainCategory.register("크리스마스파스타", 25_000);
            return mainCategory;
        }

        private static DessertCategory dessertCategory() {
            DessertCategory dessertCategory = new DessertCategory();
            dessertCategory.register("초코케이크", 15_000);
            dessertCategory.register("아이스크림", 5_000);
            return dessertCategory;
        }

        private static WeekendEvent createWeekendEvent() {
            return null;
        }

        private static ChristmasDdayEvent createChristmasDdayEvent() {
            return null;
        }

        private static WeekdayEvent createWeekdayEvent() {
            return null;
        }


        private static SpecialEvent createSpecialEvent() {
            return null;
        }

        private static GiveawayEvent createGiveawayEvent() {
            return null;
        }

    }
}