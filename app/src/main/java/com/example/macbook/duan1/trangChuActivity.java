package com.example.macbook.duan1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.macbook.duan1.Adapter.PhoneAdapter;
import com.example.macbook.duan1.Model.PhoneBook;

import java.util.ArrayList;
import java.util.List;

public class TrangChuActivity extends AppCompatActivity {
    LinearLayout hinhnen;
    PhoneAdapter phoneAdapter;
    private List<PhoneBook> phoneBooks;
    private EditText phone , name;
    private RadioButton male , female;
    private Button save;
    private ListView lv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu);
        hinhnen = findViewById(R.id.hinhNen);
        hinhnen.setBackgroundResource(R.drawable.manhinh);
        Sum();
        phoneBooks = new ArrayList<>();
        phoneAdapter = new PhoneAdapter(this,R.layout.activity_item,phoneBooks);
        lv.setAdapter(phoneAdapter);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                boolean isMale = true;
//                if (male.isChecked()){
//                    isMale = true;
//                }else {
//                    isMale = false;
//                }
                String namee = name.getText().toString();
                String phonee = phone.getText().toString();
                if (namee.equals("")||phonee.equals("")){
                    Toast.makeText(TrangChuActivity.this, "ban da lam cai gi vay", Toast.LENGTH_SHORT).show();
                }else {

                    //PhoneBook phoneBook1 = new PhoneBook(isMale ,name , phone);
                    PhoneBook phoneBook1 = new PhoneBook(name , phone);
                    phoneBooks.add(phoneBook1);
                    //startActivity(new Intent(TrangChuActivity.this,It));
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
        lv = findViewById(R.id.listview);
    }

}
