package christmas.domain;

import christmas.domain.category.Category;
import christmas.domain.dish.Dish;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    List<Category> categories = new ArrayList<>();

    public void register(Category category) {
        categories.add(category);
    }

    public Dish findDish(String name) {
        for (Category category : categories) {
            Dish dish = category.findDish(name);
            if (dish != null) {
                return dish;
            }
        }
        return null;
    }

}
