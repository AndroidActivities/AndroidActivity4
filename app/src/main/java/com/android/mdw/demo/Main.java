package com.android.mdw.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
//import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
//import android.widget.Toast;

//import java.net.URI;

//import javax.xml.transform.URIResolver;

public class Main extends Activity implements OnClickListener {

    private final static String SOUND = "sound";
    private final static String TRAIN = "train";
    private final static String MUSIC = "music";
    private final static String RUN = "run";
    private final static String STATE = "state";
    private final static String STOP = "stop";
    private final static int CODIGO_MUSIC = 2;

    private Intent intent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button btnFin = (Button) findViewById(R.id.btnFin);
        Button btnMusic = (Button) findViewById(R.id.btnMusic);
        Button btnTrain = (Button) findViewById(R.id.btnTrain);
        Button btnFinB = (Button) findViewById(R.id.btnFinB);
        Button btnMusicB = (Button) findViewById(R.id.btnMusicB);
        Button btnTrainB = (Button) findViewById(R.id.btnTrainB);
        //Button btnBiblioteca = (Button) findViewById(R.id.btnBiblioteca);
        //Button btnUri = (Button) findViewById(R.id.btnUri);

        btnFin.setOnClickListener(this);
        btnMusic.setOnClickListener(this);
        btnTrain.setOnClickListener(this);
        btnFinB.setOnClickListener(this);
        btnMusicB.setOnClickListener(this);
        btnTrainB.setOnClickListener(this);
        //btnBiblioteca.setOnClickListener(this);
        //btnUri.setOnClickListener(this);
    }

    public void onClick(View src) {
        switch (src.getId()) {
            case R.id.btnMusic:
                intent = new Intent(this, ElServicio.class);
                intent.putExtra(SOUND, MUSIC);
                startService(intent);
                break;
            case R.id.btnTrain:
                intent = new Intent(this, ElServicio.class);
                intent.putExtra(SOUND, TRAIN);
                startService(intent);
                break;
            case R.id.btnFin:
                stopService(new Intent(this, ElServicio.class));
                break;
            case R.id.btnMusicB:
                intent = new Intent(this, ElBroadcast.class);
                intent.putExtra(STATE, RUN);
                intent.putExtra(SOUND, MUSIC);
                sendBroadcast(intent);
                break;
            case R.id.btnTrainB:
                intent = new Intent(this, ElBroadcast.class);
                intent.putExtra(STATE, RUN);
                intent.putExtra(SOUND, TRAIN);
                sendBroadcast(intent);
                break;
            case R.id.btnFinB:
                intent = new Intent(this, ElBroadcast.class);
                intent.putExtra(STATE, STOP);
                sendBroadcast(intent);
                break;
            /*
            case R.id.btnBiblioteca:
                intent = new Intent(Intent.ACTION_GET_CONTENT,
                        MediaStore.Audio.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, CODIGO_MUSIC);*/
        }
    }

    /*protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CODIGO_MUSIC && resultCode == RESULT_OK && null != data) {
            if (intent.hasExtra()) {

            }
            Toast.makeText(this, "BLABLABLABLA", Toast.LENGTH_LONG).show();
        }
    }*/
}