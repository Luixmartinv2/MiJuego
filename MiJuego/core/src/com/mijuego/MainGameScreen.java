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

    @Override
    public void show() {
        stage = new Stage();
        P = new ActorPelota();
        stage.addActor(P);

        //ancho de la pantalla. X
        int width = Gdx.graphics.getBackBufferWidth();
        //alto de la pantalla. Y
        int height = Gdx.graphics.getBackBufferHeight();
        P.setPosition(width/2,height/2);

    }

    @Override
    public void hide() {
        stage.dispose();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.4f,0.5f,0.8f,1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }
}
