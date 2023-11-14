package christmas.domain;

public class Amount {

    private static final int EVENT_APPLICABLE = 10000;

    private final int number;

    public Amount(int number) {
        this.number = number;
    }

    public boolean isEventable() {
        return number >= EVENT_APPLICABLE;
    }

    public boolean isMorethan(int price) {
        return number > price;
    }

    public boolean isEqualTo(int price) {
        return number == price;
    }
}
