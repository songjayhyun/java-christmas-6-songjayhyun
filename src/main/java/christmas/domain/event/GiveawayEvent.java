package christmas.domain.event;

import christmas.domain.Amount;
import christmas.domain.Reservation;
import christmas.domain.dish.Dish;
import java.time.LocalDate;

public class GiveawayEvent extends Event {

    private static final int GIVEAWAY_EVENT_MIN_PRICE = 120_000;
    private static final String EVENT_NAME = "증정 이벤트";
    private final Dish dish;

    public GiveawayEvent(String startDate, String endDate, Dish dish) {
        super(startDate, endDate, EVENT_NAME);
        this.dish = dish;
    }

    @Override
    Amount process(LocalDate date, Amount amount, Reservation reservation) {
        if (amount.isMoreThan(GIVEAWAY_EVENT_MIN_PRICE)) {
            return new Amount(dish.getPrice());
        }
        return new Amount(0);
    }

    public Dish getDish() {
        return dish;
    }
}
