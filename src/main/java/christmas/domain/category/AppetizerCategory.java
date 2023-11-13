package christmas.domain.category;

import christmas.domain.dish.Appetizer;
import java.util.ArrayList;
import java.util.List;

public class AppetizerCategory implements Category {

    private final List<Appetizer> appetizers;

    public AppetizerCategory() {
        appetizers = new ArrayList<>();
    }

    @Override
    public boolean isMenuRegistered(String name) {
        return appetizers.stream()
                .anyMatch(appetizer -> appetizer.contains(name));
    }

    @Override
    public void register(String name, int price) {
        appetizers.add(Appetizer.of(name, price));
    }
}
