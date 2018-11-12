package com.example.macbook.duan1;

import android.content.Intent;
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
    private TextView save;
    private ListView lv;
    private ContactDAO contactDao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu);
        hinhnen = findViewById(R.id.hinhNen);
        hinhnen.setBackgroundResource(R.drawable.manhinh);
        Sum();

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contactDao = new ContactDAO(getApplicationContext());

//                boolean isMale = true;
//                if (male.isChecked()){
//                    isMale = true;
//                }else {
//                    isMale = false;
//                }
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
    }

    public void listPhone(View view) {
        Intent intent = new Intent(TrangChuActivity.this ,ListContact.class);
        startActivity(intent);
    }
}
