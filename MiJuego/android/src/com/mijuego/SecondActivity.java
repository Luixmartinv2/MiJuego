package com.mijuego;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.GenericTypeIndicator;
import com.mijuego.ConexionFirebase.DataHolder;
import com.mijuego.ConexionFirebase.FireBaseAdminListener;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    RecordFragment recordFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        SecondActivityEvents events = new SecondActivityEvents(this);
        DataHolder.instance.fireBaseAdmin.setListener(events);

        recordFragment = (RecordFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentRecord);

        DataHolder.instance.fireBaseAdmin.descargarObservarRama("users");
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
            //secondActivity.listaCochesAdapter = new ListaCochesAdapter(coches, secondActivity);
            //secondActivity.listaFragmentCoches.recyclerView.setAdapter(secondActivity.listaCochesAdapter);
            //secondActivity.listaCochesAdapter.setListener(this);
        }

    }
}
