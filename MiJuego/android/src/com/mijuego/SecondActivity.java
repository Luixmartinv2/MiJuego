package com.mijuego;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.GenericTypeIndicator;
import com.mijuego.ConexionFirebase.DataHolder;
import com.mijuego.ConexionFirebase.FireBaseAdminListener;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    RecordFragment recordFragment;
    UsersAdapter usersAdapter;
    Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnStart = (Button) findViewById(R.id.btnStart);
        SecondActivityEvents events = new SecondActivityEvents(this);
        DataHolder.instance.fireBaseAdmin.setListener(events);

        recordFragment = (RecordFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentRecord);

        DataHolder.instance.fireBaseAdmin.descargarObservarRama("users");
    }



    public void iniciarJuego(View v) {
        //Tira error cuando se ejecuta el juego, por alguna razon el juego funciona si lo ejecutas libremente
        Intent intent = new Intent(this,AndroidLauncher.class);
        this.startActivity(intent);
        this.finish();
    }
}


class SecondActivityEvents implements FireBaseAdminListener {
    private SecondActivity secondActivity;

    public SecondActivityEvents(SecondActivity secondActivity) {
        this.secondActivity = secondActivity;
    }
    @Override
    public void fireBaseAdmin_RegisterOK(boolean blOK) {}
    @Override
    public void fireBaseAdmin_LoginOK(boolean blOK) {}

    @Override
    public void fireBaseAdmin_ramaDescargada(String rama, DataSnapshot dataSnapshot) {
        Log.v("rama","users-------->"+dataSnapshot);
        if(rama.equals("users")){
            GenericTypeIndicator<ArrayList<FBUsers>> indicator = new GenericTypeIndicator<ArrayList<FBUsers>>(){};
            ArrayList <FBUsers> users = dataSnapshot.getValue(indicator);
            Log.v("rama", "Users contiene: "+users);
            secondActivity.usersAdapter = new UsersAdapter(users, secondActivity);
            secondActivity.recordFragment.recyclerView.setAdapter(secondActivity.usersAdapter);
            secondActivity.usersAdapter.setListener((UsersAdapterListener) this);
        }

    }
}
