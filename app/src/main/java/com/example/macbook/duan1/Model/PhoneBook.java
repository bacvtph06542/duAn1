package com.example.macbook.duan1.Model;

import android.widget.EditText;

public class PhoneBook {
    private  String mName , mPhone;
    private int mImg;
    private boolean Msex;

    public PhoneBook(String mName, String mPhone, int mImg, boolean msex) {
        this.mName = mName;
        this.mPhone = mPhone;
        this.mImg = mImg;
        Msex = msex;
    }

    public PhoneBook(EditText name, EditText phone) {
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmPhone() {
        return mPhone;
    }

    public void setmPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    public int getmImg() {
        return mImg;
    }

    public void setmImg(int mImg) {
        this.mImg = mImg;
    }

    public boolean isMsex() {
        return Msex;
    }

    public void setMsex(boolean msex) {
        Msex = msex;
    }
}
