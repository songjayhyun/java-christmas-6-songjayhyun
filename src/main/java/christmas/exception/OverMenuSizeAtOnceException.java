package christmas.exception;

import christmas.exception.ChristmasEventException;

public class OverMenuSizeAtOnceException extends ChristmasEventException {

    private static final String MESSAGE = "메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.";

    public OverMenuSizeAtOnceException() {
        super(MESSAGE);
    }
}
