package com.example.diksha.scheduletest;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;

public class ScheduleActivity extends AppCompatActivity {

    int[] timeslot = {0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

       // CheckBox checkBox = (CheckBox) findViewById(R.id.slot_1);
        setCheckboxes(timeslot);
    }

    public void setCheckboxes(int[] timeslot){
        for(int i=1 ; i<=42 ; i++) {
            String abc = "slot_" + String.valueOf(i);
            int resID = getResources().getIdentifier(abc, "id", getPackageName());
            CheckBox slot = (CheckBox) findViewById(resID);
            if (timeslot[i-1] == 1) {
                slot.setEnabled(true);
                slot.setBackgroundResource(R.color.slot_available);
                //slot.setButtonTintList(ColorStateList.valueOf(resources.getColor(R.id.blue_100)));
                slot.setButtonTintList(ContextCompat.getColorStateList(ScheduleActivity.this, R.color.slot_available_tick));
            }
        }
    }
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_pirates:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.radio_ninjas:
                if (checked)
                    // Ninjas rule
                    break;
        }
    }
}
