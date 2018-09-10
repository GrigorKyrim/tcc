package com.example.nop_had.animalanatomyalpha;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ConfigFirebase {

    private static DatabaseReference referencefirebase;
    private static FirebaseAuth firebaseAuth;

    public static DatabaseReference getFirebase(){
        if (referencefirebase == null){

            referencefirebase = FirebaseDatabase.getInstance().getReference();
        }
        return referencefirebase;
    }

    public static FirebaseAuth getFirebaseAutenticacao(){
        if (firebaseAuth == null){
            firebaseAuth = FirebaseAuth.getInstance();
        }
        return firebaseAuth;
    }

}
