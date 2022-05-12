package com.example.gymlife;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class SecondActivity2 extends AppCompatActivity {


    int[] newArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);


        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);


        newArray = new int[]{

                R.id.pose_1, R.id.pose_2, R.id.pose_3,
                R.id.pose_4, R.id.pose_5, R.id.pose_6,
                R.id.pose_7, R.id.pose_8, R.id.pose_9,
                R.id.pose_10, R.id.pose_11, R.id.pose_12,
                R.id.pose_13, R.id.pose_14, R.id.pose_15,



        };

    }




    public void Imagebuttonclicked(View view) {


        for (int i=0;i<newArray.length;i++){


            if (view.getId() == newArray[i]) {
                int value = i+1;
                Log.i("FIRST",String.valueOf(value));
                Intent intent = new Intent(SecondActivity2.this,ThirdActivity2.class);
                intent.putExtra("value",String.valueOf(value));
                startActivity(intent);

            }
        }


    }
}