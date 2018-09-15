package com.example.nop_had.animalanatomyalpha;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class tela_resetpass extends AppCompatActivity {

    private EditText boxlogin;
    private Button btnalterar;
    private Button btncancel;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_resetpass);
        inicializarComponentes();
        click();
    }

    private void click() {
        btnalterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = boxlogin.getText().toString().trim();
                resetpass(email);
            }
        });
    }

    private void resetpass(String email) {
        firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener(tela_resetpass.this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(tela_resetpass.this, "Um e-mail foi encaminhado para a recuperação de sua senha", Toast.LENGTH_LONG).show();
                    finish();
                }
                else{
                    Toast.makeText(tela_resetpass.this, "O e-mail fornecido não foi encontrado", Toast.LENGTH_LONG).show();
                }
            }
        });
    }


    private void inicializarComponentes() {
        btnalterar = (Button) findViewById(R.id.btnalterar);
        boxlogin = (EditText) findViewById (R.id.boxlogin);
    }

    @Override
    protected void onStart(){
        super.onStart();
        firebaseAuth = ConfigFirebase.getFirebaseAuth();
    }

    private void btncancelActivity() {
        startActivity(new Intent(tela_resetpass.this, TelaLogin.class));
    }
}
