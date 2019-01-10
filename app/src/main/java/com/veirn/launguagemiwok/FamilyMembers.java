package com.veirn.launguagemiwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.veirn.launguagemiwok.R;
import com.veirn.launguagemiwok.word;

import java.util.ArrayList;

public class FamilyMembers extends AppCompatActivity {
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
        setContentView(R.layout.activity_family_members);
        final ArrayList<word> fm = new ArrayList<>();
        fm.add(new word("father", "әpә", R.drawable.family_father,R.raw.family_father));
        fm.add(new word("mother", "әṭa", R.drawable.family_mother,R.raw.family_mother));
        fm.add(new word("son", " angsi", R.drawable.family_son,R.raw.family_son));
        fm.add(new word("daughter", "tune", R.drawable.family_daughter,R.raw.family_daughter));
        fm.add(new word("older brother", "taachi", R.drawable.family_older_brother,R.raw.family_older_brother));
        fm.add(new word("younger brother", "chalitti", R.drawable.family_younger_brother,R.raw.family_younger_brother));
        fm.add(new word("older sister", "teṭe", R.drawable.family_older_sister,R.raw.family_older_sister));
        fm.add(new word(" younger sister", "kolliti", R.drawable.family_younger_sister,R.raw.family_younger_sister));
        fm.add(new word("grandmother", "ama", R.drawable.family_grandmother,R.raw.family_grandmother));
        fm.add(new word("grandfather", " paapa", R.drawable.family_grandfather,R.raw.family_grandfather));

        wa w = new wa(this,fm);
        ListView l = (ListView) findViewById(R.id.f);
        l.setAdapter(w);

        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the {@link Word} object at the given position the user clicked on
                releaseMediaPlayer();
                word word = fm.get(position);

                // Create and setup the {@link MediaPlayer} for the audio resource associated
                // with the current word
                mediaPlayer = MediaPlayer.create(FamilyMembers.this, word.getD());

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



