package christmas.domain.discountpolicy;

public class FixDiscountPolicy implements DiscountPoilcy {

    private final int price;

    public FixDiscountPolicy(int price) {
        this.price = price;
    }

    @Override
    public int discount() {
        return price;
    }
}
