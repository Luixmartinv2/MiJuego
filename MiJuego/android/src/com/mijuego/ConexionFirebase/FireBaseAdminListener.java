package com.mijuego.ConexionFirebase;

import com.google.firebase.database.DataSnapshot;

/**
 * Created by luixmartinv2 on 6/6/18.
 */

    /*  FireBaseAdmin va a ejecutar métodos que van a requerir que mande algún evento a otras clases que
 * ha pasado algo. Por eso creamos FireBaseAdminListener.
            */


    public interface FireBaseAdminListener {
        public void fireBaseAdmin_RegisterOK(boolean blOK);
        public void fireBaseAdmin_LoginOK(boolean blOK);
        public void fireBaseAdmin_ramaDescargada(String rama, DataSnapshot dataSnapshot);
    }
