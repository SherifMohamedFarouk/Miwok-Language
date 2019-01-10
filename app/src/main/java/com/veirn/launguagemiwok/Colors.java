package com.veirn.launguagemiwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Colors extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);
        final ArrayList<word> num = new ArrayList<>();

        word w = new word("red", "weṭeṭṭi", R.drawable.color_red, R.raw.color_red);
        word w1 = new word("green", "chokokki", R.drawable.color_green, R.raw.color_green);
        word w2 = new word("brown", "ṭakaakki", R.drawable.color_brown, R.raw.color_brown);
        word w3 = new word("gray", "ṭopoppi", R.drawable.color_gray, R.raw.color_gray);
        word w4 = new word("black", "kululli", R.drawable.color_black, R.raw.color_black);
        word w5 = new word("white", "kelelli", R.drawable.color_white, R.raw.color_white);

        num.add(w);
        num.add(w1);
        num.add(w2);
        num.add(w3);
        num.add(w4);
        num.add(w5);


        wa adapter = new wa(this, num);

        ListView l = (ListView) findViewById(R.id.CO);
        l.setAdapter(adapter);
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the {@link Word} object at the given position the user clicked on
                releaseMediaPlayer();
                word word = num.get(position);

                // Create and setup the {@link MediaPlayer} for the audio resource associated
                // with the current word
                mediaPlayer = MediaPlayer.create(Colors.this, word.getD());

                // Start the audio file
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });

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
