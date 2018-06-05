package com.mijuego;

/**
 * Created by luixmartinv2 on 5/6/18.
 */

public class Fin {
    public int Puntuacion = 0;

    public void Record(int puntos){
        // agregamos los puntos a la puntuacion
        Puntuacion +=puntos;
    }

    public int fin(){
        //usamos para redirigir la puntuacion
        return Puntuacion;
    }
}
