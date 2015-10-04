package nz.geek.nicholasparry.trpalarmclock;

import android.app.Application;
import android.test.ApplicationTestCase;

import junit.framework.TestSuite;

import nz.geek.nicholasparry.trpalarmclock.AlarmTests.AlarmTest;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
        TestSuite suite = new TestSuite();
        AlarmTest at = new AlarmTest();
    }


}