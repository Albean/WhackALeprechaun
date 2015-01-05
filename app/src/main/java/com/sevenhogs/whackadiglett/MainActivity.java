package com.sevenhogs.whackadiglett;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    Button buttonStart;
    Button buttonExit;
    Button buttonEasy;
    Button buttonMedium;
    Button buttonHard;
    Context context;
    int diff = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        buttonStart = (Button) findViewById(R.id.buttonStart);
        buttonExit = (Button) findViewById(R.id.buttonExit);
        buttonEasy = (Button) findViewById(R.id.buttonEasy);
        buttonMedium = (Button) findViewById(R.id.buttonMedium);
        buttonHard = (Button) findViewById(R.id.buttonHard);

        buttonStart.setBackground(getResources().getDrawable(R.drawable.ic_goldpot));
        buttonExit.setBackground(getResources().getDrawable(R.drawable.ic_leppot));
        buttonEasy.setBackground(getResources().getDrawable(R.drawable.ic_easy));
        buttonMedium.setBackground(getResources().getDrawable(R.drawable.ic_easy));
        buttonHard.setBackground(getResources().getDrawable(R.drawable.ic_easy));




        buttonStart.setOnClickListener(new OnClickListener(){

            public void onClick(View v)
            {
                Intent intent = new Intent(context,Game.class);
                intent.putExtra("Difficulty",diff);
                startActivity(intent);

            }


        });


        buttonExit.setOnClickListener(new OnClickListener(){

            public void onClick(View v)
            {
                System.exit(0);

            }


        });


        buttonEasy.setOnClickListener(new OnClickListener(){

            public void onClick(View v)
            {
                diff = 1;

            }


        });

        buttonMedium.setOnClickListener(new OnClickListener(){

            public void onClick(View v)
            {
                diff = 2;

            }


        });

        buttonHard.setOnClickListener(new OnClickListener(){

            public void onClick(View v)
            {
                diff = 3;

            }


        });


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
