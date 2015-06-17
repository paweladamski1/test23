package pl.szkolenie.projekty.threadtest;


import android.widget.NumberPicker;

public class ThreadTest extends Thread {

    public boolean activ = true;
    RunAsEnum runAs;
    int value, sleepValue = 500;
    private NumberPicker view;

    //constructor
    public ThreadTest(NumberPicker view, RunAsEnum runAs) {
        this.view = view;
        this.runAs = runAs;
        view.setMaxValue(1000);
    }

    @Override
    public void run() {
        value = 0;
        while (activ) {
            if (runAs == RunAsEnum.Forward) {
                value++;
                if (value > view.getMaxValue())
                    value = view.getMinValue();
            } else {
                value--;
                if (value < view.getMinValue())
                    value = view.getMaxValue();
            }

            MainActivity.This.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    view.setValue(value);
                }
            });

            try {
                Thread.sleep(sleepValue);
            } catch (InterruptedException e) {

            }
        }
    }

    public void SetSleepValue(int newValue) {
        this.sleepValue = newValue;
    }

    public enum RunAsEnum {Forward, Backward}


}
