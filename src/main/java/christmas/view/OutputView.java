package christmas.view;

import christmas.io.Writer;

public class OutputView {

    private static final String INTRO_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String PREVIEW_MESSAGE = "12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private static final String ORDER_MENU_MESSAGE = "<주문 메뉴>";
    private static final String TOTAL_AMOUNT_BEFORE_MESSAGE = "<할인 전 총주문 금액>";
    private static final String BENEFIT_AMOUNT_MESSAGE = "<혜택 금액>";
    private static final String TOTAL_BENEFIT_AMOUNT_MESSAGE = "<총혜택 금액>";
    private static final String FINAL_AMOUNT_MESSAGE = "<할인 후 예상 결제 금액>";
    private static final String BADGE_MESSAGE = "<12월 이벤트 배지>";

    private final Writer writer;

    public OutputView(Writer writer) {
        this.writer = writer;
    }

    public void showIntro() {
        writer.write(INTRO_MESSAGE);
    }

    public void showPreview() {
        writer.write(PREVIEW_MESSAGE);
    }

    public void showOrder() {
        writer.write(ORDER_MENU_MESSAGE);
    }

    public void showTotalAmountBefore() {
        writer.write(TOTAL_AMOUNT_BEFORE_MESSAGE);
    }

    public void showBenefitAmount() {
        writer.write(BENEFIT_AMOUNT_MESSAGE);
    }

    public void showTotalBenefitAmount() {
        writer.write(TOTAL_BENEFIT_AMOUNT_MESSAGE);
    }

    public void showFinalAmount() {
        writer.write(FINAL_AMOUNT_MESSAGE);
    }

    public void showBadge() {
        writer.write(BADGE_MESSAGE);
    }
}
