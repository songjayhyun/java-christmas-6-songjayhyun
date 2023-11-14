package christmas.domain.event;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Event {

    private Date startDate;
    private Date endDate;

    public Event(String start, String end) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
        this.startDate = simpleDateFormat.parse(start);
        this.endDate = simpleDateFormat.parse(end);
    }

    boolean isEventActive(Date date) {
        if (date.after(endDate) || date.before(startDate)) {
            return false;
        }
        return true;
    }
}
