package christmas.domain.category;

import christmas.domain.dish.Appetizer;
import christmas.domain.dish.Dish;
import java.util.ArrayList;
import java.util.List;

public class AppetizerCategory implements Category {

    private final List<Appetizer> appetizers;

    public AppetizerCategory() {
        appetizers = new ArrayList<>();
    }

    @Override
    public Dish findDish(String name) {
        return appetizers.stream()
                .filter(appetizer -> appetizer.contains(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void register(String name, int price) {
        appetizers.add(Appetizer.of(name, price));
    }
}
