package christmas.exception;

public class NoNumericDateException extends ChristmasEventException {

    private static final String MESSAGE = "유효하지 않은 날짜입니다. 다시 입력해 주세요.";

    public NoNumericDateException() {
        super(MESSAGE);
    }
}
