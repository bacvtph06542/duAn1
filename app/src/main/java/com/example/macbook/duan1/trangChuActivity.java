package com.example.macbook.duan1;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.macbook.duan1.Adapter.PhoneAdapter;
import com.example.macbook.duan1.Model.ContactDAO;
import com.example.macbook.duan1.Model.PhoneBook;
import com.example.macbook.duan1.R;

import java.util.ArrayList;
import java.util.List;

public class TrangChuActivity extends AppCompatActivity {
    LinearLayout hinhnen;
    PhoneAdapter phoneAdapter;
    private List<PhoneBook> phoneBooks;
    private EditText phone , name;
    private RadioButton male , female;
    private TextView save , dongBo;

    private ListView lv;
    private ContactDAO contactDao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu);
        hinhnen = findViewById(R.id.hinhNen);
        hinhnen.setBackgroundResource(R.drawable.manhinh);
        Sum();

// xin quyen cho android 6.0 tro len
        int Call = ContextCompat.checkSelfPermission(this,Manifest.permission.CALL_PHONE);
        int DanhBa = ContextCompat.checkSelfPermission(this,Manifest.permission.READ_CONTACTS);
        int Camera = ContextCompat.checkSelfPermission(this,Manifest.permission.CAMERA);

        if (Call != PackageManager.PERMISSION_GRANTED ||
                DanhBa != PackageManager.PERMISSION_GRANTED ||
                      Camera != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{
                    Manifest.permission.READ_CONTACTS ,
                    Manifest.permission.CALL_PHONE,
                    Manifest.permission.CAMERA},1);
        }
//==================================================================//



        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contactDao = new ContactDAO(getApplicationContext());

                String namee = name.getText().toString();
                String phonee = phone.getText().toString();
                PhoneBook contact = null;
                try {
                    contact = new PhoneBook(namee,phonee);
                }catch (Exception e){
                    e.printStackTrace();
                }

                if (contactDao.insertContact(contact) > 0) {
                    Toast.makeText(getApplicationContext(), "Add successfully", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(new Intent(getApplicationContext(), ListContact.class));
                } else {
                    name.setError("Add error");

                }


            }
        });


    }

    public void Sum(){
        phone = findViewById(R.id.edt_phone);
        name = findViewById(R.id.edt_name);
        male = findViewById(R.id.rdo_male);
        female = findViewById(R.id.rdo_female);
        save = findViewById(R.id.btn_save);
        dongBo = findViewById(R.id.dongbo);
    }

    public void listPhone(View view) {
        Intent intent = new Intent(TrangChuActivity.this ,ListContact.class);
        startActivity(intent);
    }
}
