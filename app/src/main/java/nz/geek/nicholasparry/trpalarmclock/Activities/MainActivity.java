package nz.geek.nicholasparry.trpalarmclock.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import nz.geek.nicholasparry.trpalarmclock.AlarmControler;
import nz.geek.nicholasparry.trpalarmclock.R;
import nz.geek.nicholasparry.trpalarmclock.gsonTest;

/**
 * Main activity for trp alarm clock
 * Switches to ViewAlarmAtivity
 * Created by nick on 29/09/15.
 * @author nick
 * @version 1
 */
public class MainActivity extends Activity {

    private AlarmControler alarmControler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("bleh", "I work at 1");
        alarmControler = AlarmControler.getNewAlarmControler(false, this);
        Log.d("bleh", "I work at 2");
        alarmControler.save();
        Log.d("bleh", "I work at 3");
        new gsonTest();
        Log.d("bleh", "I work at 4");
        Intent intent = new Intent(this, ViewAlarmsActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
