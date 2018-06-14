package com.mijuego.ConexionFirebase;



/**
 * Created by luixmartinv2 on 6/6/18.
 */

public class DataHolder {
    public static DataHolder instance = new DataHolder();

    public FireBaseAdmin fireBaseAdmin;

    //Cuando arranca el DataHolder inicializa el fire base admin.
    public DataHolder() {
        fireBaseAdmin = new FireBaseAdmin();
    }

}