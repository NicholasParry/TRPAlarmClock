package nz.geek.nicholasparry.trpalarmclock;

import android.util.Log;

import com.google.gson.Gson;

/**
 * Used to manage all alarms
 * Works as a singleton
 * Created by nick on 29/09/15.
 * @author nick
 * @version 1
 */
public class AlarmControler {

    //Used for creating a singleton class
    private static AlarmControler alarmControler = new AlarmControler(true);


    /**
     * Creates a new alarm object
     * @param load weather to load saved alar
     */
    private AlarmControler(boolean load) {
        if(load){
            load();
        }
    }


    /**
     * Returns alarm controler object
     * @return AlarmControler object
     */
    public static AlarmControler getAlarmControler(){
        return alarmControler;
    }


    /**
     * Returns a primitive array off all alarms
     * @return an array Alarm objects
     */
    public Alarm[] getAllAlarms(){
        return null;
    }


    /**
     * Adds an alarm object to the alam list so that it can be saved
     * @param alarm alarm object to add
     * @return true if adding was succcseful
     */
    public boolean addAlarm(Alarm alarm){
        return false;
    }


    /**
     * Creates and Adds an alarm object to the alam list so that it can be saved
     * @param hour for alarm to go off in 24h time
     * @param minute for alarm to go off
     * @return true if adding was succcseful
     */
    public boolean addAlarm(int hour, int minute){
        return false;
    }


    /**
     * Removes an alarm from the alarm list
     * @param alarm to be removed
     * @return true if sucsessful
     */
    public boolean removeAlarm(Alarm alarm){
        return false;
    }


    /**
     * Loads alarms from the shared preferances
     * @return true if sucsessful
     */
    public boolean load(){
        return false;
    }


    /**
     * Saves the alarms to the defult shared prefs
     * @return true if sucsessful
     */
    public boolean save(){
        //create array off objects;
        //use GSON to create a string
        //save in shared prefs
        //Gson
        Alarm[] arms = new Alarm[3];
        arms[0] = new Alarm(1,2);
        arms[1] = new Alarm(34, 567);
        arms[2] = new Alarm(0,0);

        Gson gson = new Gson();
        Log.d("Gson bro", gson.toJson(arms));
        return false;
    }

}
