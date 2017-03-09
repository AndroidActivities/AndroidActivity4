package com.android.mdw.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Main extends Activity implements OnClickListener {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button btnFin = (Button) findViewById(R.id.btnFin);
        Button btnMusic = (Button) findViewById(R.id.btnMusic);
        Button btnTrain = (Button) findViewById(R.id.btnTrain);

        btnFin.setOnClickListener(this);
        btnMusic.setOnClickListener(this);
        btnTrain.setOnClickListener(this);
    }

    public void onClick(View src) {
        switch (src.getId()) {
            case R.id.btnMusic:

                break;
            case R.id.btnTrain:

                break;
            case R.id.btnFin:
                stopService(new Intent(this, ElServicio.class));
                break;

        }
    }
}