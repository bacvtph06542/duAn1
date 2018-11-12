package com.example.macbook.duan1.Model;

import android.widget.EditText;

public class PhoneBook {
    private  String mName , mPhone , mGender;
    private int mImg;

    public PhoneBook(String mName, String mPhone) {
        this.mName = mName;
        this.mPhone = mPhone;
    }

    public PhoneBook(String mName, String mPhone, String mGender, int mImg) {
        this.mName = mName;
        this.mPhone = mPhone;
        this.mGender = mGender;
        this.mImg = mImg;
    }

    public PhoneBook() {
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

    public String getmGender() {
        return mGender;
    }

    public void setmGender(String mGender) {
        this.mGender = mGender;
    }

    public int getmImg() {
        return mImg;
    }

    public void setmImg(int mImg) {
        this.mImg = mImg;
    }
}
