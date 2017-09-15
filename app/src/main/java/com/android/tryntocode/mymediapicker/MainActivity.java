package com.android.tryntocode.mymediapicker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private int REQUEST_CODE_SELECT_SONG = 100;
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
                Intent i = new Intent(this, MusicPickerActivity.class);
                startActivityForResult(i, REQUEST_CODE_SELECT_SONG);
                break;
            }
        }
    }
}
