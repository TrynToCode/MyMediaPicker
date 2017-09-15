package com.android.tryntocode.mymediapicker;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by azeezolaniran on 14/09/2017.
 */

public class SongsManager {
    // SDCard Path
    public static final String DEFAULT_MEDIA_PATH = new String("/sdcard/");
    public static final String SONG_TITLE = "SONG_TITLE";
    public static final String SONG_PATH = "SONG_PATH";

    // Constructor
    public SongsManager(){

    }

    /**
     * Function to read all mp3 files from sdcard
     * and store the details in ArrayList
     * */
    public static ArrayList<HashMap<String, String>> getPlayList(String mediaPath){
        File home = new File(mediaPath);
        ArrayList<HashMap<String, String>> songsList = new ArrayList<>();

        if (home.listFiles(new FileExtensionFilter()).length > 0) {
            for (File file : home.listFiles(new FileExtensionFilter())) {
                HashMap<String, String> song = new HashMap<String, String>();
                song.put(SONG_TITLE, file.getName().substring(0, (file.getName().length() - 4)));
                song.put(SONG_PATH, file.getPath());

                // Adding each song to SongList
                songsList.add(song);
            }
        }
        // return songs list array
        return songsList;
    }

    /**
     * Class to filter files which are having .mp3 extension
     * */
    static class FileExtensionFilter implements FilenameFilter {
        public boolean accept(File dir, String name) {
            return (name.endsWith(".mp3") || name.endsWith(".MP3"));
        }
    }
}
