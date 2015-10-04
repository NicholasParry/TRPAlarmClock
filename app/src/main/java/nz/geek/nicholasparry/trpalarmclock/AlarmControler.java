package nz.geek.nicholasparry.trpalarmclock;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

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
    private static final String LOG_TAG = "AlarmControler";

    private static ArrayList<Alarm> alarms;


    /**
     * Creates a new alarm object
     * @param loadSavedData weather to load saved data
     * @param context contect of application
     * @throws NullPointerException if context is null
     */
    private AlarmControler(boolean loadSavedData, Context context) {
        if(loadSavedData){
            load();
        }
        if(context == null){
            throw new NullPointerException("Context Was Empty, please provide a valid context");
        }
        this.prefs = context.getSharedPreferences("TRP_ALARM_CLOCK", Context.MODE_PRIVATE);

        alarms = new ArrayList<Alarm>();

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
        if(!(isAlarmControlerAvalible())){
            Log.e(LOG_TAG,"please call getNewAlarmController first");
        }
        return alarmControler;
    }


    /**
     * Tests to see if a alarm controler is avalible or a new instance needs to be created
     * @return true if AlarmControler is avalible
     */
    public static boolean isAlarmControlerAvalible(){
        return (prefs != null);
    }


    /**
     * Returns a primitive array off all alarms
     * @return an array Alarm objects
     */
    public static ArrayList<Alarm> getAllAlarms(){
        return alarms;
    }


    /**
     * Adds an alarm object to the alam list so that it can be saved
     * @param alarm alarm object to add
     * @return true if adding was succcseful
     */
    public static boolean addAlarm(Alarm alarm){
        return alarms.add(alarm);
    }


    /**
     * Creates and Adds an alarm object to the alam list so that it can be saved
     * @param hour for alarm to go off in 24h time
     * @param minute for alarm to go off
     * @return true if adding was succcseful
     */
    public static boolean addAlarm(int hour, int minute){
        return alarms.add(new Alarm(hour, minute));
    }


    /**
     * Removes an alarm from the alarm list
     * @param alarm to be removed
     * @return true if sucsessful
     */
    public static boolean removeAlarm(Alarm alarm){
        return false;
    }


    /**
     * Loads alarms from the shared preferances
     * @return true if sucsessful
     */
    public static boolean load(){
        String json = prefs.getString(SHARED_PREFS_ALARM_ARRAY, "error");
        if(json.equals("error")){
            Log.e(LOG_TAG,"No alarms found in shared preferances");
            return false;
        }

        Alarm[] alarmsTemp = gson.fromJson(json,Alarm[].class);
        alarms = new ArrayList<Alarm>(Arrays.asList(alarmsTemp));

        return true;
    }


    /**
     * Saves the alarms to the defult shared prefs
     * @return true if sucsessful
     */
    public static boolean save(){
        prefs.edit().putString(SHARED_PREFS_ALARM_ARRAY, gson.toJson(getAllAlarms().toArray())).commit();
        return false;
    }

}
