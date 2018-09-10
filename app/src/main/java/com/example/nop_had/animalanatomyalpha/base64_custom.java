package com.example.nop_had.animalanatomyalpha;

import android.util.Base64;

public class base64_custom {
    public static String codificar64(String text){
        return Base64.encodeToString(text.getBytes(), Base64.DEFAULT).replaceAll("(\\n|\\r)","");
    }
    public static String decodificar64(String textcod){
        return new String(Base64.decode(textcod, Base64.DEFAULT));
    }
}
