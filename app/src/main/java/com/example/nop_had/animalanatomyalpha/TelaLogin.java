package com.example.nop_had.animalanatomyalpha;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class TelaLogin extends AppCompatActivity {

    private Button btnCadastro;
    private Button btnEntrar;
    private EditText boxlogin;
    private EditText boxpass;
    private FirebaseAuth firebaseAuth;
    private users users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);
        inicializarComponentes();

        btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnregistroActivity();
            }
        });


        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnentrarActivity();
            }
        });
    }

    private void inicializarComponentes() {
        btnEntrar = (Button) findViewById(R.id.btnentrar);
        btnCadastro = (Button) findViewById(R.id.btnregistro);
        boxlogin = (EditText) findViewById (R.id.boxlogin);
        boxpass = (EditText) findViewById (R.id.boxpass);
    }

    private void btnentrarActivity() {
        if (!boxlogin.getText().toString().equals("") && !boxpass.getText().toString().equals("")){
            users = new users();
            users.setEmail(boxlogin.getText().toString());
            users.setPass(boxpass.getText().toString());
            validar();
        }
        else {
            Toast.makeText(TelaLogin.this, "Falha ao Logar, por favor preencha os campos E-mail e Senha", Toast.LENGTH_SHORT).show();
        }
    }

    private void validar(){
        firebaseAuth = ConfigFirebase.getFirebaseAutenticacao();
        firebaseAuth.signInWithEmailAndPassword(users.getEmail(), users.getPass()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(TelaLogin.this, "Login efetuado com sucesso", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(TelaLogin.this, tela_index.class));
                }
                else{
                    Toast.makeText(TelaLogin.this, "Falha ao Logar, E-mail ou Senha Inválidos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void btnregistroActivity() {
        startActivity(new Intent(TelaLogin.this, tela_cadastro.class));
    }


}
