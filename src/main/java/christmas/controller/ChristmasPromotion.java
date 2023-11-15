package christmas.controller;

import christmas.domain.Reservation;
import christmas.service.EventService;
import christmas.service.MenuService;
import christmas.view.OutputView;

public class ChristmasPromotion {
    private final OutputView outputView;
    private final MenuService menuService;
    private final EventService eventService;

    public ChristmasPromotion(
            OutputView outputView,
            MenuService menuService,
            EventService eventService) {
        this.outputView = outputView;
        this.menuService = menuService;
        this.eventService = eventService;
    }

    public void run() {
        Reservation reservation = getReservation();
        outputView.showPreview(reservation.getVisitDate());
        processEvents(reservation);
    }

    private void processEvents(Reservation reservation) {
        eventService.process(reservation);
    }

    private Reservation getReservation() {
        outputView.showIntro();
        return menuService.getReservation();
    }

}
