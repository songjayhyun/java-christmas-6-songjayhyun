package christmas.domain.category;

public interface Category {

    void register(String name, int price);

    boolean isMenuRegistered(String name);

}
