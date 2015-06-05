package Store.support;

import java.sql.Time;

/**
 * Created by shubham.srivastava on 06/06/15.
 */
public class OpenHours {
    private static Time startTime;

    private static Time endTime;
    public OpenHours(Time st, Time et) {
        this.startTime = st;
        this.endTime = et;
    }

    public static Time getEndTime() {
        return endTime;
    }

    public static void setEndTime(Time endTime) {
        OpenHours.endTime = endTime;
    }

    public static Time getStartTime() {

        return startTime;
    }

    public static void setStartTime(Time startTime) {
        OpenHours.startTime = startTime;
    }

    @Override
    public String toString() {
        return startTime.toString().concat(endTime.toString());
    }
}
