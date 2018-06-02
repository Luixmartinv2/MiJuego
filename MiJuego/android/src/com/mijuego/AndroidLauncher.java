package com.mijuego;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.mijuego.ConexionFirebase.LoginFragment;
import com.mijuego.MiJuego;

public class AndroidLauncher extends AndroidApplication {

	LoginFragment loginFragment;

	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		//setContentView(R.layout.layout);

		//necesario
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();

		//aqui comienza el juego
		initialize(new MiJuego(), config);
	}
}
