package com.mijuego;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.mijuego.ConexionFirebase.LoginFragment;
import com.mijuego.ConexionFirebase.RegisterFragment;
import com.mijuego.MiJuego;

public class AndroidLauncher extends AndroidApplication {

	LoginFragment loginFragment;
	RegisterFragment registerFragment;

	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//mostramos el login
		setContentView(R.layout.layout);



		//necesario
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();

		//aqui comienza el juego
		initialize(new MiJuego(), config);
	}
}
