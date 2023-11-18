package christmas.domain.category;

import christmas.domain.dish.Dish;
import java.util.Optional;

public interface Category {

    void register(String name, int price);

    Optional<Dish> findDish(String name);

    Optional<Dish> findDish(Dish dish);

}
