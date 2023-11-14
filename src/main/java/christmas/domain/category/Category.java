package christmas.domain.category;

import christmas.domain.dish.Dish;

public interface Category {

    void register(String name, int price);

    Dish findDish(String name);

}
