package christmas.domain.dish;

public class Appetizer extends Dish {

    public Appetizer(String name, int price) {
        super(name, price);
    }

    public static Appetizer of(String name, int price) {
        return new Appetizer(name, price);
    }

}
