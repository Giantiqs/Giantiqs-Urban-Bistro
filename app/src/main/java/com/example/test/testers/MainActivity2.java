package com.example.test.testers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.test.bistro_activities.MainMenu;
import com.example.test.R;

public class MainActivity2 extends AppCompatActivity {

    private Button button;
    private TextView full_name, phone_number, email_address;
    private VideoView video_view;
    MediaPlayer media_player;
    int current_position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zactivity_main2);

        button = (Button) findViewById(R.id.button6);
        full_name = (TextView) findViewById(R.id.fuName);
        phone_number = (TextView) findViewById(R.id.fon);
        email_address = (TextView) findViewById(R.id.eadrr);


        /*
        video_view = findViewById(R.id.vidview);
        String video_path = "android.resource://" + getPackageName() + "/" + R.raw.vid;
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
        */
        String phone_number_str = getIntent().getStringExtra("key_phone_number"),
                email_address_str = getIntent().getStringExtra("key_email_address"),
                first_name_str = getIntent().getStringExtra("key_first_name"),
                middle_initial_temp_str = getIntent().getStringExtra("key_middle_name"),
                last_name_str = getIntent().getStringExtra("key_last_name");
        char middle_Initial = middle_initial_temp_str.charAt(0);


        full_name.setText(first_name_str + " " + middle_Initial + ". " + last_name_str);
        phone_number.setText(phone_number_str);

        if (email_address_str.isEmpty()){
            email_address.setText("No email entered.");
        }
        else {
            email_address.setText(email_address_str);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainAct();
            }
        });
    }



    public void openMainAct(){
        Intent i = new Intent(this, MainMenu.class);
        startActivity(i);
    }
/*
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
*/
}