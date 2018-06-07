package com.mijuego.ConexionFirebase;

/**
 * Created by luixmartinv2 on 23/5/18.
 */

public interface LoginFragmentListener {
    public void LoginFragmentLoginButtonClicked(String sUser, String sPass);
    public void LoginFragmentRegisterButtonClicked(String sUser, String sPass);
}
