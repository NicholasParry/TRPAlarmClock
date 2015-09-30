package nz.geek.nicholasparry.trpalarmclock;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
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


    private static final Gson gson = new Gson();
    private static AlarmControler alarmControler; //Used for creating a singleton class
    private static SharedPreferences prefs;

    private static final String SHARED_PREFS_ALARM_ARRAY = "TRP_ALARMS";

    /**
     * Creates a new alarm object
     * @param loadSavedData weather to load saved data
     * @param context contect of application
     */
    private AlarmControler(boolean loadSavedData, Context context) {
        if(loadSavedData){
            load();
        }
        this.prefs = context.getSharedPreferences("TRP_ALARM_CLOCK", Context.MODE_PRIVATE);

    }


    /**
     * Effectivly calls the constructer
     * @param loadSavedData weather to load saved data
     * @param context contect of application
     * @return AlarmControler object
     */
    public static AlarmControler getNewAlarmControler(boolean loadSavedData, Context context){
        alarmControler = new AlarmControler(loadSavedData, context);
        return alarmControler;
    }


    /**
     * Returns alarm controler object
     * Only call this after getNewAlarmControler(SharedPreferences prefs)
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
        prefs.edit().putString(gson.toJson(getAllAlarms()),gson.toJson(getAllAlarms())).commit();
        return false;
    }

}
