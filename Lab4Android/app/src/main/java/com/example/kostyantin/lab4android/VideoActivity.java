package com.example.kostyantin.lab4android;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity
{

    VideoView videoPlayer;
    private Button b1;
    private Button b2;
    private Button b3;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        this.b1=(Button) this.findViewById(R.id.button_start2);
        this.b2=(Button) this.findViewById(R.id.button_pause2);
        this.b3=(Button) this.findViewById(R.id.button_stop2);

        videoPlayer =  (VideoView)findViewById(R.id.videoView);
        Uri myVideoUri= Uri.parse( "android.resource://" + getPackageName() + "/" + R.raw.video);
        videoPlayer.setVideoURI(myVideoUri);
        videoPlayer.start();
        b1.setEnabled(false);
    }


    public void play(View view)
    {
        videoPlayer.start();
        b1.setEnabled(false);
        b2.setEnabled(true);
        b3.setEnabled(true);
    }
    public void pause(View view)
    {
        videoPlayer.pause();
        b1.setEnabled(true);
        b2.setEnabled(false);
        b3.setEnabled(false);
    }
    public void stop(View view)
    {
        videoPlayer.stopPlayback();
        videoPlayer.resume();
        b1.setEnabled(true);
        b2.setEnabled(false);
        b3.setEnabled(false);
    }
}
