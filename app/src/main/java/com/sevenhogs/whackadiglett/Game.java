package com.sevenhogs.whackadiglett;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;
//import java.util.logging.Handler;

/**
 * Created by alanreidy on 30/11/14.
 */
public class Game extends Activity {

    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button button10;
    Button button11;
    Button button12;
    Button button13;
    Button button14;
    Button button15;
    Button button16;
    Button button17;
    Button button18;
    Button button19;
    Button button20;

    Button[] list =  new Button[20] ;
    int diff;


    private int UPS ;
    private int index;
    private int bindex;
    private int RENDER_DELAY = 100;
    private int score = 0;

    TextView tScore ;

    private int color1 = Color.RED;
    private int color2 = Color.GREEN;
    private long lastTime = 0;
    private Handler handler = new Handler();
    Random r = new Random();


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.layout_game);



        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        button10 = (Button) findViewById(R.id.button10);
        button11 = (Button) findViewById(R.id.button11);
        button12 = (Button) findViewById(R.id.button12);
        button13 = (Button) findViewById(R.id.button13);
        button14 = (Button) findViewById(R.id.button14);
        button15 = (Button) findViewById(R.id.button15);
        button16 = (Button) findViewById(R.id.button16);
        button17 = (Button) findViewById(R.id.button17);
        button18 = (Button) findViewById(R.id.button18);
        button19 = (Button) findViewById(R.id.button19);
        button20 = (Button) findViewById(R.id.button20);

        list[0] = button1;   list[1] = button2;     list[2] = button3;      list[3] = button4;
        list[4] = button5;   list[5] = button6;     list[6] = button7;      list[7] = button8;
        list[8] = button9;   list[9] = button10;     list[10] = button11;      list[11] = button12;
        list[12] = button13;   list[13] = button14;     list[14] = button15;      list[15] = button16;
        list[16] = button17;   list[17] = button18;     list[18] = button19;      list[19] = button20;

        Bundle extras = getIntent().getExtras();
        diff = extras.getInt("Difficulty");
        UPS = 1000/diff;

        Log.i("Diff", "The Difficulty is: " + diff);


        new Thread() {
            public void run() {
                if(System.currentTimeMillis() - lastTime >= UPS)
                {
                    randomBackground();
                    lastTime = System.currentTimeMillis();
                }
                handler.postAtTime(this, SystemClock.uptimeMillis() + RENDER_DELAY);
                Log.i("Diglett","The Score is : " + score);


            }


        }.start();

        tScore = new TextView(this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        addContentView(tScore, lp);
        tScore.setText("Score: "+ score);
        tScore.setTextSize(38);


    }

    public void clicked(View view)
    {
        if(view.getId() == list[index].getId()){
            lastTime = 0;
            score ++;
        }else if(view.getId() ==list[bindex].getId()) {

            score = score - 2;
        }
        else{
            score --;
        }
        tScore.setText("Score: "+ score);

    }

    private void randomBackground()
    {
        index = r.nextInt(list.length);

        bindex = r.nextInt(list.length);
        for(int i = 0; i < list.length; i++)
        {
            list[i].setBackground(getResources().getDrawable(R.drawable.ic_goldpot));
            //list[i].setBackground(getResources().getDrawable(R.drawable.ic_banshee));

        }
        list[index].setBackground(getResources().getDrawable(R.drawable.ic_leppot));
        list[bindex].setBackground(getResources().getDrawable(R.drawable.ic_banshee));



    }



}

