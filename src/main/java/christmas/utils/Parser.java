package christmas.utils;

import christmas.domain.Order;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    private static final String ORDER_DELIMITER = ",";
    private static final String MENU_DELIMITER = "-";

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }

    public static List<String> toStringList(String input) {
        return List.of(input.split(ORDER_DELIMITER));
    }

    public static List<String> toOrderString(String menu) {
        return List.of(menu.split(MENU_DELIMITER));
    }

    public static List<Order> toOrderList(List<String> menus) {
        List<Order> orders = new ArrayList<>();
        for (String menu : menus) {
            List<String> orderString = toOrderString(menu);
            String dish = orderString.get(0);
            int count = toInt(orderString.get(1));
            orders.add(Order.of(dish, count));
        }
        return orders;
    }
}
