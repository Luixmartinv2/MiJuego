# Trabajo MiJuego
(Proyecto anterior (https://github.com/Luixmartinv2/Trabajo-TPJ.git) fallido,11 commits)

#Coomit 2
Comenzamos con la configuracion de firebase.

1. Agregamos proyecto con el nombre de "MiJuego"
2. Seleccionamos agregar APP android
3. ponemos el id de la APP "com.mijuego"
4. ponemos sobrenombre "TPJ"
5. ponemos firma SHA-1 "C8:15:46:05:B1:BB:25:66:8C:C6:ED:56:39:AE:B9:96:7F:DA:F4:97"
6. nos pide agregar "google-services.json", lo bajamos y agregamos.
7. nos pide modificar gradle, ya modificado.
8. comprobamos que se conecta, y esperamos a que firebase nos de confirmacion.
9. nos aparece el mensaje "¡Felicitaciones! Agregaste Firebase a tu app correctamente."

#Commit 13

Creamos un documento ".json", para la gestion de informacion de la app.
le damos el nombre de "MiJuego.json" y lo rellenamos:
{
  "users": {
    "user": {
      "name": "Luis",
      "record": 1000,
      "mail": "luixmartinv2@gmail.com"
    }
  }
}
