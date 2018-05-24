package com.example.kostyantin.lab4android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class InternetActivity extends AppCompatActivity
{

    VideoView videoPlayer2;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internet);

        try
        {
            videoPlayer2 = (VideoView) findViewById(R.id.videoView2);
            videoPlayer2.setVideoPath("http://video.ch9.ms/ch9/507d/71f4ef0f-3b81-4d2c-956f-c56c81f9507d/AndroidEmulatorWithMacEmulator.mp4");
            MediaController mediaController = new MediaController(this);
            videoPlayer2.setMediaController(mediaController);
            mediaController.setMediaPlayer(videoPlayer2);
            videoPlayer2.start();
        }
        catch(Exception ex)
        {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
}
