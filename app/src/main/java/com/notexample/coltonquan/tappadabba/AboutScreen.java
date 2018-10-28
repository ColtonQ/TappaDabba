package com.notexample.coltonquan.tappadabba;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AboutScreen extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    Integer length = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_screen);
    }

    public void onClick(View view) {

        Intent i = new Intent(AboutScreen.this, HomeScreen.class);
        startActivity(i);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

    }

    public void playMusic(){

        if (length == null) {

            length = 0;

        }

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.background_music_0);
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
