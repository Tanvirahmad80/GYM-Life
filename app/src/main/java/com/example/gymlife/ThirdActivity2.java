package com.example.gymlife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity2 extends AppCompatActivity {

    String buttonvalue;
    Button startBtn;
    private CountDownTimer countDownTimer;
    TextView mtextview;
    private boolean MTimeRunning;
    private long MtimeLeftinmills;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third2);


        Intent intent = getIntent();
        buttonvalue = intent.getStringExtra("value");


        int intvalue = Integer.valueOf(buttonvalue);


        switch (intvalue){


            case 1:
                setContentView(R.layout.activity_vertical_knee_raises);
                break;
            case 2:
                setContentView(R.layout.activity_side_crunches);
                break;
            case 3:
                setContentView(R.layout.activity_high_toes);
                break;
            case 4:
                setContentView(R.layout.activity_alt_heel_touches);
                break;
            case 5:
                setContentView(R.layout.activity_windsheild_wipers);
                break;
            case 6:
                setContentView(R.layout.activity_knee_raises);
                break;
            case 7:
                setContentView(R.layout.activity_single_leg_crunches);
                break;
            case 8:
                setContentView(R.layout.activity_dragonfly_leg_raises);
                break;
            case 9:
                setContentView(R.layout.activity_hip_raise);
                break;
            case 10:
                setContentView(R.layout.activity_power_planks);
                break;
            case 11:
                setContentView(R.layout.activity_cross_crunches);
                break;
            case 12:
                setContentView(R.layout.activity_alt_leg_raises);
                break;
            case 13:
                setContentView(R.layout.activity_crunches);
                break;
            case 14:
                setContentView(R.layout.activity_power_crunches);
                break;
            case 15:
                setContentView(R.layout.activity_atlas_pushups);
                break;


        }


        startBtn = findViewById(R.id.startbutton);
        mtextview = findViewById(R.id.time);



        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (MTimeRunning)
                {
                    stoptimer();


                }

                else{
                    startTimer();


                }

            }
        });


    }

    private void stoptimer()
    {

        countDownTimer.cancel();
        MTimeRunning = false;
        startBtn.setText("START");

    }




    private void startTimer() {

        final CharSequence value1 = mtextview.getText();
        String num1 = value1.toString();
        String num2 = num1.substring(0, 2);
        String num3 = num1.substring(3, 5);


//To Change the countdown time. 60= 1 min, for 2 min it would be 120. and so on...
        final int number = Integer.valueOf(num2) * 60+ Integer.valueOf(num3);
        MtimeLeftinmills = number*1000;


        countDownTimer = new CountDownTimer(MtimeLeftinmills, 1800) {
            @Override
            public void onTick(long millisUnitlFinished) {

                MtimeLeftinmills = millisUnitlFinished;
                updateTimer();

            }

            @Override
            public void onFinish() {


                int newValue = Integer.valueOf(buttonvalue)+1;
                if (newValue <= 7) {

                    Intent intent = new Intent(ThirdActivity2.this, ThirdActivity2.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra("value", String.valueOf(newValue));
                    startActivity(intent);

                } else {


                    newValue =1;
                    Intent intent = new Intent(ThirdActivity2.this,ThirdActivity2.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra("value", String.valueOf(newValue));
                    startActivity(intent);

                }

            }
        }.start();
        startBtn.setText("Pause");
        MTimeRunning=true;

    }


    private void updateTimer()

    {

        int minutes = (int) MtimeLeftinmills/60000;
        int seconds = (int) MtimeLeftinmills%60000 /1000;


        String timeLeftText="";
        if (minutes<10)
            timeLeftText="0";
        timeLeftText = timeLeftText+minutes+":";
        if (seconds<10)
            timeLeftText+="0";
        timeLeftText+=seconds;
        mtextview.setText(timeLeftText);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}