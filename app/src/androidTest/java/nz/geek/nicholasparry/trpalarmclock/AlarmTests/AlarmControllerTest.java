package nz.geek.nicholasparry.trpalarmclock.AlarmTests;

import android.content.Context;
import android.test.AndroidTestCase;
import android.test.InstrumentationTestCase;

import junit.framework.TestSuite;

import org.junit.Test;

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
        while(contoler.getAllAlarms().size() > 0){
            contoler.removeAlarm(contoler.getAllAlarms().get(0));
        }
        this.addInvalidAlarm();
        this.addNewValidAlarm();

    }


    public void addNewValidAlarm(){
        assertTrue("Alarm should have been added but was not", contoler.addAlarm(new Alarm(0, 0)));
        assertTrue("Alarm should have been added but was not", contoler.addAlarm(0, 0));
        fail("grrr");
    }

    public void addInvalidAlarm() {
        assertFalse("Alarm should not have been added but was", contoler.addAlarm(new Alarm(24, 60)));
        assertFalse("Alarm should not have been added but was was", contoler.addAlarm(-1, -1));
    }

    public void isAlarmControlerAvalible() {
        assertTrue("Alarm controler should be avalible", AlarmControler.isAlarmControlerAvalible());
        assertNotNull("Alarm contoler should not be null but was", AlarmControler.getAlarmControler());
    }

    public void removeAlarms(){
        assertTrue("There should be no alarms", contoler.getAllAlarms().size() == 0);
        assertTrue("Alarm should be able to be added", contoler.addAlarm(5,2));
        assertTrue("An alarm should have been added", contoler.getAllAlarms().size() == 1);
        assertTrue("Alarm should be able to be removed", contoler.removeAlarm(contoler.getAllAlarms().get(0)));
        assertTrue("There should be no alarms", contoler.getAllAlarms().size() == 0);
    }

    public void saveAndLoadAlarms(){
        assertTrue("There should be no alarms", contoler.getAllAlarms().size() == 0);
        assertTrue("Alarm should be able to be added", contoler.addAlarm(5,2));
        assertTrue("An alarm should have been added", contoler.getAllAlarms().size() == 1);
        assertTrue("Alarm Controler should be able to save", contoler.save());
        while(contoler.getAllAlarms().size() > 0){
            contoler.removeAlarm(contoler.getAllAlarms().get(0));
        }
        assertTrue("There should be no alarms", contoler.getAllAlarms().size() == 0);
        assertTrue("The Alarm Controler should be able to load", contoler.load());
        assertTrue("Alarms should have been loaded", contoler.getAllAlarms().size() == 1);
    }
}
