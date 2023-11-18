package christmas.domain.category;

import christmas.domain.dish.Dish;
import christmas.domain.dish.Drink;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DrinkCategory implements Category {

    private final List<Drink> drinks = new ArrayList<>();

    @Override
    public void register(String name, int price) {
        drinks.add(Drink.of(name, price));
    }

    @Override
    public Optional<Dish> findDish(String name) {
        return drinks.stream()
                .filter(drink -> drink.contains(name))
                .map(drink -> (Dish) drink)
                .findAny();
    }

    @Override
    public Optional<Dish> findDish(Dish dish) {
        return drinks.stream()
                .filter(drink -> drink.equals(dish))
                .map(drink -> (Dish) drink)
                .findAny();
    }

}
