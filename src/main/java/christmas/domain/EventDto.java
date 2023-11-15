package christmas.domain;

import christmas.domain.event.Event;

public record EventDto(Event event, Amount amount) {
}
