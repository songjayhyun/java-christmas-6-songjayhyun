package christmas;

import christmas.config.AppConfig;
import christmas.domain.Menu;
import christmas.domain.dish.Dish;
import christmas.exception.InvalidMenuQuantityException;
import christmas.exception.NoMenuExistsException;

public class Order {

    private static final int MENU_SIZE = 1;
    private final Dish dish;
    private final int count;

    private Order(Dish dish, int count) {
        validateSize(count);
        validateMenuExists(dish);
        this.dish = dish;
        this.count = count;
    }

    public static Order of(String name, int count) {
        AppConfig instance = AppConfig.getInstance();
        Menu menu = instance.menu();
        Dish dish = menu.findDish(name);
        return new Order(dish, count);
    }

    private void validateSize(int count) {
        if (count < MENU_SIZE) {
            throw new InvalidMenuQuantityException();
        }
    }

    private void validateMenuExists(Dish dish) {
        if (dish == null) {
            throw new NoMenuExistsException();
        }
    }

    public Dish getDish() {
        return dish;
    }
}
