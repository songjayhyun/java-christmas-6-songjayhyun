package christmas.domain.event;

import christmas.domain.Amount;
import christmas.domain.GiveawayMenu;
import christmas.domain.Reservation;
import christmas.domain.VisitDate;
import christmas.domain.dish.Dish;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GiveawayEvent extends Event {

    private static final int GIVEAWAY_EVENT_MIN_PRICE = 120_000;
    private static final String EVENT_NAME = "증정 이벤트";
    private final List<Dish> dishes;

    public GiveawayEvent(String startDate, String endDate, List<Dish> dishes) {
        super(startDate, endDate, EVENT_NAME);
        this.dishes = dishes;
    }

    @Override
    public Amount process(VisitDate date, Amount amount, Reservation reservation) {
        if (amount.isMoreThan(GIVEAWAY_EVENT_MIN_PRICE)) {
            int totalPrice = 0;
            for (Dish dish : dishes) {
                totalPrice += dish.getPrice();
            }
            return new Amount(totalPrice);
        }
        return new Amount(0);
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public List<GiveawayMenu> getGiveawayMenus() {
        List<GiveawayMenu> giveawayMenus = new ArrayList<>();

        Map<String, Integer> dishCounter = countDishes();
        for (Map.Entry<String, Integer> entry : dishCounter.entrySet()) {
            giveawayMenus.add(new GiveawayMenu(entry.getKey(), entry.getValue()));
        }
        return giveawayMenus;
    }

    private Map<String, Integer> countDishes() {
        Map<String, Integer> dishCounter = new HashMap<>();

        for (Dish dish : dishes) {
            dishCounter.put(dish.getName(), dishCounter.getOrDefault(dish.getName(), 0) + 1);
        }
        return dishCounter;
    }

}
