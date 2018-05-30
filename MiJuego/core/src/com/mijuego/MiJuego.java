package com.mijuego;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MiJuego extends ApplicationAdapter {
	//sirve para dibujar todas las texturas a
	SpriteBatch batch;
	Texture img;
	private int width, height;
	private int widthP, heightP;

	//constructor de libgdx
	@Override
	public void create () {

		//llamamos a la img que necesitamos
		img = new Texture("pelota.jpg");
		batch = new SpriteBatch();
		//ancho de la pantalla. X
		width = Gdx.graphics.getBackBufferWidth();
		//alto de la pantalla. Y
		height = Gdx.graphics.getBackBufferHeight();

		//ancho de la img X
		widthP = img.getWidth();
		//alto de la img Y
		heightP = img.getHeight();
	}
	//aqui se procesan las imagenes
	@Override
	public void render () {
		//
		if(Gdx.input.justTouched()){
		System.out.println("toque");
		}


		//cuando limpia deja el color que se especifique 0/1
		Gdx.gl.glClearColor(1, 0, 0, 1);
		//limpia la pantalla sino surgen problemas
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//llamamos a las imagenes
		batch.begin();
		//dibuja la img en medio y del tamaño especificado
		batch.draw(img, width/2, height/2,100,100);
		//usa lo declarado con anterioridad
		batch.end();
	}
	//esto sirve para liberar los recursos que hemos utilizado
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
