package com.example.nop_had.animalanatomyalpha;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferences {
    private Context context;
    private SharedPreferences preferences;
    private String NOME_ARQUIVO = "animalanatomyalpha.Preferences";
    private int MODE = 0;
    private  SharedPreferences.Editor editor;
    private final String KEY_IDENTIFICADOR = "IdUserLogado";
    private final String KEY_NOME = "NameUserLogado";

    public Preferences(Context context){
        this.context = context;
        preferences = context.getSharedPreferences(NOME_ARQUIVO, MODE);
        editor = preferences.edit();
    }

    public void saveUserPreferences(String IdUserLogado, String NameUserLogado){
        editor.putString(KEY_IDENTIFICADOR, IdUserLogado);
        editor.putString(KEY_NOME, NameUserLogado);
        editor.commit();
    }

    public  String getIdent(){
        return preferences.getString(KEY_IDENTIFICADOR, null);
    }

    public  String getName(){
        return preferences.getString(KEY_NOME, null);
    }

}
