package com.veirn.launguagemiwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Number extends AppCompatActivity {
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
        setContentView(R.layout.activity_number);
        final ArrayList<word> num = new ArrayList<>();
        word w = new word("one", "Lutti", R.drawable.number_one, R.raw.number_one);
        word w1 = new word("two", "otikko", R.drawable.number_two, R.raw.number_two);
        word w2 = new word("three", "tolookosu", R.drawable.number_three, R.raw.number_three);
        word w3 = new word("four", "oyyisa", R.drawable.number_four, R.raw.number_four);
        word w4 = new word("five", "mssokka", R.drawable.number_five, R.raw.number_five);
        word w5 = new word("six", "temmokka", R.drawable.number_six, R.raw.number_six);
        word w6 = new word("seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven);
        word w7 = new word("eight", "kawinta", R.drawable.number_eight, R.raw.number_eight);
        word w8 = new word("nine", "wo,e", R.drawable.number_nine, R.raw.number_nine);
        word w9 = new word("ten", "na,aacha", R.drawable.number_ten, R.raw.number_ten);

        num.add(w);
        num.add(w1);
        num.add(w2);
        num.add(w3);
        num.add(w4);
        num.add(w5);
        num.add(w6);
        num.add(w7);
        num.add(w8);
        num.add(w9);


        wa adapter = new wa(this, num);

        ListView l = (ListView) findViewById(R.id.r);
        l.setAdapter(adapter);

        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the {@link Word} object at the given position the user clicked on
                releaseMediaPlayer();
                word word = num.get(position);

                // Create and setup the {@link MediaPlayer} for the audio resource associated
                // with the current word
                mediaPlayer = MediaPlayer.create(Number.this, word.getD());

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


