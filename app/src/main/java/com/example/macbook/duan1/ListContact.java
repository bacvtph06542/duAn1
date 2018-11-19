package com.example.macbook.duan1;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.macbook.duan1.Adapter.PhoneAdapter;
import com.example.macbook.duan1.Model.ContactDAO;
import com.example.macbook.duan1.Model.DanhBa;
import com.example.macbook.duan1.Model.PhoneBook;

import java.util.ArrayList;
import java.util.List;

public class ListContact extends AppCompatActivity {
    private Toolbar toolbar;
    private ListView lv;
    private ContactDAO contactDao;
    private PhoneAdapter adapter;
    private List<PhoneBook> list;
      private ArrayList<DanhBa>listDanhBa;
     private ArrayAdapter<DanhBa> adapterDanhBa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_contact);
        toolbar = findViewById(R.id.toolbar);
        lv = findViewById(R.id.lv);
        setSupportActionBar(toolbar);

        contactDao = new ContactDAO(ListContact.this);
        try {
            list = contactDao.getAllContact() ;
            adapter = new PhoneAdapter(this, list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        lv.setAdapter(adapter);


        listDanhBa = new ArrayList<>();

        adapterDanhBa = new ArrayAdapter<DanhBa>(ListContact.this ,android.R.layout.simple_list_item_1,listDanhBa);
        lv.setAdapter(adapterDanhBa);

           showAllContast();
    }

    private void showAllContast() {
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;

        Cursor cursor = getContentResolver().query(uri,null,null,null,null);

        listDanhBa.clear();

        while (cursor.moveToNext()){
            String Name = ContactsContract.Contacts.DISPLAY_NAME;
            String Phone = ContactsContract.CommonDataKinds.Phone.NUMBER;
            int vitriName = cursor.getColumnIndex(Name);
            int vitriPhone = cursor.getColumnIndex(Phone);
            String name = cursor.getString(vitriName);
            String phone = cursor.getString(vitriPhone);
            DanhBa db = new DanhBa(name , phone);
            listDanhBa.add(db);

        }
        adapterDanhBa.notifyDataSetChanged();

    }


    public void out(View view) {
        finish();
    }
}
