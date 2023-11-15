package christmas.domain.event;

import christmas.domain.Amount;
import christmas.domain.Reservation;
import christmas.domain.VisitDate;
import christmas.domain.dish.Dish;
import java.time.LocalDate;
import java.util.List;

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
}
