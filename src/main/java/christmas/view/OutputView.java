package christmas.view;

import christmas.domain.Amount;
import christmas.domain.Badge;
import christmas.domain.GiveawayMenu;
import christmas.domain.Order;
import christmas.domain.event.Event;
import christmas.io.Writer;
import java.text.DecimalFormat;
import java.util.List;

public class OutputView {

    private static final String INTRO_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String PREVIEW_MESSAGE = "12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private static final String ORDER_MENU_MESSAGE = addBrackets("주문 메뉴");
    private static final String GIVEAWAY_MENU_MESSAGE = addBrackets("증정 메뉴");
    private static final String TOTAL_AMOUNT_BEFORE_DISCOUNT_MESSAGE = addBrackets("할인 전 총주문 금액");
    private static final String BENEFIT_AMOUNT_MESSAGE = addBrackets("혜택 금액");
    private static final String TOTAL_BENEFIT_AMOUNT_MESSAGE = addBrackets("총혜택 금액");
    private static final String FINAL_AMOUNT_MESSAGE = addBrackets("할인 후 예상 결제 금액");
    private static final String BADGE_MESSAGE = addBrackets("12월 이벤트 배지");
    private static final String ORDER_MENU = "%s %d개";
    private static final String NO_EVENT_APPLIED = "없음";
    private static final String AMOUNT = "%s원";
    private static final String DISCOUNT_AMOUNT = "-%s원";
    private static final String BENEFIT_AMOUNT = "%s: -%s원";
    private final Writer writer;

    public OutputView(Writer writer) {
        this.writer = writer;
    }

    private static String addBrackets(String message) {
        return "<" + message + ">";
    }

    public void showIntro() {
        writer.write(INTRO_MESSAGE);
    }

    public void showPreview() {
        writer.write(PREVIEW_MESSAGE);
    }

    public void showOrder(List<Order> orders) {
        writer.write(ORDER_MENU_MESSAGE);
        for (Order order : orders) {
            String orderMenu = ORDER_MENU.formatted(order.getDish().getName(), order.getCount());
            writer.write(orderMenu);
        }
    }

    public void showTotalAmountBeforeDiscount(Amount amount) {
        writer.write(TOTAL_AMOUNT_BEFORE_DISCOUNT_MESSAGE);
        String totalAmount = AMOUNT.formatted(formatNumber(amount.getNumber()));
        writer.write(totalAmount);
    }

    public void showGiveawayMenu(List<GiveawayMenu> giveawayMenus) {
        writer.write(GIVEAWAY_MENU_MESSAGE);
        for (GiveawayMenu giveawayMenu : giveawayMenus) {
            String giveaway = ORDER_MENU.formatted(giveawayMenu.name(), giveawayMenu.count());
            writer.write(giveaway);
        }
    }

    public void showBenefitAmount(Event event, Amount amount) {
        writer.write(BENEFIT_AMOUNT_MESSAGE);
        String benefitAmount = BENEFIT_AMOUNT.formatted(event.getName(), formatNumber(amount.getNumber()));
        writer.write(benefitAmount);
    }

    public void showTotalBenefitAmount(Amount amount) {
        writer.write(TOTAL_BENEFIT_AMOUNT_MESSAGE);
        String totalBenefitAmount = DISCOUNT_AMOUNT.formatted(formatNumber(amount.getNumber()));
        writer.write(totalBenefitAmount);
    }

    public void showFinalAmount(Amount amount) {
        writer.write(FINAL_AMOUNT_MESSAGE);
        String finalAmount = AMOUNT.formatted(formatNumber((amount.getNumber())));
        writer.write(finalAmount);
    }

    public void showBadge(Badge badge) {
        writer.write(BADGE_MESSAGE);
        writer.write(badge.getName());
    }

    public void showNoEventApplied() {
        writer.write(NO_EVENT_APPLIED);
    }

    private static String formatNumber(int number) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(number);
    }
}
