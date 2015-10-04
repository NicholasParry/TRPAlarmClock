package nz.geek.nicholasparry.trpalarmclock.AlarmTests;

import android.content.Context;
import android.test.AndroidTestCase;
import android.test.InstrumentationTestCase;

import nz.geek.nicholasparry.trpalarmclock.Alarm;
import nz.geek.nicholasparry.trpalarmclock.AlarmControler;

/**
 * Tests the alarm controller
 * @version 1
 * @author nick
 * Created by nick on 3/10/15.
 */
public class AlarmControllerTest  extends AndroidTestCase{

    AlarmControler contoler;


    @Override
    protected void setUp() throws Exception {
        super.setUp();
        contoler =  AlarmControler.getAlarmControler().getNewAlarmControler(false, getContext());
    }

    public void addNewValidAlarm(){
        assertTrue("Alarm should have been added but was not", contoler.addAlarm(new Alarm(0, 0)));
        assertTrue("Alarm should have been added but was not", contoler.addAlarm(0,0));
    }

    public void addInvalidAlarm(){
        assertFalse("Alarm should not have been added but was", contoler.addAlarm(new Alarm(24, 60)));
        assertFalse("Alarm should not have been added but was was", contoler.addAlarm(-1, -1));
    }

    public void isAlarmControlerAvalible(){
        assertTrue("Alarm controler should be avalible", AlarmControler.isAlarmControlerAvalible());
        assertNotNull("Alarm contoler should not be null but was", AlarmControler.getAlarmControler() );
    }
}
