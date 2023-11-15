package christmas.config;

import christmas.controller.ChristmasPromotion;
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
import christmas.domain.event.Events;
import christmas.domain.event.GiveawayEvent;
import christmas.domain.event.SpecialEvent;
import christmas.domain.event.WeekdayEvent;
import christmas.domain.event.WeekendEvent;
import christmas.io.ConsoleReader;
import christmas.io.ConsoleWriter;
import christmas.service.EventService;
import christmas.service.MenuService;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class AppConfig implements Config {

    public static AppConfig getInstance() {
        return LazyHolder.INSTANCE;
    }

    @Override
    public ChristmasPromotion christmasPromotion() {
        return LazyHolder.christmasPromotion;
    }

    @Override
    public Menu menu() {
        return LazyHolder.menu;
    }

    @Override
    public Events events() {
        return LazyHolder.events;
    }

    private static class LazyHolder {

        private static final AppConfig INSTANCE = new AppConfig();
        private static final String EVENT_START_DATE = "2023.12.01";
        private static final String EVENT_END_DATE = "2023.12.31";
        private static final String D_DAY_EVENT_END_DATE = "2023.12.25";
        private static final Menu menu = createMenu();
        public static Events events = createEvents();
        public static ChristmasPromotion christmasPromotion = createChristmasPromotion();

        private static ChristmasPromotion createChristmasPromotion() {
            return new ChristmasPromotion(
                    createInputView(),
                    createOutputView(),
                    createMenuService(),
                    createEventService());
        }

        private static InputView createInputView() {
            return new InputView(new ConsoleReader());
        }

        private static OutputView createOutputView() {
            return new OutputView(new ConsoleWriter());
        }

        private static MenuService createMenuService() {
            return new MenuService(createInputView());
        }

        private static EventService createEventService() {
            return new EventService(events);
        }

        private static Menu createMenu() {
            Menu menu = Menu.getInstance();
            menu.register(appetizerCategory());
            menu.register(drinkCategory());
            menu.register(mainCategory());
            menu.register(dessertCategory());
            return menu;
        }

        private static Events createEvents() {
            List<Event> events = new ArrayList<>();
            events.add(christmasDdayEvent());
            events.add(specialEvent());
            events.add(weekendEvent());
            events.add(weekdayEvent());
            events.add(giveawayEvent());
            return new Events(events);
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

        private static Event weekendEvent() {
            final int WEEKEND_EVENT_PRICE = 2023;

            return new WeekendEvent(
                    EVENT_START_DATE,
                    EVENT_END_DATE,
                    dessertCategory(),
                    new FixDiscountPolicy(WEEKEND_EVENT_PRICE));
        }

        private static Event weekdayEvent() {
            final int WEEKDAY_EVENT_PRICE = 2023;

            return new WeekdayEvent(
                    EVENT_START_DATE,
                    EVENT_END_DATE,
                    mainCategory(),
                    new FixDiscountPolicy(WEEKDAY_EVENT_PRICE));
        }

        private static Event specialEvent() {
            final int SPECIAL_EVENT_PRICE = 1000;
            final List<Integer> STAR_DAYS = List.of(3, 10, 17, 24, 25, 31);

            return new SpecialEvent(EVENT_START_DATE,
                    EVENT_END_DATE,
                    STAR_DAYS,
                    new FixDiscountPolicy(SPECIAL_EVENT_PRICE));
        }

        private static Event giveawayEvent() {
            List<Dish> dishes = new ArrayList<>();
            dishes.add(Drink.of("샴페인", 25_000));
            return new GiveawayEvent(EVENT_START_DATE, EVENT_END_DATE, dishes);
        }

        private static Event christmasDdayEvent() {
            return new ChristmasDDayEvent(EVENT_START_DATE, D_DAY_EVENT_END_DATE);
        }
    }

}