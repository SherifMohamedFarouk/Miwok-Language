package com.veirn.launguagemiwok;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    ToggleButton b;
    int length;
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override

        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.pause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mediaPlayer.pause();
        length=mediaPlayer.getCurrentPosition();



    }

    @Override
    protected void onResume() {
        super.onResume();

            b = (ToggleButton) findViewById(R.id.b);
            b.setChecked(false);

            b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        mediaPlayer.seekTo(length);
                        mediaPlayer.start();

                    } else {
                        mediaPlayer.pause();
                        length=mediaPlayer.getCurrentPosition();
                    }
                }
            });

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView t = (TextView)  findViewById(R.id.numbers);
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Number.class);
                startActivity(i);

            }
        });
        mediaPlayer = MediaPlayer.create(this,R.raw.song);


         b = (ToggleButton) findViewById(R.id.b);
        b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(mCompletionListener);


                } else {
                    mediaPlayer.pause();
                }
            }
        });


    }

    public void fm(View view){
        Intent intent = new Intent(MainActivity.this , FamilyMembers.class);
        startActivity(intent);

    }
    public void Co(View view){
        Intent intent = new Intent(MainActivity.this , Colors.class);
        startActivity(intent);

    }

    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;
        }
    }

}
