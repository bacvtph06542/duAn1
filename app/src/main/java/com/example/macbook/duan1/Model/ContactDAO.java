package com.example.macbook.duan1.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.macbook.duan1.database.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class ContactDAO {
    private final SQLiteDatabase db;
    public static final String TABLE_NAME = "Contact";
    public static final String COLUMN_NAME = "id";
    public static final String COLUMN_PHONE = "loai";
    public static final String COLUMN_GENDER = "cannang";
    public static final String SQL_CONTACT= "CREATE TABLE "+TABLE_NAME+" ("+COLUMN_NAME+" text primary key, "+COLUMN_PHONE+" text, "+COLUMN_GENDER+" text);";
    public static final String TAG = "CONTACT_DAO";

    public ContactDAO(Context context) {
        DatabaseHelper databasemanager = new DatabaseHelper(context);
        db = databasemanager.getWritableDatabase();
    }

    public int insertContact(PhoneBook contact) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, contact.getmName());
        values.put(COLUMN_PHONE, contact.getmPhone());
        values.put(COLUMN_GENDER, contact.getmGender());

        try {
            if (db.insert(TABLE_NAME, null, values) == -1) {
                return -1;
            }
        } catch (Exception ex) {
            Log.e(TAG, ex.toString());
        }
        return 1;
    }

    public int updateContact(PhoneBook contact) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, contact.getmName());
        values.put(COLUMN_PHONE, contact.getmPhone());
        values.put(COLUMN_GENDER, contact.getmGender());
        int result = db.update(TABLE_NAME, values, COLUMN_NAME+"=?", new String[]{contact.getmName()});
        if (result == 0) {
            return -1;
        }
        return 1;
    }

    public List<PhoneBook> getAllContact() {
        List<PhoneBook> dsCat = new ArrayList<>();
        Cursor c = db.query(TABLE_NAME, null, null, null, null, null, null);
        c.moveToFirst();
        while (c.isAfterLast() == false) {
            PhoneBook ee = new PhoneBook();
            ee.setmName(c.getString(0));
            ee.setmPhone(c.getString(1));
            ee.setmGender(c.getString(2));
            dsCat.add(ee);
            Log.d("//=====", ee.toString());
            c.moveToNext();
        }
        c.close();
        return dsCat;
    }

    public int deleteContactbyName(String contacts) {
        int result = db.delete(TABLE_NAME, COLUMN_NAME+"=?", new String[]{contacts});
        if (result == 0)
            return -1;
        return 1;
    }
}
