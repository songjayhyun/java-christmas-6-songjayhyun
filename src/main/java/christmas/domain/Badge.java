package christmas.domain;

import java.util.Arrays;

public enum Badge {
    SANTA("산타", 20_000),
    TREE("트리", 10_000),
    STAR("별", 5_000),
    NONE("없음", 0);

    private final String name;
    private final int amount;

    Badge(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public static Badge from(Amount amount) {
        return Arrays.stream(values())
                .filter(badge -> amount.isMoreThan(badge.amount))
                .findFirst()
                .orElse(NONE);
    }

    public String getName() {
        return name;
    }
}
