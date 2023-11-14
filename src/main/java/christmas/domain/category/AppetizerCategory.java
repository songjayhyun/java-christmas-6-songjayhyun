package christmas.domain.category;

import christmas.domain.dish.Appetizer;
import christmas.domain.dish.Dish;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AppetizerCategory implements Category {

    private final List<Appetizer> appetizers;

    public AppetizerCategory() {
        appetizers = new ArrayList<>();
    }

    @Override
    public Optional<Dish> findDish(String name) {
        return appetizers.stream()
                .filter(appetizer -> appetizer.contains(name))
                .map(appetizer -> (Dish) appetizer)
                .findAny();
    }

    @Override
    public Optional<Dish> findDish(Dish dish) {
        return appetizers.stream()
                .filter(appetizer -> appetizer.equals(dish))
                .map(appetizer -> (Dish) appetizer)
                .findAny();
    }
    
    @Override
    public void register(String name, int price) {
        appetizers.add(Appetizer.of(name, price));
    }
}
