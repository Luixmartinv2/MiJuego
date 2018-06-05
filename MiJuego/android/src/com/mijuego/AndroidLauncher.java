package com.mijuego;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;


public class AndroidLauncher extends AndroidApplication {



	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);




		//necesario
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();

		//aqui comienza el juego
		initialize(new MiJuego(), config);
	}
}
