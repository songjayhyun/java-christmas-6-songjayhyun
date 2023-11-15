package christmas.exception;

public class InvalidMenuPatternException extends ChristmasEventException {
    private static final String MESSAGE = "유효하지 않은 주문입니다. 다시 입력해 주세요.";

    public InvalidMenuPatternException() {
        super(MESSAGE);
    }
}