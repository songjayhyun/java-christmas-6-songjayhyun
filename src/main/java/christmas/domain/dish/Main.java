package christmas.domain.dish;

public class Main extends Dish {

    public Main(String name, int price) {
        super(name, price);
    }

    public static Main of(String name, int price) {
        return new Main(name, price);
    }

}
