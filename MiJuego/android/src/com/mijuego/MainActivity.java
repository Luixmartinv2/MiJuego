package com.mijuego;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.mijuego.ConexionFirebase.DataHolder;
import com.mijuego.ConexionFirebase.FireBaseAdminListener;
import com.mijuego.ConexionFirebase.LoginFragmentListener;
import com.mijuego.ConexionFirebase.RegisterFragmentListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //pasamos el layout de login y comenzamos
        setContentView(R.layout.activity_main);


        DataHolder.instance.fireBaseAdmin = new DataHolder.FireBaseAdmin();
//Creamos objeto y le pasamos la referencia
        MainActivityEvents events = new MainActivityEvents(this);
        DataHolder.instance.fireBaseAdmin.setListener(events);
//Esto te logea en firebase con ese usuario y pass
        DataHolder.instance.fireBaseAdmin.loginWithUserNPass("tester@tester.com", "tester", this);

    }
}

class MainActivityEvents implements LoginFragmentListener, RegisterFragmentListener, FireBaseAdminListener {
    private MainActivity mainActivity;

    public MainActivityEvents(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }


    //Metodos del LoginFragmentListener

    /*
    * Cuando pulso el botón de registrarse se llama al loginWithUserNPass que es un método del
     * fireBaseAdmin encargado de logear a un usuario que ya está registrado y en caso de que
     * todosalga bien se almacena en la variable user el usuario que se ha logeado.
     * Una vez hecho esto, dentro del loginWithUserNPass se llama a otro método fireBaseAdmin_LoginOK
     * en el que se cambia de activity si el login se ha realizado correctamente*/
    @Override
    public void LoginFragmentLoginButtonClicked(String sUser, String sPass) {
        DataHolder.instance.fireBaseAdmin.loginWithUserNPass(sUser, sPass, mainActivity);


    }
    /*Este método ocurre cuando se pulsa el botón de registrarse y lo que sucede es que se
    * oculta el fragmento del login para mostrarse el de registro y proceder a registrarse.*/
    @Override
    public void LoginFragmentRegisterButtonClicked(String sUser, String sPass) {

        FragmentTransaction transaction = mainActivity.getSupportFragmentManager().beginTransaction();
        transaction.hide(mainActivity.loginFragment);
        transaction.show(mainActivity.registerFragment);
        transaction.commit();
    }

    //Métodos del RegisterFragmentListener
    /*Este método se ejecuta cuando se pulsa el botón de Volver en el fragment de registro por lo que
    * se oculta el fragment de registro y se muestra el de login*/
    @Override
    public void RegisterFragmentBackButtonClicked() {
        FragmentTransaction transaction = mainActivity.getSupportFragmentManager().beginTransaction();
        transaction.show(mainActivity.loginFragment);
        transaction.hide(mainActivity.registerFragment);
        transaction.commit();
    }
    /*Este método se ejecuta cuando se pulsa el botón de Registrar en el fragment de registro de tal manera
    * que al pulsar se debe registrar un nuevo usuario llamando al método del fireBaseAdmin y después
    * una vez registrado se pasa al segundoActivity*/
    @Override
    public void RegisterFragmentOKButtonClicked(String sUser, String sPass) {
        DataHolder.instance.fireBaseAdmin.registerWithUserNPass(sUser, sPass, mainActivity);
    }

    //Métodos del FireBaseAdminListener que me dicen si el registro fue OK o NO
    @Override
    public void fireBaseAdmin_RegisterOK(boolean blOK) {
        Log.v("MAINACTIVITYEVENTS: ", "RESULTADO DE REGISTER:" + blOK);
        if(blOK){
            //Se crea un objeto intent indicamos el activity de origen y el de destino
            Intent intent = new Intent(mainActivity,SecondActivity.class);
            //Iniciamos el segundoactivity desde el primero
            mainActivity.startActivity(intent);
            //Matamos al primer activity
            mainActivity.finish();
        }
    }


    //Metodos del FireBaseAdminListener que indican si el login fue OK o NO
    @Override
    public void fireBaseAdmin_LoginOK(boolean blOK) {
        Log.v("MAINACTIVITYEVENTS: ","RESULTADO DE LOGIN:"+blOK);
        if(blOK){
            Intent intent = new Intent(mainActivity,SecondActivity.class);
            mainActivity.startActivity(intent);
            mainActivity.finish();
        }else{
            Toast.makeText(mainActivity, "Ha fallado el login", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void fireBaseAdmin_ramaDescargada(String rama, DataSnapshot dataSnapshot) {

    }
}