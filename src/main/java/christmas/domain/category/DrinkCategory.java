package christmas.domain.category;

import christmas.domain.dish.Drink;
import java.util.ArrayList;
import java.util.List;

public class DrinkCategory implements Category {

    private final List<Drink> drinks = new ArrayList<>();

    @Override
    public void register(String name, int price) {
        drinks.add(Drink.of(name, price));
    }

    @Override
    public boolean isMenuRegistered(String name) {
        return drinks.stream()
                .anyMatch(drink -> drink.contains(name));
    }

}
