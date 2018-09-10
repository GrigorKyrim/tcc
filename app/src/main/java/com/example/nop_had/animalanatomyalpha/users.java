package com.example.nop_had.animalanatomyalpha;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class users {
    private String login;
    private String name;
    private String pass;
    private String email;
    private String tel;

    public users() {
    }

    public void save(){
        DatabaseReference databaseReference = ConfigFirebase.getFirebase();
        databaseReference.child("users").child(String.valueOf(getLogin())).setValue(this);
    }

    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> HashMapUsers = new HashMap<>();
        HashMapUsers.put("login", getLogin());
        HashMapUsers.put("name", getName());
        HashMapUsers.put("pass", getPass());
        HashMapUsers.put("email", getEmail());
        HashMapUsers.put("tel", getTel());
        return HashMapUsers;

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
