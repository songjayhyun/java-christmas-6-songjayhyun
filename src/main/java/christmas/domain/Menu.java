package christmas.domain;

import christmas.domain.category.Category;
import christmas.domain.dish.Dish;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Menu {
    private static final Menu instance = new Menu();
    final List<Category> categories = new ArrayList<>();

    private Menu() {
    }

    public static Menu getInstance() {
        return instance;
    }

    public void register(Category category) {
        categories.add(category);
    }

    public Optional<Dish> findDish(String name) {
        return categories.stream()
                .map(category -> category.findDish(name))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findAny();
    }

    public Optional<Dish> findDish(Dish dish) {
        return categories.stream()
                .map(category -> category.findDish(dish))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findAny();
    }
}
