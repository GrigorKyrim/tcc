package com.example.nop_had.animalanatomyalpha;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class tela_cadastro extends AppCompatActivity {

    private Button btnCancelar;
    private Button btnSave;
    private Button btnDelete;
    private EditText boxname;
    private EditText boxlogin;
    private EditText boxpassword;
    private EditText boxpasswordconfirm;
    private EditText boxemail;
    private EditText boxtel;
    private users users;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);
        inicializarComponentes();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (boxpassword.getText().toString().equals(boxpasswordconfirm.getText().toString())) {
                    String email = boxemail.getText().toString().trim();
                    String pass = boxpassword.getText().toString().trim();
                    cadastraruser(email, pass);
                }
                else{
                    Toast.makeText(tela_cadastro.this, "As senhas não correspondem, tente novamente", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btncancelActivity();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boxname.setText("");
                boxlogin.setText("");
                boxpassword.setText("");
                boxpasswordconfirm.setText("");
                boxemail.setText("");
                boxtel.setText("");
            }
        });
    }

    private void cadastraruser(String email, String pass) {
        firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(tela_cadastro.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(tela_cadastro.this, "Usuário Cadastrado com sucesso", Toast.LENGTH_LONG).show();
                    openlogin();
            }else{
                    String error = "";
                    try{
                        throw task.getException();
                    }catch (FirebaseAuthWeakPasswordException e){
                        error = "Senha fraca, digite no mínimo 8 caracteres contendo letras e números";
                    }catch (FirebaseAuthInvalidCredentialsException e){
                        error = "E-mail Inválido";
                    }catch (FirebaseAuthUserCollisionException e){
                        error = "Esse E-mail já existe";
                    }catch (Exception e){
                        error = "Não foi possível efetuar o cadastro, tente novamente mais tarde";
                        e.printStackTrace();
                    }
                    Toast.makeText(tela_cadastro.this, "Erro: " + error, Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void openlogin(){
        Intent intent = new Intent(tela_cadastro.this, TelaLogin.class);
        startActivity(intent);
        finish();
    }

    private void inicializarComponentes() {
        btnCancelar = (Button) findViewById(R.id.btncancel);
        btnSave = (Button) findViewById(R.id.btnsave);
        btnDelete = (Button) findViewById(R.id.btnexcluir);
        boxname = (EditText) findViewById (R.id.boxname);
        boxlogin = (EditText) findViewById (R.id.boxlogin);
        boxpassword = (EditText) findViewById (R.id.boxpassword);
        boxpasswordconfirm = (EditText) findViewById (R.id.boxpasswordconfirm);
        boxemail = (EditText) findViewById (R.id.boxemail);
        boxtel = (EditText) findViewById (R.id.boxtel);
    }

    private void btncancelActivity() {
        startActivity(new Intent(tela_cadastro.this, TelaLogin.class));
    }

    @Override
    protected void onStart(){
        super.onStart();
        firebaseAuth = ConfigFirebase.getFirebaseAuth();
    }

}
