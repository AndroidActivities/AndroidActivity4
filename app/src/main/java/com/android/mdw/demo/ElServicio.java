package com.android.mdw.demo;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class ElServicio extends Service {

	private MediaPlayer player1;
	private MediaPlayer player2;

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void onCreate() {
		Toast.makeText(this, "Servicio Creado", Toast.LENGTH_LONG).show();
		player1 = MediaPlayer.create(this, R.raw.train);
		player2 = MediaPlayer.create(this, R.raw.bob_marley);
	}

	@Override
	public void onDestroy() {
		Toast.makeText(this, "Servicio Detenido", Toast.LENGTH_LONG).show();
		if (player1.isPlaying()) {
			player1.stop();
		}
		if (player2.isPlaying()) {
			player2.stop();
		}
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startid) {
		Toast.makeText(this, "Servicio Iniciado", Toast.LENGTH_LONG).show();
		String valor = intent.getStringExtra("sound");
		switch (valor) {
			case "train":
				Toast.makeText(this, "Iniciando Sonido", Toast.LENGTH_LONG).show();
				player1.setLooping(true);
				player1.start();
				break;
			case "music":
				Toast.makeText(this, "Iniciando Musica", Toast.LENGTH_LONG).show();
				player2.setLooping(true);
				player2.start();
				break;
		}
		return startid;
	}
}
