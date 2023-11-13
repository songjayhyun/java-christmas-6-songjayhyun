package christmas.domain.category;

import christmas.domain.dish.Dessert;
import java.util.ArrayList;
import java.util.List;

public class DessertCategory implements Category {

    private final List<Dessert> desserts = new ArrayList<>();

    @Override
    public void register(String name, int price) {
        desserts.add(Dessert.of(name, price));
    }

    @Override
    public boolean isMenuRegistered(String name) {
        return desserts.stream()
                .anyMatch(dessert -> dessert.contains(name));
    }

}
