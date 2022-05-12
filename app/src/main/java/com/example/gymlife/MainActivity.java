package com.example.gymlife;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button1,button2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);


            button1 = findViewById(R.id.startgym1);
            button2 = findViewById(R.id.startgym2);


            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(intent);

                }
            });

            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(MainActivity.this,SecondActivity2.class);
                    startActivity(intent);

                }
            });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }


    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.id_privacy){

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://gymlifeapp.blogspot.com/2022/05/gym-life-privacy-policy-page.html"));
            startActivity(intent);

            return true;
        }
        if (id == R.id.id_term){

            Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://gymlifeapp.blogspot.com/2022/05/gym-life-terms-and-conditions-page.html"));
            startActivity(intent);

            return true;
        }
        if (id == R.id.id_rate){

            try {

                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("market://details?id=" + getPackageName())));

            }catch (Exception ex){


                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store/apps/details?id=" + getPackageName())));

            }

            return true;
        }
        if (id == R.id.id_developers){

            Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://gymlifeapp.blogspot.com/2022/05/gym-life-developers.html"));
            startActivity(intent);

            return true;
        }
        if (id == R.id.id_share){


            Intent myIntent = new Intent(Intent.ACTION_SEND);
            myIntent.setType("text/plain");
            String sharebody = "This is the best app for Gym work outs \n This App helps you to find the best workout for you with instructions\n it's free download now \n" + "https://play.google.com/store/apps/details?id=com.example.gymlife&hl=en";
            String sharehub = "Gym Life";
            myIntent.putExtra(Intent.EXTRA_SUBJECT,sharehub);
            myIntent.putExtra(Intent.EXTRA_TEXT,sharebody);
            startActivity(Intent.createChooser(myIntent,"share using"));


            return true;
        }
        return true;
    }

    public void strengthTraining(View view) {

        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
        startActivity(intent);


    }

    public void coreTraining(View view) {

        Intent intent = new Intent(MainActivity.this,SecondActivity2.class);
        startActivity(intent);


    }


    public void food(View view) {

        Intent intent = new Intent(MainActivity.this,FoodActivity.class);
        startActivity(intent);


    }
}