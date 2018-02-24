package com.example.boylan19.myapplication;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity
{
    //Part 1
    private ToggleButton powerButton;
    private TextView radioDisplay;
    private boolean powerOn;
    private int slimeGreen = 0xff99cc00;
    private ImageView powerLight;
    private TextClock clock;
    private RatingBar rater;
    private SeekBar volume;

    //Part 2
    private Switch amfm;
    private ImageButton upStation;
    private ImageButton downStation;
    private boolean channel;
    private double radioNum;
    private boolean am;

    //PArt 3
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;



    //Part 4
    public int[] amPresets = {550, 600, 650, 700, 750, 800};
    public double[] fmPresets = {90.9, 92.9, 94.9, 96.9, 98.9, 100.9};

    MediaPlayer mySound;
    MediaPlayer found;
    MediaPlayer gold;
    MediaPlayer headlights;
    MediaPlayer hold;
    MediaPlayer mess;
    MediaPlayer ok;




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mySound = MediaPlayer.create(this,R.raw.song);
        found = MediaPlayer.create(this,R.raw.found);
        gold = MediaPlayer.create(this,R.raw.gold);
        headlights = MediaPlayer.create(this,R.raw.headlights);
        hold = MediaPlayer.create(this,R.raw.hold);
        mess = MediaPlayer.create(this,R.raw.mess);
        ok = MediaPlayer.create(this,R.raw.ok);


        radioDisplay = (TextView)findViewById(R.id.radioDisplay);
        powerButton = (ToggleButton)findViewById(R.id.PowerButton);
        powerButton.setOnClickListener(new PowerButtonListener());
        powerOn = false;
        powerLight = (ImageView)findViewById(R.id.PowerLight);
        clock = (TextClock)findViewById(R.id.Clock);
        rater = (RatingBar)findViewById(R.id.Rater);
        volume = (SeekBar)findViewById(R.id.Volume);

        amfm = (Switch)findViewById(R.id.AMFM);
        amfm.setOnClickListener(new AMFMButtonListener());
        channel = false;
        am = false;
        upStation = (ImageButton)findViewById(R.id.UpStation);
        upStation.setOnClickListener(new UpStationButtonListener());
        downStation = (ImageButton)findViewById(R.id.DownStation);
        downStation.setOnClickListener(new DownStationButtonListener());

        one = (Button)findViewById(R.id.One);
        one.setOnClickListener(new OneButtonListener());
        one.setOnLongClickListener(new longClickListener());

        two = (Button)findViewById(R.id.Two);
        two.setOnClickListener(new TwoButtonListener());
        two.setOnLongClickListener(new longClickListener());

        three = (Button)findViewById(R.id.Three);
        three.setOnClickListener(new ThreeButtonListener());
        three.setOnLongClickListener(new longClickListener());

        four = (Button)findViewById(R.id.Four);
        four.setOnClickListener(new FourButtonListener());
        four.setOnLongClickListener(new longClickListener());

        five = (Button)findViewById(R.id.Five);
        five.setOnClickListener(new FiveButtonListener());
        five.setOnLongClickListener(new longClickListener());

        six = (Button)findViewById(R.id.Six);
        six.setOnClickListener(new SixButtonListener());
        six.setOnLongClickListener(new longClickListener());

    }

    public void stopMusic(View view) {
        mySound.stop();
        found.stop();
        gold.stop();
        headlights.stop();
        hold.stop();
        mess.stop();
        ok.stop();


    }

    private class PowerButtonListener implements View.OnClickListener
    {
        public void onClick(View v)
        {


            if(powerOn == false)
            {
                radioDisplay.setTextColor(Color.BLACK);
                powerLight.setVisibility(View.INVISIBLE);
                clock.setVisibility(View.INVISIBLE);
                rater.setVisibility(View.INVISIBLE);
                one.setVisibility(View.INVISIBLE);
                two.setVisibility(View.INVISIBLE);
                three.setVisibility(View.INVISIBLE);
                four.setVisibility(View.INVISIBLE);
                five.setVisibility(View.INVISIBLE);
                six.setVisibility(View.INVISIBLE);
                amfm.setVisibility(View.INVISIBLE);
                upStation.setVisibility(View.INVISIBLE);
                downStation.setVisibility(View.INVISIBLE);
                volume.setVisibility(View.INVISIBLE);
            }
            else
            {
                radioDisplay.setTextColor(slimeGreen);
                powerLight.setVisibility(View.VISIBLE);
                clock.setVisibility(View.VISIBLE);
                rater.setVisibility(View.VISIBLE);
                one.setVisibility(View.VISIBLE);
                two.setVisibility(View.VISIBLE);
                three.setVisibility(View.VISIBLE);
                four.setVisibility(View.VISIBLE);
                five.setVisibility(View.VISIBLE);
                six.setVisibility(View.VISIBLE);
                amfm.setVisibility(View.VISIBLE);
                upStation.setVisibility(View.VISIBLE);
                downStation.setVisibility(View.VISIBLE);
                volume.setVisibility(View.VISIBLE);
                mySound.start();
            }
            powerOn =! powerOn;
        }
    }
    private class AMFMButtonListener implements View.OnClickListener
    {
        public void onClick(View v)
        {
            if(channel == false)
            {
                radioNum = 88.1;
                radioDisplay.setText(radioNum + " MHz");
            }
            else
            {
                radioNum = 530;
                radioDisplay.setText(radioNum + " kHz");
            }
            channel =! channel;
        }
    }

    private class UpStationButtonListener implements View.OnClickListener
    {
        public void onClick(View v)
        {




            if(channel == false)
            {
                radioNum = radioNum + 10;
                if(radioNum > 1700)
                {
                    radioDisplay.setText(530 + " kHz");

                }
                else
                {
                    radioDisplay.setText(radioNum + " kHz");
                }

            }
            else
            {
                if(radioNum > 107.9)
                {
                    radioDisplay.setText(88.1 + " MHz");

                }
                else
                {
                    radioNum = radioNum * 10;
                    int i;
                    i = (int) radioNum + 2;
                    radioNum = (double) i / 10;
                    radioDisplay.setText(radioNum + " MHz");
                }
            }

        }
    }
    private class DownStationButtonListener implements View.OnClickListener
    {
        public void onClick(View v)
        {
            if(channel == false)
            {
                radioNum = radioNum - 10;
                if(radioNum < 530)
                {
                    radioDisplay.setText(1700.0 + " kHz");

                }
                else
                {
                    radioDisplay.setText(radioNum + " kHz");
                }

            }
            else
            {
                radioNum = radioNum * 10;
                int i;
                i = (int) radioNum - 2;
                radioNum = (double) i / 10;
                if(radioNum < 88.1)
                {
                    radioDisplay.setText(107.9 + " MHz");

                }
                else
                {

                    radioDisplay.setText(radioNum + " MHz");
                }
            }
        }
    }

    private class OneButtonListener implements View.OnClickListener
    {
        public void onClick(View v)
        {
           found.start();

            if( channel==false)
            {
                radioNum = amPresets[0];
                radioDisplay.setText(radioNum + " kHz");
            }
            else
            {
                radioNum = amPresets[0];
                radioDisplay.setText(radioNum + " MHz");
            }
        }

    }

    private class TwoButtonListener implements View.OnClickListener
    {
        public void onClick(View v)
        {
            gold.start();
            if( channel==false)
            {
                radioNum = amPresets[1];
                radioDisplay.setText(radioNum + " kHz");
            }
            else
            {
                radioNum = fmPresets[1];
                radioDisplay.setText(radioNum + " MHz");
            }
        }

    }
    private class ThreeButtonListener implements View.OnClickListener
    {
        public void onClick(View v)
        {
            headlights.start();
            if( channel==false)
            {
                radioNum = amPresets[2];
                radioDisplay.setText(radioNum + " kHz");
            }
            else
            {
                radioNum = fmPresets[2];
                radioDisplay.setText(radioNum + " MHz");
            }
        }

    }
    private class FourButtonListener implements View.OnClickListener
    {
        public void onClick(View v)
        {
            hold.start();

            if( channel==false)
            {
                radioNum = amPresets[3];
                radioDisplay.setText(radioNum + " kHz");
            }
            else
            {
                radioNum = fmPresets[3];
                radioDisplay.setText(radioNum + " MHz");
            }
        }

    }


    private class FiveButtonListener implements View.OnClickListener
    {
        public void onClick(View v)
        {
            mess.start();

            if( channel==false)
            {
                radioNum = amPresets[4];
                radioDisplay.setText(radioNum + " kHz");
            }
            else
            {
                radioNum = fmPresets[4];
                radioDisplay.setText(radioNum + " MHz");
            }
        }

    }

    private class SixButtonListener implements View.OnClickListener
    {
        public void onClick(View v)
        {
            ok.start();

            if( channel==false)
            {
                radioNum = amPresets[5];
                radioDisplay.setText(radioNum + " kHz");
            }
            else
            {
                radioNum = fmPresets[5];
                radioDisplay.setText(radioNum + " MHz");
            }
        }

    }

    public class longClickListener implements View.OnLongClickListener
    {
        @Override
        public boolean onLongClick(View v) {
            int holder = v.getId();

            if(holder == R.id.One)
            {
                if(channel == false)
                {
                    amPresets[0] = (int) radioNum;
                    radioDisplay.setText(amPresets[0] + " kHz");
                }
                else
                {
                    fmPresets[0] = radioNum;
                    radioDisplay.setText(fmPresets[0] + " MHz");

                }
            }
            if(holder == R.id.Two)
            {
                if(channel == false)
                {
                    amPresets[1] = (int) radioNum;
                    radioDisplay.setText(amPresets[1] + " kHz");
                }
                else
                {
                    fmPresets[1] = radioNum;
                    radioDisplay.setText(fmPresets[1] + " MHz");

                }
            }
            if(holder == R.id.Three)
            {
                if(channel == false)
                {
                    amPresets[2] = (int)radioNum;
                    radioDisplay.setText(amPresets[1] + " kHz");
                }
                else
                {
                    fmPresets[2] = radioNum;
                    radioDisplay.setText(fmPresets[2] + " MHz");

                }
            }
            if(holder == R.id.Four)
            {
                if(channel == false)
                {
                    amPresets[3] = (int)radioNum;
                    radioDisplay.setText(amPresets[3] + " kHz");
                }
                else
                {
                    fmPresets[3] = radioNum;
                    radioDisplay.setText(fmPresets[3] + " MHz");

                }
            }
            if(holder == R.id.Five)
            {
                if(channel == false)
                {
                    amPresets[4] = (int)radioNum;
                    radioDisplay.setText(amPresets[4] + " kHz");
                }
                else
                {
                    fmPresets[4] = radioNum;
                    radioDisplay.setText(fmPresets[4] + " MHz");

                }
            }
            if(holder == R.id.Six)
            {
                if(channel == false)
                {
                    amPresets[5] = (int)radioNum;
                    radioDisplay.setText(amPresets[5] + " kHz");
                }
                else
                {
                    fmPresets[5] = radioNum;
                    radioDisplay.setText(fmPresets[5] + " MHz");

                }
            }

            return true;

        }
    }





}


