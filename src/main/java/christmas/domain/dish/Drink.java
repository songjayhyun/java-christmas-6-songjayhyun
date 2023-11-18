package christmas.domain.dish;

public class Drink extends Dish {

    public Drink(String name, int price) {
        super(name, price);
    }

    public static Drink of(String name, int price) {
        return new Drink(name, price);
    }

}
