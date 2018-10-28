package com.notexample.coltonquan.tappadabba;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;

/*import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;*/

public class EndScreen extends AppCompatActivity {

    public static final String prefsName = "myPrefsFile";
    public static Integer highScoreInt;

    MediaPlayer mediaPlayer;
    Integer length = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_screen);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        /*MobileAds.initialize(getApplicationContext(), "ca-app-pub-4688351229631812~9876866287");

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);*/

        TextView dabText = (TextView)findViewById(R.id.dabText);
        TextView miniText = (TextView)findViewById(R.id.miniText);
        TextView backText = (TextView)findViewById(R.id.backText);
        TextView highText = (TextView)findViewById(R.id.highText);
        TextView lowText = (TextView)findViewById(R.id.lowText);
        TextView specialText = (TextView)findViewById(R.id.specialText);
        TextView scoreText = (TextView)findViewById(R.id.scoreText);
        TextView highScoreText = (TextView)findViewById(R.id.highScoreText);


        Bundle scoreData = getIntent().getExtras();
        if (scoreData == null) {
            return;
        }

        Integer dabCount = scoreData.getInt("dabCount");
        Integer miniCount = scoreData.getInt("miniCount");
        Integer backCount = scoreData.getInt("backCount");
        Integer highCount = scoreData.getInt("highCount");
        Integer lowCount = scoreData.getInt("lowCount");
        Integer specialCount = scoreData.getInt("specialCount");

        final Integer score = dabCount + miniCount + backCount + highCount + lowCount + specialCount;

        dabText.setText("Dabs : " + String.valueOf(dabCount));
        miniText.setText("Mini Dabs : " + String.valueOf(miniCount));
        backText.setText("Back Dabs : " + String.valueOf(backCount));
        highText.setText("High Dabs : " + String.valueOf(highCount));
        lowText.setText("Low Dabs : " + String.valueOf(lowCount));
        specialText.setText("Mystery Dabs : " + String.valueOf(specialCount));

        dabText.setTextColor(Color.parseColor("#ff0000"));
        miniText.setTextColor(Color.parseColor("#0000ff"));
        backText.setTextColor(Color.parseColor("#00ff00"));
        highText.setTextColor(Color.parseColor("#ffa500"));
        lowText.setTextColor(Color.parseColor("#800080"));
        specialText.setTextColor(Color.parseColor("#000000"));

        scoreText.setText(String.valueOf(score));

        SharedPreferences prefs = getSharedPreferences(prefsName, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        highScoreInt = prefs.getInt("highScore", 0);

        if (score > highScoreInt) {

            editor.remove("highScore");
            editor.putInt("highScore", score);
            editor.apply();

            highScoreText.setText("NEW HIGHSCORE: " + String.valueOf(score));

        } else {

            highScoreText.setText("Highscore: " + String.valueOf(highScoreInt));

        }

    }

    public void onClickPlayButton(View view) {

        Intent i = new Intent(EndScreen.this, PlayScreen.class);
        startActivity(i);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

    }

    @Override
    public void onBackPressed() {

        Intent i = new Intent(EndScreen.this, HomeScreen.class);
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
