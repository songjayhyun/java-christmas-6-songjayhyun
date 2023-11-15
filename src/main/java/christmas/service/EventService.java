package christmas.service;

import christmas.domain.Amount;
import christmas.domain.EventDto;
import christmas.domain.GiveawayMenu;
import christmas.domain.Reservation;
import christmas.domain.VisitDate;
import christmas.domain.event.Event;
import christmas.domain.event.GiveawayEvent;
import christmas.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class EventService {
    private final List<Event> events;
    private final OutputView outputView;

    public EventService(List<Event> events, OutputView outputView) {
        this.events = events;
        this.outputView = outputView;
    }

    private static Amount calculateFinalBenefitAmount(Amount totalBenefitAmount, Amount giveawayAmount, Amount amount) {
        totalBenefitAmount = totalBenefitAmount.minus(giveawayAmount);
        amount = amount.minus(totalBenefitAmount);
        return amount;
    }

    public void processEvents(Reservation reservation) {
        outputView.showOrder(reservation.getOrders());
        outputView.showTotalAmountBeforeDiscount(reservation.getAmount());
        processReservation(reservation);
    }

    public void processReservation(Reservation reservation) {
        VisitDate visitDate = reservation.getVisitDate();
        Amount amount = reservation.getAmount();

        List<EventDto> eventDtos = processEvents(visitDate, amount, reservation);
        Amount totalBenefitAmount = calculateTotalBenefitAmount(eventDtos);
        Amount giveawayAmount = calculateGiveawayAmount(eventDtos);

        outputResults(eventDtos, totalBenefitAmount, giveawayAmount, amount);
    }

    private void outputResults(
            List<EventDto> eventDtos,
            Amount totalBenefitAmount,
            Amount giveawayAmount,
            Amount amount) {

        outputView.showBenefitAmount(eventDtos);
        outputView.showTotalBenefitAmount(totalBenefitAmount);
        outputView.showFinalAmount(calculateFinalBenefitAmount(totalBenefitAmount, giveawayAmount, amount));
        outputView.showBadge(totalBenefitAmount.getBadge());
    }

    private List<EventDto> processEvents(
            VisitDate visitDate,
            Amount amount,
            Reservation reservation) {

        List<EventDto> eventDtos = new ArrayList<>();

        for (Event event : events) {
            Amount discount = event.process(visitDate, amount, reservation);

            if (event instanceof GiveawayEvent giveawayEvent) {
                handleGiveawayEvent(giveawayEvent, discount);
            }

            if (discount.isZero()) {
                handleNonZeroAmountEvent(event, discount, eventDtos);
            }
        }

        return eventDtos;
    }

    private void handleNonZeroAmountEvent(Event event, Amount discount, List<EventDto> eventDtos) {
        eventDtos.add(new EventDto(event, discount));
    }

    private void handleGiveawayEvent(GiveawayEvent giveawayEvent, Amount discount) {
        List<GiveawayMenu> giveawayMenus = giveawayEvent.getGiveawayMenus();
        outputView.showGiveawayMenu(giveawayMenus, discount);
    }

    private Amount calculateTotalBenefitAmount(List<EventDto> eventDtos) {
        return eventDtos.stream()
                .map(EventDto::amount)
                .reduce(Amount::plus)
                .orElse(Amount.createZeroAmount());
    }

    private Amount calculateGiveawayAmount(List<EventDto> eventDtos) {
        return eventDtos.stream()
                .filter(eventDto -> eventDto.event() instanceof GiveawayEvent)
                .map(EventDto::amount)
                .reduce(Amount::plus)
                .orElse(Amount.createZeroAmount());
    }

}
