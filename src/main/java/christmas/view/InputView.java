package christmas.view;

import christmas.domain.Order;
import christmas.exception.BlankInputTextException;
import christmas.exception.ChristmasEventException;
import christmas.exception.NoNumericException;
import christmas.io.Reader;
import christmas.utils.Parser;
import java.util.List;
import java.util.function.Supplier;
import java.util.regex.Pattern;

public class InputView {

    private static final Pattern NUMERIC_PATTERN = Pattern.compile("\\d+");
    private static final Pattern MENU_PATTERN = Pattern.compile("[,-]");
    private static final int MENU_PATTERN_SIZE = 2;


    private final Reader reader;

    public InputView(Reader reader) {
        this.reader = reader;
    }

    private int getVisitDate() {
        return runLoop(() -> {
            String input = reader.read();
            validateNumeric(input);
            return Parser.toInt(input);
        });
    }

    private List<Order> getOrders() {
        return runLoop(() -> {
            String input = reader.read();
            validateHasText(input);
            validateMenuPattern(input);
            List<String> menus = Parser.toStringList(input);
            validateOrder(menus);
            return Parser.toOrderList(menus);
        });
    }

    private void validateOrder(List<String> menus) {
        menus.forEach(menu -> {
            List<String> orderString = Parser.toOrderString(menu);
            validateNumeric(orderString.get(1));
            validateParsedLength(orderString);
        });
    }

    private void validateParsedLength(List<String> orderString) {
        if (orderString.size() != MENU_PATTERN_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumeric(String input) {
        if (!NUMERIC_PATTERN.matcher(input).matches()) {
            throw new NoNumericException();
        }
    }

    private void validateMenuPattern(String input) {
        if (!MENU_PATTERN.matcher(input).matches()) {
            throw new NoNumericException();
        }
    }

    private void validateHasText(String input) {
        if (input == null || input.isBlank()) {
            throw new BlankInputTextException();
        }
    }

    private <T> T runLoop(Supplier<T> inputFunction) {
        while (true) {
            try {
                return inputFunction.get();
            } catch (ChristmasEventException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void close() {
        reader.close();
    }

}

