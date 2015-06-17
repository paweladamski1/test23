package pl.szkolenie.projekty.threadtest;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.NumberPicker;


public class MainActivity extends ActionBarActivity {

    static public NumberPicker numberPicker1, numberPicker2, numberPicker3, np1, np2, np3;
    static public MainActivity This;
    ThreadTest t1, t2, t4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        This = this;

        setContentView(R.layout.activity_main);
        numberPicker1 = (NumberPicker) findViewById(R.id.numberPicker1);
        numberPicker2 = (NumberPicker) findViewById(R.id.numberPicker2);
        numberPicker3 = (NumberPicker) findViewById(R.id.numberPicker3);

        np1 = (NumberPicker) findViewById(R.id.np1);
        np2 = (NumberPicker) findViewById(R.id.np2);
        np3 = (NumberPicker) findViewById(R.id.np3);

        np1.setMaxValue(2000);
        np2.setMaxValue(2000);
        np3.setMaxValue(2000);

        np1.setValue(500);
        np2.setValue(500);
        np3.setValue(500);

        np1.setMinValue(25);
        np2.setMinValue(25);
        np3.setMinValue(25);

        np1.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                t1.SetSleepValue(newVal);
            }
        });
        np2.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                t2.SetSleepValue(newVal);
            }
        });
        np3.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                t4.SetSleepValue(newVal);
            }
        });
        t1 = new ThreadTest(numberPicker1, ThreadTest.RunAsEnum.Forward);
        t1.start();

        t2 = new ThreadTest(numberPicker2, ThreadTest.RunAsEnum.Backward);
        t2.start();

        t4 = new ThreadTest(numberPicker3, ThreadTest.RunAsEnum.Forward);
        t4.start();


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
