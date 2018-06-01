package com.mijuego;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//Game es como el InputAdapter pero te permite empezar en otra pantalla.
public class MiJuego extends Game {
	//sirve para dibujar todas las texturas a
	SpriteBatch batch;
	Texture img;
	public int width, height, z, v=0;
	private int widthP, heightP;


	//constructor de libgdx
	@Override
	public void create () {
		//declaramos MainGameScreen
		setScreen(new MainGameScreen(this,z));

		//ELIMINAMOS LA CLASE PROCESADOR
		/*
		el procesador es muy potente, pero es para cosas mas complejas.
		 */
		//declaramos el procesador.
		/*Procesador P = new Procesador();
		Gdx.input.setInputProcessor(P);*/

		//llamamos a la img que necesitamos
		//img = new Texture("pelota.jpg");
		batch = new SpriteBatch();
		/*Cambio de sitio.
		//ancho de la pantalla. X
		width = Gdx.graphics.getBackBufferWidth();
		//alto de la pantalla. Y
		height = Gdx.graphics.getBackBufferHeight();
		*/
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

		if(z==1){
			//cuando limpia deja el color que se especifique 0/1
			Gdx.gl.glClearColor(1, 0, 0, 1);
		} else if(z==2){
			//cuando limpia deja el color que se especifique 0/1
			Gdx.gl.glClearColor(0, 1, 0, 1);
		} else if(z==3){
			//cuando limpia deja el color que se especifique 0/1
			Gdx.gl.glClearColor(0, 0, 1, 1);
		} else if(z<11){
			float F=(z/10);
			//cuando limpia deja el color que se especifique 0/1
			Gdx.gl.glClearColor(F, F, F, 1);
		}else{
			int auxC = 0;
			for (int i = z; i >11; i--) {
				v++;
				auxC=z;
			}
			float f1=(auxC/(10-z)),f2=(auxC/(10-z)),f3=(auxC/(10-z));

			//cuando limpia deja el color que se especifique 0/1
			Gdx.gl.glClearColor(f1, f2, f3, 1);
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
