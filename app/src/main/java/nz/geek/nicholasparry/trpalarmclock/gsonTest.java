package nz.geek.nicholasparry.trpalarmclock;

import android.util.Log;

/**
 * Created by nick on 1/10/15.
 */
public class gsonTest {
    public gsonTest() {
        String tag = "GsonTest";
        
        AlarmControler ac = AlarmControler.getAlarmControler();
        ac.addAlarm(1,2);
        ac.addAlarm(4,5);
        ac.addAlarm(2,4);
        ac.addAlarm(5,6);
        ac.addAlarm(99,12);
        ac.save();
        Log.d(tag,ac.getAllAlarms().toString());
        ac.addAlarm(0, 0);
        ac.addAlarm(0, 0);
        ac.addAlarm(0,0);
        Log.d(tag,ac.getAllAlarms().toString());

        ac.load();
        Log.d(tag,ac.getAllAlarms().toString());

    }
}
