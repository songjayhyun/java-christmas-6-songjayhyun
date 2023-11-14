package christmas.domain;

public enum Badge {
    NONE(0),
    SANTA(20_000),
    TREE(10_000),
    STAR(5_000);

    private final int amount;

    Badge(int amount) {
        this.amount = amount;
    }

    public static Badge from(Amount amount) {
        if (amount.isMorethan(SANTA.amount)) {
            return Badge.SANTA;
        }

        if (amount.isMorethan(TREE.amount)) {
            return Badge.TREE;
        }

        if (amount.isMorethan(STAR.amount)) {
            return Badge.STAR;
        }

        return Badge.NONE;
    }
}
