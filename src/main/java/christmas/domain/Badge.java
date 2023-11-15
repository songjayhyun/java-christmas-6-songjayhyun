package christmas.domain;

public enum Badge {
    NONE("없음", 0),
    SANTA("산타", 20_000),
    TREE("트리", 10_000),
    STAR("별", 5_000);

    private final String name;
    private final int amount;

    Badge(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public static Badge from(Amount amount) {
        if (amount.isMoreThan(SANTA.amount)) {
            return Badge.SANTA;
        }

        if (amount.isMoreThan(TREE.amount)) {
            return Badge.TREE;
        }

        if (amount.isMoreThan(STAR.amount)) {
            return Badge.STAR;
        }

        return Badge.NONE;
    }

    public String getName() {
        return name;
    }
}
