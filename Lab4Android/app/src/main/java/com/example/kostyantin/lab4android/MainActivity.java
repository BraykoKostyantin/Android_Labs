package com.example.kostyantin.lab4android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;


public class MainActivity extends AppCompatActivity
{
    VideoView videoPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void StartVideo(View view)
    {
        Intent obj1 = new Intent(this, VideoActivity.class);
        startActivity(obj1);
    }

    public void StartAudio(View view)
    {
        Intent obj2 = new Intent(this, AudioActivity.class);
        startActivity(obj2);
    }

    public void VideoFromInternet(View view)
    {
        Intent obj3 = new Intent(this, InternetActivity.class);
        startActivity(obj3);
    }

}
