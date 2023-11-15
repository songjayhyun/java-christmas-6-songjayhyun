package christmas.controller;

import christmas.domain.Reservation;
import christmas.service.EventService;
import christmas.service.MenuService;
import christmas.view.InputView;
import christmas.view.OutputView;

public class ChristmasPromotion {
    private final InputView inputView;
    private final OutputView outputView;
    private final MenuService menuService;
    private final EventService eventService;

    public ChristmasPromotion(
            InputView inputView,
            OutputView outputView,
            MenuService menuService,
            EventService eventService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.menuService = menuService;
        this.eventService = eventService;
    }

    public void run() {
        Reservation reservation = getReservation();
        outputView.showPreview();
    }

    private Reservation getReservation() {
        outputView.showIntro();
        return menuService.getReservation();
    }

}
