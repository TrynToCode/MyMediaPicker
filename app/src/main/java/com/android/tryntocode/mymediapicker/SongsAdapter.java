package com.android.tryntocode.mymediapicker;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by azeezolaniran on 15/09/2017.
 */

public class SongsAdapter extends RecyclerView.Adapter<SongsAdapter.ViewHolder> {
    private Context context;
    private SongHandler songHandler;
    private ArrayList<HashMap<String, String>> songsList;
    public SongsAdapter(Context ctx, SongHandler sH, ArrayList<HashMap<String, String>> list) {
        super();
        this.context = ctx;
        this.songHandler = sH;
        this.songsList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(this.context).inflate(R.layout.song_item, null);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.songPath = this.songsList.get(position).get(SongsManager.SONG_PATH);
        holder.tvSongName.setText(this.songsList.get(position).get(SongsManager.SONG_TITLE));
        holder.songId = this.songsList.get(position).get(SongsManager.SONG_ID);
    }

    @Override
    public int getItemCount() {
        if (this.songsList == null) {
            return 0;
        }
        return this.songsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvSongName;
        String songPath;
        String songId;
        public ViewHolder(View itemView) {
            super(itemView);
            tvSongName = itemView.findViewById(R.id.tv_songName);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    songHandler.songSelected(songsList.get(getAdapterPosition()).get(SongsManager.SONG_PATH));
                }
            });
        }
    }

    // Interface contract for Song handlers.
    public interface SongHandler {
        void songSelected(String path);
    }
}
