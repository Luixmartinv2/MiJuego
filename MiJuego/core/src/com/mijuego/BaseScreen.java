package com.mijuego;

import com.badlogic.gdx.Screen;

/**
 * Created by luixmartinv2 on 30/5/18.
 */
//lo ponemos abstract para poder gestionar todas las pantallas.
public abstract class BaseScreen implements Screen {
    private MiJuego J= new MiJuego();

    //creamos constructor para declarar el main
    public BaseScreen(MiJuego J){
        this.J=J;
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
