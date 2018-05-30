package com.mijuego;

import com.badlogic.gdx.InputProcessor;

/**
 * Created by luixmartinv2 on 30/5/18.
 */
//implementamos la interfaz InputProcessor de libgdx para gestionar cosas aparte.
public class Procesador implements InputProcessor {
    //cosas que se hacen cuando tocas la pantalla.
    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    //cosas que se hacen cuando no tocas la pantalla.
    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
