package com.android.tryntocode.mymediapicker;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MusicPickerActivity extends AppCompatActivity implements SongsAdapter.SongHandler {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_picker);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView = (RecyclerView)findViewById(R.id.rv_songs);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new SongsAdapter(this, this, null));
    }

    @Override
    public void songSelected(String path) {
        Toast.makeText(this, "Song selected -> " + path, Toast.LENGTH_SHORT).show();
        Log.d(this.getClass().getSimpleName(), "Song Selected -> " + path);
    }
}
