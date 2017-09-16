package com.android.tryntocode.mymediapicker;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by azeezolaniran on 14/09/2017.
 */

public class SongsManager {
    public static final String SONG_TITLE = "SONG_TITLE";
    public static final String SONG_PATH = "SONG_PATH";
    public static final String SONG_ID = "SONG_ID";

    // Constructor
    public SongsManager(){

    }

    /**
     * Function to read all mp3 files from sdcard
     * and store the details in ArrayList
     * */
    public static ArrayList<HashMap<String, String>> getPlayList(Context ctx){
        ContentResolver contentResolver = ctx.getContentResolver();
        Uri songUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        Cursor songCursor = contentResolver.query(songUri, null, null, null, null);
        ArrayList<HashMap<String, String>> songsList = new ArrayList<>();

        if (songCursor != null && songCursor.moveToFirst()) {
            while(songCursor.moveToNext()) {
                int songId = songCursor.getColumnIndex(MediaStore.Audio.Media._ID);
                int songTitle = songCursor.getColumnIndex(MediaStore.Audio.Media.TITLE);
                int data = songCursor.getColumnIndex(MediaStore.Audio.Media.DATA);
                HashMap<String, String> song = new HashMap<String, String>();
                song.put(SONG_TITLE, songCursor.getString(songTitle));
                song.put(SONG_PATH, songCursor.getString(data));
                song.put(SONG_ID, songCursor.getString(songId));

                // Adding each song to SongList
                songsList.add(song);
            }
        }
        return songsList;
    }
}
