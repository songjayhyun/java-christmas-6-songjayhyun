package christmas.domain.category;

import christmas.domain.dish.Dish;
import christmas.domain.dish.Main;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MainCategory implements Category {

    private final List<Main> mains;

    public MainCategory() {
        mains = new ArrayList<>();
    }

    @Override
    public void register(String name, int price) {
        mains.add(Main.of(name, price));
    }

    @Override
    public Optional<Dish> findDish(String name) {
        return mains.stream()
                .filter(main -> main.contains(name))
                .map(main -> (Dish) main)
                .findAny();
    }

    @Override
    public Optional<Dish> findDish(Dish dish) {
        return mains.stream()
                .filter(main -> main.equals(dish))
                .map(main -> (Dish) main)
                .findAny();
    }

}
