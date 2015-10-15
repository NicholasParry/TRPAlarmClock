package nz.geek.nicholasparry.trpalarmclock.AlarmTests;


import android.test.InstrumentationTestCase;

import junit.framework.TestSuite;

import nz.geek.nicholasparry.trpalarmclock.Alarm;

/**
 * Tests the alarm class
 * Currently just test creating a new alarm
 * @version 1
 * @author nick
 * Created by nick on 3/10/15
 */
public class AlarmTest extends InstrumentationTestCase {
    Alarm alarm;


    /**
     * Tests creating a new alarm with valid paramters
     * Uses fringe paramters for quick testing
     * (0,0) and (23,59)
     */
    public void newAlarm_ValidParameters(){
        try {
            alarm = new Alarm(0, 0);
            alarm = new Alarm(23, 59);
        } catch (Exception e){
            assertTrue("should not have thrown exception but did t",true);
            assertTrue("should not have thrown exception but did f",false);
        }


    }


    /**
     * tests creating a new alarm with all valid paramters
     *
     */
    public void newAlarm_AllValidParameters_Loop(){
        try {
            for (int h = 0; h <= 23; h++) {
                for (int m = 0; m <= 59; m++) {
                    alarm = new Alarm(h, m);
                    assertEquals("Hour should have been" + h + "but was" + alarm.getHour(), alarm.getHour(), h);
                    assertEquals("Minute should have been" + m + "but was" + alarm.getMinute(), alarm.getMinute(), m);
                }
            }
        } catch (Exception e){
            fail("Exception was throwen");
        }
    }


    /**
     * Tests creating an alarm with negetive paramters
     */
    public void newAlarm_InvalidParametersNegetiveBoth(){
        boolean exceptionThrown = false;
        try{
            alarm = new Alarm(-1,-1);
            assertFalse("Hour should not be negetive but was: + " + alarm.getHour(), alarm.getHour() < 0);
            assertFalse("Minute should not be negetive but was: + " + alarm.getMinute(), alarm.getMinute() < 0);
        } catch (Exception e){
            exceptionThrown = true;
        }
        assertTrue("An exception should have been throwen but non was", exceptionThrown);
    }


    /**
     * Tests creating an alarm with negetive paramters
     */
    public void newAlarm_InvalidParametersNegetiveHour(){
        boolean exceptionThrown = false;
        try{
            alarm = new Alarm(-1,0);
            assertFalse("Hour should not be negetive but was: + " + alarm.getHour(), alarm.getHour() < 0);
        } catch (Exception e){
            exceptionThrown = true;
        }
        assertTrue("An exception should have been throwen but non was", exceptionThrown);
    }


    /**
     * Tests creating an alarm with negetive paramters
     */
    public void newAlarm_InvalidParametersNegetiveMinute(){
        boolean exceptionThrown = false;
        try{
            alarm = new Alarm(0,-1);
            assertFalse("Hour should not be negetive but was: + " + alarm.getHour(), alarm.getHour() < 0);
            assertFalse("Minute should not be negetive but was: + " + alarm.getMinute(), alarm.getMinute() < 0);
        } catch (Exception e){
            exceptionThrown = true;
        }
        assertTrue("An exception should have been throwen but non was", exceptionThrown);
    }


    /**
     * Tests creating an alarm with paramters larger than allowed
     */
    public void newAlarm_InvalidParametersPositiveBoth(){
        boolean exceptionThrown = false;
        try{
            alarm = new Alarm(24,60);
            assertFalse("Hour should be less than 24 but was: + " + alarm.getHour(), alarm.getHour() > 24);
            assertFalse("Minute should be less than 60 but was: + " + alarm.getMinute(), alarm.getMinute() > 60);
        } catch (Exception e){
            exceptionThrown = true;
        }
        assertTrue("An exception should have been throwen but non was", exceptionThrown);
    }

    /**
     * Tests creating an alarm with paramters larger than allowed
     */
    public void newAlarm_InvalidParametersPositiveHour(){
        boolean exceptionThrown = false;
        try{
            alarm = new Alarm(24,0);
            assertFalse("Hour should be less than 24 but was: + " + alarm.getHour(), alarm.getHour() > 24);
        } catch (Exception e){
            exceptionThrown = true;
        }
        assertTrue("An exception should have been throwen but non was", exceptionThrown);
    }


    /**
     * Tests creating an alarm with paramters larger than allowed
     */
    public void newAlarm_InvalidParametersPositiveMinute(){
        boolean exceptionThrown = false;
        try{
            alarm = new Alarm(0,60);
            assertFalse("Minute should be less than 60 but was: + " + alarm.getMinute(), alarm.getMinute() > 60);
        } catch (Exception e){
            exceptionThrown = true;
        }
        assertTrue("An exception should have been throwen but non was", exceptionThrown);
    }
}
