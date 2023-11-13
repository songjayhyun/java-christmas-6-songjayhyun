package christmas.domain.dish;

public class Dish {

    private String name;
    private int price;

    public Dish(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public boolean contains(String name) {
        return this.name.equals(name);
    }

}
