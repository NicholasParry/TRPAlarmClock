package nz.geek.nicholasparry.trpalarmclock;

/**
 * Individual alarm object
 *
 * Created by nick on 29/09/15.
 * @see AlarmControler
 * @author nick
 * @version 1
 *
 */
public class Alarm {

    private int hour;
    private int minute;


    /**
     * Creates a new alarm object
     * @param hour for alarm to go off in 24h time
     * @param minute for alarm to go off
     */
    public Alarm(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }
}
