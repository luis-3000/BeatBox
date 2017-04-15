package com.joseluiscastillocs.android.beatbox;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by joseluiscastillo on 4/14/17.
 */

public class BeatBoxFragment extends Fragment {

    public static BeatBoxFragment newInstance() {
        return new BeatBoxFragment();
    }

    @Override
    public View onCreate (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_beat_box, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.fragment_beat_box_recycler_view);

        /* This LayoutManager lays out items on a grid, so that there are multiple items on each line.
        *  3 columns are indicated as the desired number of columns. */
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));

        return view;
    }

    /* Creating a ViewHolder wired up to list_item_sound.xml */
    private class SoundHolder extends RecyclerView.ViewHolder {

        private Button mButton;

        public SoundHolder (LayoutInflater inflater, ViewGroup container) {
            super(inflater.inflate (R.layout.list_item_sound, container, false));

            mButton = (Button) itemView.findViewById(R.id.list_item_sound_button);
        }
    }

    /* Next, I create an adpater hooked up to SoundHolder */
    private class SoundAdapter extends RecyclerView.Adapter<SoundHolder> {

        @Override
        public SoundHolder oncreateViewHolder (ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());

            return new SoundHolder(inflater, parent);
        }

        @Override
        public void onBindViewHolder (SoundHolder soundHolder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }
    }
}
