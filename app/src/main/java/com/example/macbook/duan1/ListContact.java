package com.example.macbook.duan1;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.macbook.duan1.adapter.DanhBaAdapter;
import com.example.macbook.duan1.model.ContactDAO;
import com.example.macbook.duan1.model.DanhBa;

import java.util.ArrayList;
import java.util.List;

public class ListContact extends AppCompatActivity {
    private Toolbar toolbar;
    private ListView lv;
    private DanhBaAdapter adapter;
    private List<DanhBa>listDanhBa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_contact);
        toolbar = findViewById(R.id.toolbar);
        lv = findViewById(R.id.lv);
        setSupportActionBar(toolbar);
        listDanhBa = new ArrayList<>();
        adapter = new DanhBaAdapter(this, listDanhBa);
        lv.setAdapter(adapter);
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(ListContact.this);
                builder.setMessage("Mời bạn chọn chức năng");
                builder.setCancelable(false);
                builder.setPositiveButton("xoá", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        listDanhBa.remove(position);
                        adapter.notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(ListContact.this , TrangChuActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("name" ,listDanhBa.get(position).getDbname());
                        bundle.putString("phone" ,listDanhBa.get(position).getDbphone());
                        intent.putExtras(bundle);
                        ListContact.this.startActivity(intent);

                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();


                return false;
            }
        });

      showAllContast();
    }

    private void showAllContast() {
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;

        Cursor cursor = getContentResolver().query(uri,null,null,null,null);

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
        adapter = new DanhBaAdapter(this, listDanhBa);

        lv.setAdapter(adapter);

    }

    public void out(View view) {
        finish();
    }
}
