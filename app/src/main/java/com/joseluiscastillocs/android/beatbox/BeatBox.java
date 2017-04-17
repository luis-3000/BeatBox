package com.joseluiscastillocs.android.beatbox;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.IOException;

/**
 * Created by joseluiscastillo on 4/16/17.
 */
public class BeatBox {

    private static final String TAG = "BeatBox";

    private static final String SOUNDS_FOLDER = "sample_sounds";

    /* Assets are accessed using the AssetManager class.
    * Since I can get an AssetManager from any Context, I use
    * a constructor that takes in a 'Context' as a dependency, pulls out
    * an AssetManager, and stashes it away. */
    private AssetManager mAssets;

    public BeatBox (Context context) {
        mAssets = context.getAssets();
        loadSounds();
    }

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
    }

}
