package christmas.config;

import christmas.domain.Menu;
import christmas.domain.category.AppetizerCategory;
import christmas.domain.category.DessertCategory;
import christmas.domain.category.DrinkCategory;
import christmas.domain.category.MainCategory;
import christmas.domain.discountpolicy.FixDiscountPolicy;
import christmas.domain.dish.Dish;
import christmas.domain.dish.Drink;
import christmas.domain.event.ChristmasDDayEvent;
import christmas.domain.event.Event;
import christmas.domain.event.GiveawayEvent;
import christmas.domain.event.SpecialEvent;
import christmas.domain.event.WeekendEvent;
import christmas.domain.event.WeekdayEvent;
import java.util.ArrayList;
import java.util.List;

public class AppConfig implements Config {

    public static AppConfig getInstance() {
        return LazyHolder.INSTANCE;
    }

    @Override
    public Menu menu() {
        return LazyHolder.menu;
    }

    @Override
    public Event weekendEvent() {
        return LazyHolder.weekendEvent;
    }

    @Override
    public Event weekdayEvent() {
        return LazyHolder.weekdayEvent;
    }

    @Override
    public Event specialEvent() {
        return LazyHolder.specialEvent;
    }

    @Override
    public Event giveawayEvent() {
        return LazyHolder.giveawayEvent;
    }

    @Override
    public Event christmasDDayEvent() {
        return LazyHolder.christmasDdayEvent;
    }

    private static class LazyHolder {

        private static final String EVENT_START_DATE = "2023.12.01";
        private static final String EVENT_END_DATE = "2023.12.31";
        private static final String D_DAY_EVENT_END_DATE = "2023.12.25";
        private static final Event christmasDdayEvent = createChristmasDdayEvent();
        private static final int WEEKEND_EVENT_PRICE = 2023;
        private static final int WEEKDAY_EVENT_PRICE = 2023;
        private static final int SPECIAL_EVENT_PRICE = 1000;
        private static final List<Integer> STAR_DAYS = List.of(3, 10, 17, 24, 25, 31);
        private static final Event specialEvent = createSpecialEvent();
        private static final Event giveawayEvent = createGiveawayEvent();
        private static final Event weekdayEvent = createWeekendEvent();
        private static final AppConfig INSTANCE = new AppConfig();
        private static final Menu menu = createMenu();
        private static final Event weekendEvent = createWeekdayEvent();

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

        private static Event createWeekdayEvent() {
            return new WeekdayEvent(
                    EVENT_START_DATE,
                    EVENT_END_DATE,
                    dessertCategory(),
                    new FixDiscountPolicy(WEEKEND_EVENT_PRICE));
        }

        private static Event createWeekendEvent() {
            return new WeekendEvent(
                    EVENT_START_DATE,
                    EVENT_END_DATE,
                    mainCategory(),
                    new FixDiscountPolicy(WEEKDAY_EVENT_PRICE));
        }

        private static Event createSpecialEvent() {
            return new SpecialEvent(EVENT_START_DATE,
                    EVENT_END_DATE,
                    STAR_DAYS,
                    new FixDiscountPolicy(SPECIAL_EVENT_PRICE));
        }

        private static Event createGiveawayEvent() {
            List<Dish> dishes = new ArrayList<>();
            dishes.add(Drink.of("샴페인", 25_000));
            return new GiveawayEvent(EVENT_START_DATE, EVENT_END_DATE, dishes);
        }

        private static Event createChristmasDdayEvent() {
            return new ChristmasDDayEvent(EVENT_START_DATE, D_DAY_EVENT_END_DATE);
        }
    }

}