package com.notexample.coltonquan.tappadabba;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.view.View;


public class HomeScreen extends AppCompatActivity {

    public static CountDownTimer countDownTimer;
    ImageButton manButton;

    MediaPlayer mediaPlayer;

    Integer length = 0;

    CountDownTimer countDownTimerDanceMove;

    String side;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        manButton = (ImageButton)findViewById(R.id.manButton);

        side = "left";

    }

    public void onClickManButton(final View view) {

        if (countDownTimerDanceMove != null) {

            countDownTimerDanceMove.cancel();
        }

        if (side.equals("left")) {

            manButton.setImageResource(R.drawable.dab_left);

            side = "right";


        } else if (side.equals("right")) {

            manButton.setImageResource(R.drawable.dab_right);

            side = "left";

        }

        countDownTimerDanceMove =  new CountDownTimer(500, 50) {


            public void onTick(long millisUntilFinished) {

            }

            public void onFinish() {

                manButton.setImageResource(R.drawable.stand);

            }

        }.start();
    }

    public void onClickPlayButton(final View view){


        Intent i = new Intent(HomeScreen.this, PlayScreen.class);
        startActivity(i);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

    }

    public void playMusic(){

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.background_music_3);
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

    public void onClickAbout(View view) {

        Intent i = new Intent(HomeScreen.this, AboutScreen.class);
        startActivity(i);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

    }



}
