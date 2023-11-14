package christmas.fixtures;

import java.time.LocalDate;

public class LocalDateFixtures {

    public static LocalDate createNovemberDate() {
        return LocalDate.of(2023, 11, 4);
    }

    public static LocalDate createWeekendDate() {
        return LocalDate.of(2023, 12, 5); // 화요일
    }

    public static LocalDate createWeekdayDate() {
        return LocalDate.of(2023, 12, 16); // 토요일
    }
}
