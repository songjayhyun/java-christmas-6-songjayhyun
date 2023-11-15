package christmas.domain.dish;

import java.util.Objects;

public class Dish {

    private final String name;
    private final int price;

    public Dish(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public boolean contains(String name) {
        return this.name.equals(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Dish dish)) {
            return false;
        }
        return price == dish.price && Objects.equals(name, dish.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
