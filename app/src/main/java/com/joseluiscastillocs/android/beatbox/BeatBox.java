package com.joseluiscastillocs.android.beatbox;

import android.content.Context;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by joseluiscastillo on 4/16/17.
 */
public class BeatBox {

    private static final String TAG = "BeatBox";

    private static final String SOUNDS_FOLDER = "sample_sounds";

    private static final int MAX_SOUNDS = 5;

    private SoundPool mSoundPool;

    /* Assets are accessed using the AssetManager class.
    * Since I can get an AssetManager from any Context, I use
    * a constructor that takes in a 'Context' as a dependency, pulls out
    * an AssetManager, and stashes it away. */
    private AssetManager mAssets;

    public BeatBox (Context context) {
        mAssets = context.getAssets();
        // This old constructor is deprecated, but we need it for compatibility
        mSoundPool = new SoundPool (MAX_SOUNDS, AudioManager.STREAM_MUSIC, 0);
        loadSounds();
    }

    // After setting up the Sound class, I build up a list of Sounds here
    private List<Sound> mSounds = new ArrayList<>();

    /* Method that looks in the assets with list(String) */
    private void loadSounds() {
        String[] soundNames;
        try {
            soundNames = mAssets.list(SOUNDS_FOLDER); //lists file names contained in the folder path
                                                      // passed in (the sample_sounds folder)
            Log.i(TAG, "Found " + soundNames.length + " sounds");
        } catch (IOException ioe) {
            Log.e(TAG, "Could not list assets", ioe);
            return;
        }

        // Create the list of sounds
        for (String filename : soundNames) {
            String assetPath = SOUNDS_FOLDER + "/" + filename;
            Sound sound = new Sound(assetPath);
            mSounds.add(sound);
        }
    }

    public List<Sound> getSounds() {
        return mSounds;
    }

}
