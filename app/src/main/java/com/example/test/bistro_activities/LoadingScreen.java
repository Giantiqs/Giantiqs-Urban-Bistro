package com.example.test.bistro_activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.test.R;

import java.util.Timer;
import java.util.TimerTask;

public class LoadingScreen extends AppCompatActivity {

    ProgressBar horizontal_progress_bar;
    TextView loading_text;
    int counter = 0;
    private VideoView video_view;
    MediaPlayer media_player;
    int current_position;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bistro_loading);

        start_load();

        Handler h = new Handler();
        h.postDelayed(() -> {
            startActivity(new Intent(LoadingScreen.this, MainMenu.class));
            finish();
        }, 8000);

        video_view = findViewById(R.id.vidView);
        String video_path = "android.resource://" + getPackageName() + "/" + R.raw.movebg;
        Uri uri = Uri.parse(video_path);
        video_view.setVideoURI(uri);


        video_view.setOnPreparedListener(mediaPlayer -> {
            media_player = mediaPlayer;
            media_player.setLooping(true);

            if(current_position != 0) {
                media_player.seekTo(current_position);
                media_player.start();
            }
        });
    }

    public void start_load() {

        loading_text = findViewById(R.id.loading_text);
        horizontal_progress_bar = findViewById(androidx.appcompat.R.id.progress_horizontal);
        Timer t = new Timer();

        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                counter++;
                horizontal_progress_bar.setProgress(counter);

                if(counter == 100){
                    t.cancel();
                }
            }
        };

        t.schedule(tt, 0, 100);
    }

    @Override
    protected void onPause() {
        super.onPause();
        video_view.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        video_view.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        media_player.release();
        media_player = null;
    }

}
