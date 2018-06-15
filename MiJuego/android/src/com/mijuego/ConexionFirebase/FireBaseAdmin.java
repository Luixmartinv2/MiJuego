package com.mijuego.ConexionFirebase;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static android.content.ContentValues.TAG;

/*
*Se crea FireBaseAdmin en el proyecto y no en la librería porque FireBaseAdmin solo permite
* conectarse en el módulo donde está añadido. Por ello debemos crearlo aquí. Sin embargo, podemos
* crear la clase en la librería para copiar y pegar.
*/
public class FireBaseAdmin {
    //Se encarga de gestionar las autentificaciones
    private FirebaseAuth mAuth;
    /*Listener de cuando recibe un evento del mAuth se usa
     *sobretodo cuando detecta que ya está2 logueado
     */
    private FirebaseAuth.AuthStateListener mAuthListener;
    //Creamos nuestro propio listener
    public FireBaseAdminListener listener;
    //Variable user
    public FirebaseUser user;
    FirebaseDatabase database;
    DatabaseReference myRefRaiz;

    public FireBaseAdmin(){
        this.mAuth = FirebaseAuth.getInstance();
        this.database = FirebaseDatabase.getInstance();
        this.myRefRaiz = database.getReference();
    }

    public void setListener(FireBaseAdminListener listener){
        this.listener = listener;
    }

    public void registerWithUserNPass(String email, String pass, Activity activity){
        mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                Log.d("FireBaseAdmin", "createUserWithEmail:onComplete:" + task.isSuccessful());

                if (task.isSuccessful()) {
                    //Me devuelve el usuario que se acaba de registrar
                    user = FirebaseAuth.getInstance().getCurrentUser();
                    listener.fireBaseAdmin_RegisterOK( true);
                }else{
                    listener.fireBaseAdmin_RegisterOK(false);
                }
            }
        });
    }

    public void loginWithUserNPass(String email, String pass, Activity activity){
        mAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                Log.d("FireBaseAdmin", "loginWithUser:onComplete:" + task.isSuccessful());

                if (task.isSuccessful()) {
                    //Me devuelve el usuario que se acaba de registrar
                    user = FirebaseAuth.getInstance().getCurrentUser();
                    listener.fireBaseAdmin_LoginOK(true);
                }else{
                    listener.fireBaseAdmin_LoginOK(false);
                }
            }
        });
    }

    public void descargarObservarRama(final String rama){
        //Le pasamos la ruta de la rama que quiero leer
        DatabaseReference refRama = myRefRaiz.child(rama);

        // Read from the database
        refRama.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                //String value = dataSnapshot.getValue(String.class);
                //Log.d(TAG, "Value is: " + value);
                listener.fireBaseAdmin_ramaDescargada(rama, dataSnapshot);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                listener.fireBaseAdmin_ramaDescargada(rama, null);
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

    }
}
