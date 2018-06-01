package com.mijuego;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mijuego.actors.ActorPelota;

/**
 * Created by luixmartinv2 on 30/5/18.
 */

public class MainGameScreen extends BaseScreen {

    public MainGameScreen(MiJuego J) {
        super(J);
        Texture TexPelota = new Texture("pelota.png");
    }

    private ActorPelota P;
    private Stage stage;
    private int v=0,x=1,z, g=0,aux1=0,aux2=0;

    @Override
    public void show() {
        stage = new Stage();
        P = new ActorPelota();
        //aqui metemos a los actores dentro del stage para el limpiado
        stage.addActor(P);


        //ancho de la pantalla. X
        int width = Gdx.graphics.getBackBufferWidth();
        //alto de la pantalla. Y
        int height = Gdx.graphics.getBackBufferHeight();

        //dejamos de base la grabedad
        aux1=(width );aux2=(height);
        if (v<1){
            //if(v>)
            P.setPosition(aux1/ 2, aux2/ 2);
        } else if (width==0){
            //aqui fin de juego
        } else if (v>0){
            P.setPosition(aux1-x, aux2);
        }




    }

    @Override
    public void hide() {
        stage.dispose();


    }

    @Override
    public void render(float delta) {
        //aqui hacemos que suba un poco cada vez que tocamos por encima de la pelota
        if(Gdx.input.justTouched()){
            System.out.println("toque");
            Gdx.input.isTouched(z);
            if(z>aux1){
                aux1++;
            }
        }
        Gdx.gl.glClearColor(0.4f,0.5f,0.8f,1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }
}
