package christmas.view;

import christmas.domain.Order;
import christmas.domain.Reservation;
import christmas.domain.VisitDate;
import christmas.exception.BlankInputTextException;
import christmas.exception.ChristmasEventException;
import christmas.exception.InvalidMenuPatternException;
import christmas.exception.NoNumericDateException;
import christmas.exception.NoNumericOrderCountException;
import christmas.io.Reader;
import christmas.utils.Parser;
import java.util.List;
import java.util.function.Supplier;
import java.util.regex.Pattern;

public class InputView {

    private static final String DATE_MESSAGE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private static final String ORDER_MESSAGE =
            "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";
    private static final Pattern NUMERIC_PATTERN = Pattern.compile("\\d+");
    private static final Pattern MENU_PATTERN = Pattern.compile("[가-힣0-9,\\-]+");

    private static final int MENU_PATTERN_SIZE = 2;


    private final Reader reader;

    public InputView(Reader reader) {
        this.reader = reader;
    }

    public Reservation getReservation() {
        VisitDate visitDate = getVisitDate();

        System.out.println(ORDER_MESSAGE);
        return runLoop(() -> {
            List<Order> orders = getOrders();
            return Reservation.of(visitDate, orders);
        });
    }

    private VisitDate getVisitDate() {
        System.out.println(DATE_MESSAGE);

        return runLoop(() -> {
            String input = reader.read();
            validateNumeric(input);
            int date = Parser.toInt(input);
            return VisitDate.from(date);
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
            validateOrderCountNumeric(orderString.get(1));
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
            throw new NoNumericDateException();
        }
    }

    private void validateOrderCountNumeric(String input) {
        if (!NUMERIC_PATTERN.matcher(input).matches()) {
            throw new NoNumericOrderCountException();
        }
    }

    private void validateMenuPattern(String input) {
        if (!MENU_PATTERN.matcher(input).matches()) {
            throw new InvalidMenuPatternException();
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

