package christmas.domain.category;

import christmas.domain.dish.Dessert;
import christmas.domain.dish.Dish;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DessertCategory implements Category {

    private final List<Dessert> desserts = new ArrayList<>();

    @Override
    public void register(String name, int price) {
        desserts.add(Dessert.of(name, price));
    }

    @Override
    public Optional<Dish> findDish(String name) {
        return desserts.stream()
                .filter(dessert -> dessert.contains(name))
                .map(dessert -> (Dish) dessert)
                .findAny();
    }

    @Override
    public Optional<Dish> findDish(Dish dish) {
        return desserts.stream()
                .filter(dessert -> dessert.equals(dish))
                .map(dessert -> (Dish) dessert)
                .findAny();
    }


}
