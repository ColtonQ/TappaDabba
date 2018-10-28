package com.notexample.coltonquan.tappadabba;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class PlayScreen extends AppCompatActivity {

    public static CountDownTimer countDownTimer;
    public static CountDownTimer countDownTimerDanceMove;
    public static CountDownTimer countDownTimerBeginning;
    public static CountDownTimer countDownTimerEnd;
    public static List<ImageButton> stripList;
    public static List<Integer> stripColours;
    public static List<Integer> colourNumList;
    public static List<Integer> dabListLeft;
    public static List<Integer> dabListRight;
    public static List<ImageButton> dabButtonList;
    public static List<Integer> dabButtonNumList;
    public static List<Integer> dabListLeftSpecial;
    public static List<Integer> dabListRightSpecial;


    Integer randNumMax;
    Integer randExtremeMax;
    Integer randExtremeSpecialMax;
    Integer seqNum;
    Integer seqNumMax;
    Integer extremeMax;
    Integer extremeSpecialMax;
    Integer speed;

    Boolean extreme;
    Boolean extremeSpecial;
    ImageButton lightblueButton;
    Boolean prevLightblue;
    String side;

    Drawable red;
    Drawable blue;
    Drawable green;
    Drawable orange;
    Drawable purple;
    Drawable black;
    Drawable lightblue;

    ImageButton dabButton;
    ImageButton specialButton;
    ImageButton miniButton;
    ImageButton highButton;
    ImageButton backButton;
    ImageButton lowButton;

    ImageButton manButton;

    ImageButton centerStrip;

    ImageButton countdownButton;

    Integer danceMove;
    Boolean midMove;
    Boolean firstSpecial;
    Integer specialMoveIndex;

    Integer dabCount;
    Integer miniCount;
    Integer backCount;
    Integer highCount;
    Integer lowCount;
    Integer specialCount;

    Integer totalCount;

    Boolean clicked;

    Integer availableMoveNum;

    TextView someText;
    TextView someText1;

    Boolean quiet;

    MediaPlayer mediaPlayer;

    Integer length = 0;

    SoundPool mySound;
    Float volumeFloat;

    MediaPlayer mediaPlayerReady;
    MediaPlayer mediaPlayerSet;
    MediaPlayer mediaPlayerTappa;



    public void backgroundColourChange(ImageButton selectStrip, Integer n) {

        Integer selectColourNum = colourNumList.get(n);

        if (selectColourNum == 1) {

            selectStrip.setBackgroundColor(0xff0000);

        } else if (selectColourNum == 2) {

            selectStrip.setBackgroundColor(0x0000ff);

        } else if (selectColourNum == 3) {

            selectStrip.setBackgroundColor(0x00ff00);

        } else if (selectColourNum == 4) {

            selectStrip.setBackgroundColor(0xFFA500);

        } else if (selectColourNum == 5) {

            selectStrip.setBackgroundColor(0x800080);

        } else if (selectColourNum == 6) {

            selectStrip.setBackgroundColor(0x000000);

        } else if (selectColourNum == 0) {

            selectStrip.setBackgroundColor(0xffffff);
        }

    }

    public void init() {

        stripList = new ArrayList<>();

        ImageButton b0 = (ImageButton)findViewById(R.id.imageButton84);
        ImageButton b1 = (ImageButton)findViewById(R.id.imageButton121);
        ImageButton b2 = (ImageButton)findViewById(R.id.imageButton120);
        ImageButton b3 = (ImageButton)findViewById(R.id.imageButton114);
        ImageButton b4 = (ImageButton)findViewById(R.id.imageButton113);
        ImageButton b5 = (ImageButton)findViewById(R.id.imageButton112);
        ImageButton b6 = (ImageButton)findViewById(R.id.imageButton111);
        ImageButton b7 = (ImageButton)findViewById(R.id.imageButton110);
        ImageButton b8 = (ImageButton)findViewById(R.id.imageButton109);
        ImageButton b9 = (ImageButton)findViewById(R.id.imageButton108);
        ImageButton b10 = (ImageButton)findViewById(R.id.imageButton107);
        ImageButton b11 = (ImageButton)findViewById(R.id.imageButton106);
        ImageButton b12 = (ImageButton)findViewById(R.id.imageButton105);
        ImageButton b13 = (ImageButton)findViewById(R.id.imageButton104);
        ImageButton b14 = (ImageButton)findViewById(R.id.imageButton103);
        ImageButton b15 = (ImageButton)findViewById(R.id.imageButton102);
        ImageButton b16 = (ImageButton)findViewById(R.id.imageButton101);
        ImageButton b17 = (ImageButton)findViewById(R.id.imageButton100);
        ImageButton b18 = (ImageButton)findViewById(R.id.imageButton99);
        ImageButton b19 = (ImageButton)findViewById(R.id.imageButton98);
        ImageButton b20 = (ImageButton)findViewById(R.id.imageButton97);
        ImageButton b21 = (ImageButton)findViewById(R.id.imageButton96);
        ImageButton b22 = (ImageButton)findViewById(R.id.imageButton95);
        ImageButton b23 = (ImageButton)findViewById(R.id.imageButton94);
        ImageButton b24 = (ImageButton)findViewById(R.id.imageButton93);
        ImageButton b25 = (ImageButton)findViewById(R.id.imageButton92);
        ImageButton b26 = (ImageButton)findViewById(R.id.imageButton91);
        ImageButton b27 = (ImageButton)findViewById(R.id.imageButton90);
        ImageButton b28 = (ImageButton)findViewById(R.id.imageButton89);
        ImageButton b29 = (ImageButton)findViewById(R.id.imageButton88);
        ImageButton b30 = (ImageButton)findViewById(R.id.imageButton87);
        ImageButton b31 = (ImageButton)findViewById(R.id.imageButton86);
        ImageButton b32 = (ImageButton)findViewById(R.id.imageButton85);

        stripList.add(b0);
        stripList.add(b1);
        stripList.add(b2);
        stripList.add(b3);
        stripList.add(b4);
        stripList.add(b5);
        stripList.add(b6);
        stripList.add(b7);
        stripList.add(b8);
        stripList.add(b9);
        stripList.add(b10);
        stripList.add(b11);
        stripList.add(b12);
        stripList.add(b13);
        stripList.add(b14);
        stripList.add(b15);
        stripList.add(b16);
        stripList.add(b17);
        stripList.add(b18);
        stripList.add(b19);
        stripList.add(b20);
        stripList.add(b21);
        stripList.add(b22);
        stripList.add(b23);
        stripList.add(b24);
        stripList.add(b25);
        stripList.add(b26);
        stripList.add(b27);
        stripList.add(b28);
        stripList.add(b29);
        stripList.add(b30);
        stripList.add(b31);
        stripList.add(b32);

        stripColours = new ArrayList<>();

        stripColours.add(R.drawable.red_strip);
        //stripColours.add(R.drawable.black_strip);
        //stripColours.add(R.drawable.blue_strip);
        //stripColours.add(R.drawable.orange_strip);
        //stripColours.add(R.drawable.green_strip);
        //stripColours.add(R.drawable.purple_strip);
        //stripColours.add(R.drawable.lightblue_strip);

        colourNumList = new ArrayList<>();

        colourNumList.add(0);
        colourNumList.add(0);
        colourNumList.add(0);
        colourNumList.add(0);
        colourNumList.add(0);
        colourNumList.add(0);
        colourNumList.add(0);
        colourNumList.add(0);
        colourNumList.add(0);
        colourNumList.add(0);
        colourNumList.add(0);
        colourNumList.add(0);
        colourNumList.add(0);
        colourNumList.add(0);
        colourNumList.add(0);
        colourNumList.add(0);
        colourNumList.add(0);
        colourNumList.add(0);
        colourNumList.add(0);
        colourNumList.add(0);
        colourNumList.add(0);
        colourNumList.add(0);
        colourNumList.add(0);
        colourNumList.add(0);
        colourNumList.add(0);
        colourNumList.add(0);
        colourNumList.add(0);
        colourNumList.add(0);
        colourNumList.add(0);
        colourNumList.add(0);
        colourNumList.add(0);
        colourNumList.add(0);
        colourNumList.add(0);

        dabButtonList = new ArrayList<>();

        dabButtonList.add((ImageButton)findViewById(R.id.dabButton));
        dabButtonList.add((ImageButton)findViewById(R.id.miniButton));
        dabButtonList.add((ImageButton)findViewById(R.id.backButton));
        dabButtonList.add((ImageButton)findViewById(R.id.highButton));
        dabButtonList.add((ImageButton)findViewById(R.id.lowButton));
        dabButtonList.add((ImageButton)findViewById(R.id.specialButton));

        dabButtonNumList = new ArrayList<>();

        dabButtonNumList.add(0);
        dabButtonNumList.add(1);
        dabButtonNumList.add(2);
        dabButtonNumList.add(3);
        dabButtonNumList.add(4);
        dabButtonNumList.add(5);

        dabListLeft = new ArrayList<>();

        dabListLeft.add(R.drawable.dab_left);
        dabListLeft.add(R.drawable.dab_mini_left);
        dabListLeft.add(R.drawable.dab_back_left);
        dabListLeft.add(R.drawable.dab_high_left);
        dabListLeft.add(R.drawable.dab_low_left);

        dabListRight = new ArrayList<>();

        dabListRight.add(R.drawable.dab_right);
        dabListRight.add(R.drawable.dab_mini_right);
        dabListRight.add(R.drawable.dab_back_right);
        dabListRight.add(R.drawable.dab_high_right);
        dabListRight.add(R.drawable.dab_low_right);

        dabListLeftSpecial = new ArrayList<>();

        //dabListLeftSpecial.add(R.drawable.dab_bubblejet_left);
        dabListLeftSpecial.add(R.drawable.dab_doge_left);
        dabListLeftSpecial.add(R.drawable.dab_illuminati_left);
        dabListLeftSpecial.add(R.drawable.dab_pepe_left);
        dabListLeftSpecial.add(R.drawable.dab_rainbow_left);
        dabListLeftSpecial.add(R.drawable.dab_sonic_left);

        dabListRightSpecial = new ArrayList<>();

        //dabListRightSpecial.add(R.drawable.dab_bubblejet_right);
        dabListRightSpecial.add(R.drawable.dab_doge_right);
        dabListRightSpecial.add(R.drawable.dab_illuminati_right);
        dabListRightSpecial.add(R.drawable.dab_pepe_right);
        dabListRightSpecial.add(R.drawable.dab_rainbow_right);
        dabListRightSpecial.add(R.drawable.dab_sonic_right);





        randNumMax = 15; //lowest is 15
        randExtremeMax = 10;
        randExtremeSpecialMax = 24; //has to be 25 to work

        seqNum = 0;

        seqNumMax = 3;
        extremeMax = 20;
        extremeSpecialMax = 40;

        prevLightblue = true;
        extreme = false;
        extremeSpecial = false;


        speed = 50; //usually speed = 50;

        side = "left";
        midMove = false;
        firstSpecial = true;

        dabCount = 0;
        miniCount = 0;
        backCount = 0;
        highCount = 0;
        lowCount = 0;
        specialCount = 0;

        totalCount = 0;

        clicked = false;

        availableMoveNum = 2;

        quiet = true;

        lightblueButton = (ImageButton)findViewById(R.id.lightblueButton);


        countDownTimer = new CountDownTimer(speed, 5) {


            public void onTick(long millisUntilFinished) {

            }

            public void onFinish() {

                Random randSecBetween = new Random();
                final int randNum = randSecBetween.nextInt(randNumMax) + 1;

                Random randExtreme = new Random();
                final int extremeNum = randExtreme.nextInt(randExtremeMax) + 1;

                Random randExtremeSpecial = new Random();
                final int extremeNumSpecial = randExtremeSpecial.nextInt(randExtremeSpecialMax) + 1;

                for (int n = 32; n >= 0; n--) {

                    ImageButton selectStrip = stripList.get(n);

                    if (n == 0) {

                        if (extremeSpecial) {

                            if (seqNum.equals(extremeSpecialMax)) {

                                extremeSpecial = false;

                                selectStrip.setImageResource(R.drawable.lightblue_strip);
                                selectStrip.setBackgroundColor(0xffffffff);

                                prevLightblue = true;
                                seqNum = 0;

                                colourNumList.remove(n);
                                colourNumList.add(n, 0);

                            } else {

                                ImageButton prevStrip = stripList.get(n + 1);
                                Drawable prevColour = prevStrip.getDrawable();
                                selectStrip.setImageDrawable(prevColour);

                                seqNum += 1;

                                Integer prevColourNum = colourNumList.get(n + 1);
                                colourNumList.remove(n);
                                colourNumList.add(n, prevColourNum);

                            }
                        }

                        else if (extreme) {

                            if (seqNum.equals(extremeMax)) {

                                extreme = false;

                                selectStrip.setImageResource(R.drawable.lightblue_strip);
                                selectStrip.setBackgroundColor(0xffffffff);

                                prevLightblue = true;
                                seqNum = 0;

                                colourNumList.remove(n);
                                colourNumList.add(n, 0);

                            } else {

                                ImageButton prevStrip = stripList.get(n + 1);
                                Drawable prevColour = prevStrip.getDrawable();
                                selectStrip.setImageDrawable(prevColour);

                                seqNum += 1;

                                Integer prevColourNum = colourNumList.get(n + 1);
                                colourNumList.remove(n);
                                colourNumList.add(n, prevColourNum);

                            }

                        } else if (!prevLightblue) {

                            if (seqNum >= 1 && seqNum <= seqNumMax) {

                                ImageButton prevStrip = stripList.get(n + 1);
                                Drawable prevColour = prevStrip.getDrawable();
                                selectStrip.setImageDrawable(prevColour);

                                seqNum += 1;

                                Integer prevColourNum = colourNumList.get(n + 1);
                                colourNumList.remove(n);
                                colourNumList.add(n, prevColourNum);



                            } else if (extremeNum == randExtremeMax) {

                                ImageButton prevStrip = stripList.get(n + 1);
                                Drawable prevColour = prevStrip.getDrawable();
                                selectStrip.setImageDrawable(prevColour);

                                seqNum += 1;

                                extreme = true;

                                Integer prevColourNum = colourNumList.get(n + 1);
                                colourNumList.remove(n);
                                colourNumList.add(n, prevColourNum);

                            } else {

                                selectStrip.setImageResource(R.drawable.lightblue_strip);
                                selectStrip.setBackgroundColor(0xffffffff);

                                prevLightblue = true;
                                seqNum = 0;

                                colourNumList.remove(n);
                                colourNumList.add(n, 0);

                            }

                        } else if (randNum != randNumMax) {

                            selectStrip.setImageResource(R.drawable.lightblue_strip);
                            selectStrip.setBackgroundColor(0xffffffff);

                            colourNumList.remove(n);
                            colourNumList.add(n, 0);

                            prevLightblue = true;
                            seqNum = 0;

                        } else if (prevLightblue) {

                            if (extremeNumSpecial == 25) {

                                extremeSpecial = true;

                                randColour(selectStrip);

                                prevLightblue = false;
                                seqNum += 1;

                            } else {

                                randColour(selectStrip);

                                prevLightblue = false;
                                seqNum += 1;

                            }

                        } else {

                            selectStrip.setImageResource(R.drawable.lightblue_strip);
                            selectStrip.setBackgroundColor(0xffffffff);

                            colourNumList.remove(n);
                            colourNumList.add(n, 0);

                            prevLightblue = true;
                            seqNum = 0;

                        }
                    }

                    else {

                        ImageButton prevStrip = stripList.get(n-1);
                        Drawable prevColour = prevStrip.getDrawable();
                        selectStrip.setImageDrawable(prevColour);

                        Integer prevColourNum = colourNumList.get(n - 1);
                        colourNumList.remove(n);
                        colourNumList.add(n, prevColourNum);
                    }

                    backgroundColourChange(selectStrip, n);


                }

                Integer selectColourNum = colourNumList.get(16);
                Integer prevColourNum = colourNumList.get(17);

                if (!prevColourNum.equals(0)){

                    if (selectColourNum.equals(0)){

                        if (!clicked){

                            gameOver();

                        } else {

                            clicked = false;

                            countDownTimer.start();
                        }

                    } else {

                        countDownTimer.start();

                    }

                } else {

                    countDownTimer.start();

                }


                //countDownTimer.start();

            }
            

        }.start();
    }

    public void randColour(ImageButton selectStrip) {

        Random randColour = new Random();
        int randColourNum = randColour.nextInt(availableMoveNum) + 1; //max is availableMoveNum = 5

        if (totalCount >= 50) {

            //randExtremeSpecialMax = 20;
            availableMoveNum = 5;
            randNumMax = 15;

        } else if (totalCount >= 40) {

            availableMoveNum = 5;
            randNumMax = 15;

        } else if (totalCount >= 30) {

            availableMoveNum = 4;
            randNumMax = 15;

        } else if (totalCount >= 20) {

            randExtremeSpecialMax = 25; //*************************************************************************************

            availableMoveNum = 3;
            randNumMax = 15;

        }

        if (extremeSpecial) {

            selectStrip.setImageResource(R.drawable.black_strip);
            randColourNum = 6;
        }

        else if (randColourNum == 1) {

            selectStrip.setImageResource(R.drawable.red_strip);

        } else if (randColourNum == 2) {

            selectStrip.setImageResource(R.drawable.blue_strip);

        } else if (randColourNum == 3) {

            selectStrip.setImageResource(R.drawable.green_strip);

        } else if (randColourNum == 4) {

            selectStrip.setImageResource(R.drawable.orange_strip);

        } else if (randColourNum == 5) {

            selectStrip.setImageResource(R.drawable.purple_strip);

        } else if (randColourNum == 6) {

            selectStrip.setImageResource(R.drawable.black_strip);

        }

        colourNumList.remove(0);
        colourNumList.add(0, randColourNum);


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_screen);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        someText = (TextView)findViewById(R.id.someText);
        someText.setText("");
        someText1 = (TextView)findViewById(R.id.someText1);
        someText1.setText("");

        dabButton = (ImageButton)findViewById(R.id.dabButton);
        miniButton = (ImageButton)findViewById(R.id.miniButton);
        backButton = (ImageButton)findViewById(R.id.backButton);
        highButton = (ImageButton)findViewById(R.id.highButton);
        lowButton = (ImageButton)findViewById(R.id.lowButton);
        specialButton = (ImageButton)findViewById(R.id.specialButton);

        centerStrip = (ImageButton)findViewById(R.id.imageButton101);

        countdownButton = (ImageButton)findViewById(R.id.countdownButton);

        dabButton.setBackgroundColor(0xff0000);
        miniButton.setBackgroundColor(0x0000ff);
        backButton.setBackgroundColor(0x00ff00);
        highButton.setBackgroundColor(0xFFA500);
        lowButton.setBackgroundColor(0x800080);
        specialButton.setBackgroundColor(0x000000);

        dabButton.setEnabled(false);
        miniButton.setEnabled(false);
        backButton.setEnabled(false);
        highButton.setEnabled(false);
        lowButton.setEnabled(false);
        specialButton.setEnabled(false);

        mySound = new SoundPool(-1, AudioManager.STREAM_MUSIC, 0);

        mediaPlayerSet = MediaPlayer.create(this, R.raw.set_voice);
        mediaPlayerReady = MediaPlayer.create(this, R.raw.ready_voice);
        mediaPlayerTappa = MediaPlayer.create(this, R.raw.tappa_voice);




        countDownTimerBeginning = new CountDownTimer(3000, 50){

            Boolean readySaid = false;
            Boolean setSaid = false;
            Boolean tappaDabbawaySaid = false;

            ImageButton countdownButton = (ImageButton)findViewById(R.id.countdownButton);

            public void onTick(long millisUntilFinished) {
                if (TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)) == 0) {
                    countdownButton.setImageResource(R.drawable.tappadabbaway_text);
                    countdownButton.setBackgroundColor(0xffffffff);

                    mediaPlayerTappa.start();


                }
                else if (TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)) <= 1) {
                    countdownButton.setImageResource(R.drawable.set_text);
                    countdownButton.setBackgroundColor(0xffffffff);

                    mediaPlayerSet.start();

                }
                else if (TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)) <= 2) {
                    countdownButton.setImageResource(R.drawable.ready_text);
                    countdownButton.setBackgroundColor(0xffffffff);

                    mediaPlayerReady.start();


                }

            }
            public void onFinish() {
                countdownButton.setBackgroundColor(0x00000000);
                countdownButton.setImageResource(android.R.color.transparent);

                dabButton.setEnabled(true);
                miniButton.setEnabled(true);
                backButton.setEnabled(true);
                highButton.setEnabled(true);
                lowButton.setEnabled(true);
                specialButton.setEnabled(true);

                quiet = false;

                mediaPlayerReady.release();
                mediaPlayerSet.release();

                init();
            }
        }.start();
    }


    public void onClick(View view) {

        if (mediaPlayerTappa != null) {

            mediaPlayerTappa.release();

        }

        clicked = true;

        if( view instanceof ImageButton ) {
            ImageButton clickedButton = (ImageButton) view;

        ColorDrawable clickedColour = (ColorDrawable)clickedButton.getBackground();
        Integer clickedColourId = clickedColour.getColor();

        ColorDrawable centerColour = (ColorDrawable)centerStrip.getBackground();
        Integer centerColourId = centerColour.getColor();

        if (clickedColourId.equals(centerColourId)){

            selectDanceMove(clickedButton);

        } else {

            gameOver();
        }

        //someText.setText(String.valueOf(clickedColourId) + " " + String.valueOf(centerColourId));

        }
    }

    public void selectDanceMove(ImageButton clickedButton){

        Integer clickedIndex = dabButtonList.indexOf(clickedButton);

        Random randSpecialMove = new Random();

        if (clickedIndex.equals(5)) {

            if (firstSpecial) {

                specialMoveIndex = randSpecialMove.nextInt(dabListLeftSpecial.size());

                firstSpecial = false;
            }

            if (side.equals("left")) {

                danceMove = dabListLeftSpecial.get(specialMoveIndex);

                side = "right";
            }

            else if (side.equals("right")) {

                danceMove = dabListRightSpecial.get(specialMoveIndex);

                side = "left";

            }

        } else {

            if (side.equals("left")) {

                danceMove = dabListLeft.get(clickedIndex);

                side = "right";
            }

            else if (side.equals("right")) {

                danceMove = dabListRight.get(clickedIndex);

                side = "left";

            }

            firstSpecial = true;
        }

        midMove = true;

        if (clickedIndex.equals(0)) {

            dabCount += 1;

        } else if (clickedIndex.equals(1)) {

            miniCount += 1;

        } else if (clickedIndex.equals(2)) {

            backCount += 1;

        } else if (clickedIndex.equals(3)) {

            highCount += 1;

        } else if (clickedIndex.equals(4)) {

            lowCount += 1;

        } else if (clickedIndex.equals(5)) {

            specialCount += 1;

        }

        totalCount += 1;

        setDanceMove(danceMove);
    }

    public void setDanceMove(final Integer danceMove) {

        manButton = (ImageButton)findViewById(R.id.manButton);

        if (countDownTimerDanceMove != null) {

            countDownTimerDanceMove.cancel();
        }

        countDownTimerDanceMove =  new CountDownTimer(500, 50) {


            public void onTick(long millisUntilFinished) {

                manButton.setImageResource(danceMove);
            }

            public void onFinish() {

                manButton.setImageResource(R.drawable.stand);

                midMove = false;

                if (side.equals("left")) {

                    side = "right";

                } else if (side.equals("right")) {

                    side = "left";

                }

            }

        }.start();
    }

    public void gameOver() {

        mediaPlayer.pause();

        final MediaPlayer mediaPlayerGameOver = MediaPlayer.create(this, R.raw.gameover_music);

        float volumeNum = (float) 0.15;

        mediaPlayerGameOver.setVolume(volumeNum ,volumeNum);

        countdownButton.setImageResource(R.drawable.gameover_text);

        countDownTimer.cancel();

        countDownTimerEnd = new CountDownTimer(2500, 1000){

            public void onTick(long millisUntilFinished) {

                mediaPlayerGameOver.start();

                dabButton.setEnabled(false);
                miniButton.setEnabled(false);
                backButton.setEnabled(false);
                highButton.setEnabled(false);
                lowButton.setEnabled(false);
                specialButton.setEnabled(false);

            }

            public void onFinish() {

                mediaPlayerGameOver.release();

                Intent i = new Intent(PlayScreen.this, EndScreen.class);


                i.putExtra("dabCount", dabCount);
                i.putExtra("miniCount", miniCount);
                i.putExtra("backCount", backCount);
                i.putExtra("highCount", highCount);
                i.putExtra("lowCount", lowCount);
                i.putExtra("specialCount", specialCount);
                i.putExtra("totalCount", totalCount);

                startActivity(i);


                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

            }

        }.start();

    }

    @Override
    public void onBackPressed() {

        if (countDownTimer != null) {

            countDownTimer.cancel();

        }

        if (countDownTimerBeginning != null) {

            countDownTimerBeginning.cancel();

        }

        if (countDownTimerEnd != null) {

            countDownTimerEnd.cancel();

        }

        Intent i = new Intent(PlayScreen.this, HomeScreen.class);
        startActivity(i);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    public void playMusic(){

        Random randMusicNum = new Random();
        final int musicNum = randMusicNum.nextInt(3) + 1;

        if (musicNum == 1) {

            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.background_music_1);

        } else if (musicNum == 2) {

            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.background_music_2);

        } else if (musicNum == 3) {

            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.background_music_3);

        }


        mediaPlayer.seekTo(length);
        mediaPlayer.start();
        mediaPlayer.setLooping(true);

        float volumeNum = (float) 0.15;

        mediaPlayer.setVolume(volumeNum ,volumeNum);

    }

    @Override
    public void onPause() {

        mediaPlayer.stop();
        length = mediaPlayer.getCurrentPosition();
        mediaPlayer.release();

        super.onPause();
    }

    @Override
    public void onResume() {

        playMusic();

        super.onResume();

    }

}

//public void printNo( View v ) {
//switch (v.getId()) {
//      case (R.id.Button_1):
//      //stuff
//      break;
//      case (R.id.Button_2):
//      //stuff
//      break;
//      case (R.id.Button_3):
//      //stuff
//      break;
//      }
