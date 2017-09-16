package com.android.tryntocode.mymediapicker;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private int REQUEST_CODE_SELECT_SONG = 100;
    private static final int REQUEST_READ_STORAGE = 112;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_select_song).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            default: {
                break;
            }
            case R.id.btn_select_song: {
                checkAndRequestPermission();
                break;
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_SELECT_SONG && resultCode == RESULT_OK && data != null) {
            // You can do whatever you want with the selected song path now...
            Toast.makeText(this, "Selecte Song Path -> " + data.getStringExtra(SongsManager.SONG_PATH), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode)
        {
            case REQUEST_READ_STORAGE: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    checkAndRequestPermission();
                } else
                {
                    Toast.makeText(MainActivity.this, "The app was not allowed to read from your storage. Hence, it cannot function properly. Please consider granting it this permission", Toast.LENGTH_LONG).show();
                }
            }
        }

    }



    private void checkAndRequestPermission() {
        boolean hasPermission = (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED);
        if (!hasPermission) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    REQUEST_READ_STORAGE);
        } else {
            startMusicSelector();
        }
    }

    private void startMusicSelector() {
        Intent i = new Intent(this, MusicPickerActivity.class);
        startActivityForResult(i, REQUEST_CODE_SELECT_SONG);
    }
}
