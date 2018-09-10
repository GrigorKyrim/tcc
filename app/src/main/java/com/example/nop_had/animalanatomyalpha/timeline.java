package com.example.nop_had.animalanatomyalpha;

import android.widget.Button;

public class timeline {

    private String title;
    private int image;
    private String user;
    private String desc;
    private int btninteresse;
    private int btncomments;
    private int btnshare;

    public timeline (String title, String user, String desc, int image, int btninteresse, int btncomments, int btnshare) {
        this.title = title;
        this.image = image;
        this.user = user;
        this.desc = desc;
        this.btninteresse = btninteresse;
        this.btncomments = btncomments;
        this.btnshare = btnshare;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getBtninteresse() {
        return btninteresse;
    }

    public void setBtninteresse(int btninteresse) {
        this.btninteresse = btninteresse;
    }

    public int getBtncomments() {
        return btncomments;
    }

    public void setBtncomments(int btncomments) {
        this.btncomments = btncomments;
    }

    public int getBtnshare() {
        return btnshare;
    }

    public void setBtnshare(int btnshare) {
        this.btnshare = btnshare;
    }
}
