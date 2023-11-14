package christmas.exception;

import christmas.exception.ChristmasEventException;

public class OrderedOnlyDrinksException extends ChristmasEventException {

    private static final String MESSAGE = "음료만 주문할 수 없습니다. 다시 입력해 주세요.";

    public OrderedOnlyDrinksException() {
        super(MESSAGE);
    }
}
