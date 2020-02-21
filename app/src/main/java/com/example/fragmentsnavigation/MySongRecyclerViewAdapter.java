package com.example.fragmentsnavigation;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fragmentsnavigation.SongFragment.OnListFragmentInteractionListener;
import com.example.fragmentsnavigation.dummy.DummyContent.DummySong;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummySong} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MySongRecyclerViewAdapter extends RecyclerView.Adapter<MySongRecyclerViewAdapter.ViewHolder> {

    private final List<DummySong> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MySongRecyclerViewAdapter(List<DummySong> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_song, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.title.setText(mValues.get(position).title);
        holder.artist.setText(mValues.get(position).artist);
        holder.album.setText(mValues.get(position).album);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView title;
        public final TextView artist;
        public final TextView album;
        public DummySong mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            title = view.findViewById(R.id.txtTitle);
            artist = view.findViewById(R.id.txtArtist);
            album = view.findViewById(R.id.txtAlbum);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + artist.getText() + "'";
        }
    }
}
