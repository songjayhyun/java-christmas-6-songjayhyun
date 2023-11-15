package christmas.domain;

public class Amount {

    private static final int EVENT_APPLICABLE = 10000;

    private final int number;

    public Amount(int number) {
        this.number = number;
    }

    public boolean isEventActive() {
        return number >= EVENT_APPLICABLE;
    }

    public boolean isMoreThan(int price) {
        return number >= price;
    }

    public boolean isEqualTo(int price) {
        return number == price;
    }

    public Amount plus(Amount amount) {
        int plus = this.number + amount.getNumber();
        return new Amount(plus);
    }

    public Amount minus(Amount amount) {
        int minus = this.number - amount.getNumber();
        return new Amount(minus);
    }

    public Badge getBadge() {
        return Badge.from(this);
    }

    public int getNumber() {
        return number;
    }

}
