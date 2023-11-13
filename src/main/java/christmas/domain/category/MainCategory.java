package christmas.domain.category;

import christmas.domain.dish.Main;
import java.util.ArrayList;
import java.util.List;

public class MainCategory implements Category {

    private final List<Main> mains;

    public MainCategory() {
        mains = new ArrayList<>();
    }

    @Override
    public void register(String name, int price) {
        mains.add(Main.of(name, price));
    }

    @Override
    public boolean isMenuRegistered(String name) {
        return mains.stream()
                .anyMatch(main -> main.contains(name));
    }

}
