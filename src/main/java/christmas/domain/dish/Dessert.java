package christmas.domain.dish;

public class Dessert extends Dish {

    public Dessert(String name, int price) {
        super(name, price);
    }

    public static Dessert of(String name, int price) {
        return new Dessert(name, price);
    }

}
