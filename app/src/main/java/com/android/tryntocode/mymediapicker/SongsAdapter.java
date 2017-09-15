package com.android.tryntocode.mymediapicker;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

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
        holder.tvSongName.setText(this.songsList.get(position).get(SongsManager.SONG_TITLE));
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
        public ViewHolder(View itemView) {
            super(itemView);
            tvSongName = itemView.findViewById(R.id.tv_songName);
        }
    }

    // Interface contract for Song handlers.
    public interface SongHandler {
        public void songSelected(String path);
    }
}
