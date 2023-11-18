package christmas.domain.dto;

import christmas.domain.Amount;
import christmas.domain.event.Event;

public record EventDto(Event event, Amount amount) {
}
