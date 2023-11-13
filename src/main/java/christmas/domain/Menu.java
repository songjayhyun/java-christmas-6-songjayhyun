package christmas.domain;

import christmas.domain.category.Category;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    List<Category> categories = new ArrayList<>();

    public void register(Category category) {
        categories.add(category);
    }

    public boolean isMenuRegistered(String name) {
        return categories.stream()
                .anyMatch(category -> category.isMenuRegistered(name));
    }

}
