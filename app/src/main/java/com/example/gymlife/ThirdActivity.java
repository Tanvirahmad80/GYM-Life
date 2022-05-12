package com.example.gymlife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    String buttonvalue;
    Button startBtn;
    private CountDownTimer countDownTimer;
    TextView mtextview;
    private boolean MTimeRunning;
    private long MtimeLeftinmills;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);


        Intent intent = getIntent();
        buttonvalue = intent.getStringExtra("value");


        int intvalue = Integer.valueOf(buttonvalue);


        switch (intvalue){


            case 1:
                setContentView(R.layout.activity_chest_press);
                break;
            case 2:
                setContentView(R.layout.activity_chest_flies);
                break;
            case 3:
                setContentView(R.layout.activity_incline_chest);
                break;
            case 4:
                setContentView(R.layout.activity_shoulder_press);
                break;
            case 5:
                setContentView(R.layout.activity_reverse_flies);
                break;
            case 6:
                setContentView(R.layout.activity_bent_rows);
                break;
            case 7:
                setContentView(R.layout.activity_flat_chestpress);
                break;
            case 8:
                setContentView(R.layout.activity_dumbbell_lunges);
                break;
            case 9:
                setContentView(R.layout.activity_concentraion_curls);
                break;
            case 10:
                setContentView(R.layout.activity_french_presses);
                break;
            case 11:
                setContentView(R.layout.activity_upright_rows);
                break;
            case 12:
                setContentView(R.layout.activity_shrugs);
                break;
            case 13:
                setContentView(R.layout.activity_deline_biceps);
                break;
            case 14:
                setContentView(R.layout.activity_hammer_curls);
                break;
            case 15:
                setContentView(R.layout.activity_preacher_curls);
                break;
            case 16:
                setContentView(R.layout.activity_triceps_ext);
                break;
            case 17:
                setContentView(R.layout.activity_front_raise);
                break;
            case 18:
                setContentView(R.layout.activity_lateral_raises);
                break;
            case 19:
                setContentView(R.layout.activity_single_arm_row);
                break;
            case 20:
                setContentView(R.layout.activity_dead_lifts);
                break;
            case 21:
                setContentView(R.layout.activity_triceps_kick);
                break;
            case 22:
                setContentView(R.layout.activity_half_squats);
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

                    Intent intent = new Intent(ThirdActivity.this, ThirdActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra("value", String.valueOf(newValue));
                    startActivity(intent);

                } else {


                    newValue =1;
                    Intent intent = new Intent(ThirdActivity.this,ThirdActivity.class);
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