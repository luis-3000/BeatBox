package com.joseluiscastillocs.android.beatbox;

/**
 * Created by joseluiscastillo on 4/17/17.
 *
 * After setting up the asset filenames, they need to be presented to the use.
 * They will need to be played, so it makes sense to have an object responsible
 * for keeping track of the filename, the name the user should see, and any other
 * information related to that sound.
 *
 * For all that to happen, I have created this class, Sound
 */

public class Sound {
    private String mAssetPath;
    private String mName;
    //Now, to load sounds into SoundPool a Integer ID for each sound is needed
    private Integer mSoundId;

    public Sound (String assetPath) {
        mAssetPath = assetPath;
        // Doing a little work to make a presentable name for a sound
        String[] components = assetPath.split("/"); // split off the name
        String filename = components[components.length - 1];
        mName = filename.replace(".wav", ""); // strip off the file extension too
    }

    public String getAssetPath() {
        return mAssetPath;
    }

    public String getName() {
        return mName;
    }


    public Integer getmSoundId() {
        return mSoundId;
    }

    public void setSoundId(Integer soundId) {
        this.mSoundId = soundId;
    }

}
