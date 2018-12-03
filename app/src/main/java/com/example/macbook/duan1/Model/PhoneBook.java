package com.example.macbook.duan1.model;

public class PhoneBook  {
    private  String mName , mPhone ;


    public PhoneBook() {
    }

    public PhoneBook(String mName, String mPhone, String mGender, byte[] mImg) {
        this.mName = mName;
        this.mPhone = mPhone;
    }

    public PhoneBook(String namee, String phonee) {
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

    @Override
    public String toString() {
        return mName +mPhone;
    }
}
