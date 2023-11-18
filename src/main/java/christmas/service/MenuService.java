package christmas.service;

import christmas.domain.Reservation;
import christmas.view.InputView;

public class MenuService {
    private final InputView inputView;

    public MenuService(InputView inputView) {
        this.inputView = inputView;
    }

    public Reservation getReservation() {
        return inputView.getReservation();
    }
}
