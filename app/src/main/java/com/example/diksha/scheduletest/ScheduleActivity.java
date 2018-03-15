package com.example.diksha.scheduletest;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ScheduleActivity extends AppCompatActivity {

    int[] timeslot = {0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0};
    int[] currslots = new int[42];
    HashMap<String,String> slotmap=new HashMap<String,String>();

    String selectedslot[] = {"0000","0000"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        // CheckBox checkBox = (CheckBox) findViewById(R.id.slot_1);
        setCheckboxes();

        TextView selectedslottxt = (TextView) findViewById(R.id.selectedslot);
        selectedslottxt.setText(new String("Selected Slot : N/A - N/A"));
        // making a copy of array
        for(int i=0;i<42;i++)
        {
            currslots[i] = timeslot[i];
        }
        slotmap.put("slot_1","1000-1010");
        slotmap.put("slot_2","1010-1020");
        slotmap.put("slot_3","1020-1030");
        slotmap.put("slot_4","1030-1040");
        slotmap.put("slot_5","1040-1050");
        slotmap.put("slot_6","1050-1100");

        slotmap.put("slot_7","1100-1110");
        slotmap.put("slot_8","1110-1120");
        slotmap.put("slot_9","1120-1130");
        slotmap.put("slot_10","1130-1140");
        slotmap.put("slot_11","1140-1150");
        slotmap.put("slot_12","1150-1200");

        slotmap.put("slot_13","1200-1210");
        slotmap.put("slot_14","1210-1220");
        slotmap.put("slot_15","1220-1230");
        slotmap.put("slot_16","1230-1240");
        slotmap.put("slot_17","1240-1250");
        slotmap.put("slot_18","1250-1300");

        slotmap.put("slot_19","1300-1310");
        slotmap.put("slot_20","1310-1320");
        slotmap.put("slot_21","1320-1330");
        slotmap.put("slot_22","1330-1340");
        slotmap.put("slot_23","1340-1350");
        slotmap.put("slot_24","1350-1400");

        slotmap.put("slot_25","1400-1410");
        slotmap.put("slot_26","1410-1420");
        slotmap.put("slot_27","1420-1430");
        slotmap.put("slot_28","1430-1440");
        slotmap.put("slot_29","1440-1450");
        slotmap.put("slot_30","1450-1500");

        slotmap.put("slot_31","1500-1510");
        slotmap.put("slot_32","1510-1520");
        slotmap.put("slot_33","1520-1530");
        slotmap.put("slot_34","1530-1540");
        slotmap.put("slot_35","1540-1550");
        slotmap.put("slot_36","1550-1600");

        slotmap.put("slot_37","1600-1610");
        slotmap.put("slot_38","1610-1620");
        slotmap.put("slot_39","1620-1630");
        slotmap.put("slot_40","1630-1640");
        slotmap.put("slot_41","1640-1650");
        slotmap.put("slot_42","1650-1700");

    }

    public void setCheckboxes(){
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
    public void checkboxremake(){

        // 0 - blocked
        // 2 - available, enabled
        // 1 - available, disabled
        // 3 - checked
        for(int i=1 ; i<=42 ; i++) {
            String abc = "slot_" + String.valueOf(i);
            String previd = "",nextid="";
            if (i>=2){ previd = "slot_"+(i-1);}
            if (i<=41){ nextid = "slot_"+(i+1);}
            int resID = getResources().getIdentifier(abc, "id", getPackageName());
            CheckBox slot = (CheckBox) findViewById(resID);

            // checked
            if (currslots[i-1] == 3) {
                slot.setEnabled(true);
                slot.setChecked(true);
                if (!previd.equals("")){
                    if(currslots[i-2] == 1) {
                        int presID = getResources().getIdentifier(previd, "id", getPackageName());
                        CheckBox pslot = (CheckBox) findViewById(presID);
                        pslot.setEnabled(true);
                        currslots[i-2] = 2;
                    }
                }
                if (!nextid.equals("")){
                    if(currslots[i] == 1) {
                        int nresID = getResources().getIdentifier(nextid, "id", getPackageName());
                        CheckBox nslot = (CheckBox) findViewById(nresID);
                        nslot.setEnabled(true);
                        currslots[i] = 2;
                    }
                }
            }

            else if (currslots[i-1] == 1) { // it is disabled, not checked
                int flag = 0;
                if (!previd.equals("")){
                    if(currslots[i-2] == 3) {
                        //int presID = getResources().getIdentifier(previd, "id", getPackageName());
                        //CheckBox pslot = (CheckBox) findViewById(presID);
                        ////pslot.setEnabled(true);
                        slot.setEnabled(true);
                        slot.setBackgroundResource(R.color.slot_available);
                        //slot.setButtonTintList(ColorStateList.valueOf(resources.getColor(R.id.blue_100)));
                        slot.setButtonTintList(ContextCompat.getColorStateList(ScheduleActivity.this, R.color.slot_available_tick));
                        flag = 1;
                    }
                }
                if (!nextid.equals("")){
                    if(currslots[i] == 3) {
                        //int nresID = getResources().getIdentifier(nextid, "id", getPackageName());
                        //CheckBox nslot = (CheckBox) findViewById(nresID);
                        //nslot.setEnabled(true);
                        slot.setEnabled(true);
                        slot.setBackgroundResource(R.color.slot_available);
                        //slot.setButtonTintList(ColorStateList.valueOf(resources.getColor(R.id.blue_100)));
                        slot.setButtonTintList(ContextCompat.getColorStateList(ScheduleActivity.this, R.color.slot_available_tick));
                        flag = 1;
                    }

//
                }
                if (flag == 0){
                    slot.setEnabled(false);
                    slot.setBackgroundResource(R.color.slot_disabled);
                }
//                else{
//                    slot.setEnabled(false);
//                    slot.setBackgroundResource(R.color.slot_disabled);
//                    //currslots[i-1] = 1;
//                }

            }
            else if (currslots[i-1] == 2) { // it is enabled, not checked
                int flag = 0;
                if (!previd.equals("")){
                    if(currslots[i-2] == 3) {
                        //int presID = getResources().getIdentifier(previd, "id", getPackageName());
                        //CheckBox pslot = (CheckBox) findViewById(presID);
                        ////pslot.setEnabled(true);
                        slot.setEnabled(true);
                        slot.setBackgroundResource(R.color.slot_available);
                        //slot.setButtonTintList(ColorStateList.valueOf(resources.getColor(R.id.blue_100)));
                        slot.setButtonTintList(ContextCompat.getColorStateList(ScheduleActivity.this, R.color.slot_available_tick));
                        flag = 1;
                    }
                }
                if (!nextid.equals("")){
                    if(currslots[i] == 3) {
                        //int nresID = getResources().getIdentifier(nextid, "id", getPackageName());
                        //CheckBox nslot = (CheckBox) findViewById(nresID);
                        //nslot.setEnabled(true);
                        slot.setEnabled(true);
                        slot.setBackgroundResource(R.color.slot_available);
                        //slot.setButtonTintList(ColorStateList.valueOf(resources.getColor(R.id.blue_100)));
                        slot.setButtonTintList(ContextCompat.getColorStateList(ScheduleActivity.this, R.color.slot_available_tick));
                        flag = 1;
                    }
//
                }
                if (flag == 0){
                    slot.setEnabled(false);
                    slot.setBackgroundResource(R.color.slot_disabled);
                    currslots[i-1] = 1;
                }

            }

        }
    }
    public void disableCheckboxes(int slotnum1){
        String previd = "slot_"+(slotnum1-1);
        String nextid = "slot_"+(slotnum1+1);

        // getting current checkbox
        int resIDcurr = getResources().getIdentifier("slot_"+slotnum1, "id", getPackageName());
        CheckBox slotcurr = (CheckBox) findViewById(resIDcurr);
        for(int i=1 ; i<=42 ; i++) {
            String abc = "slot_" + String.valueOf(i);
            int resID = getResources().getIdentifier(abc, "id", getPackageName());
            CheckBox slot = (CheckBox) findViewById(resID);
            if ((previd.equals(abc)||nextid.equals(abc)) && currslots[i-1] == 1 && slotcurr.isChecked() ) { //if available
                slot.setEnabled(true);
                slot.setBackgroundResource(R.color.slot_available);
                //slot.setButtonTintList(ColorStateList.valueOf(resources.getColor(R.id.blue_100)));
                slot.setButtonTintList(ContextCompat.getColorStateList(ScheduleActivity.this, R.color.slot_available_tick));
            }
            else if (currslots[i-1] == 1 && !(abc.equals("slot_"+slotnum1))){
                slot.setEnabled(false);
                slot.setBackgroundResource(R.color.slot_disabled);
            }

        }
    }



    public void checkboxClicked(View v) {
        int clickedid = v.getId();
        String clickedbox = v.getResources().getResourceName(clickedid);
        String finalid = clickedbox.split("/")[1];
        int slotnum = Integer.parseInt(finalid.split("_")[1]);
        int resID = getResources().getIdentifier(finalid, "id", getPackageName());
        CheckBox slot = (CheckBox) findViewById(resID);
        Log.d("SLOTS","slot.ischecked : " + slot.isChecked());
        if (slot.isChecked()){
            currslots[slotnum-1] = 3; // set the checked slot to 2
        }
        else {
            currslots[slotnum-1] = 2;
        }
        String arrayprint=" Before : ";
        for (int i=0;i<42;i++)
        {
            arrayprint += currslots[i] +",";
        }
        Log.d("SLOTS","ARRAY : "+arrayprint);
        // disabling all the other checkboxes (except pre and next)
        //disableCheckboxes(slotnum);
        checkboxremake();

        arrayprint=" After : ";
        for (int i=0;i<42;i++)
        {
            arrayprint += currslots[i] +",";
        }
        Log.d("SLOTS","ARRAY : "+arrayprint);

        //Toast.makeText(ScheduleActivity.this,"Id clicked:"+slotmap.get(finalid),Toast.LENGTH_LONG).show();

        String startslot="",endslot = "";
        // List list = Arrays.asList(currslots);
        int firstindex=-1,lastindex=-1;
        for (int i=0;i<42;i++){
            if(currslots[i] == 3)
            {
                firstindex = i;
                break;
            }
        }
        for (int i=41;i>=0;i--){
            if(currslots[i] == 3)
            {
                lastindex = i;
                break;
            }
        }
        if (firstindex == -1){ // all are unselected
            setCheckboxes();
            for(int i=0;i<42;i++)
            {
                currslots[i] = timeslot[i];
            }
            TextView selectedslottxt = (TextView) findViewById(R.id.selectedslot);
            selectedslottxt.setText(new String("Selected Slot : N/A - N/A"));
        }
        else {
            // final slots text
            startslot = "slot_" + (firstindex + 1);
            endslot = "slot_" + (lastindex + 1);
            Log.d("SLOTS", "Startslot = " + startslot);
            Log.d("SLOTS", "Endslot = " + endslot);
            //Log.d("SLOTS","List = "+list);
            String starttimeslotclicked[] = slotmap.get(startslot).split("-");
            String endtimeslotclicked[] = slotmap.get(endslot).split("-");
            selectedslot[0] = starttimeslotclicked[0];
            selectedslot[1] = endtimeslotclicked[1];
            TextView selectedslottxt = (TextView) findViewById(R.id.selectedslot);
            selectedslottxt.setText(new String("Selected Slot : " + selectedslot[0] + " - " + selectedslot[1]));
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
//code