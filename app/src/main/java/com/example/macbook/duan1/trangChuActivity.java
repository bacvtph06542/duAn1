package com.example.macbook.duan1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class TrangChuActivity extends AppCompatActivity {
    LinearLayout hinhnen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu);
        hinhnen = findViewById(R.id.hinhNen);
        hinhnen.setBackgroundResource(R.drawable.manhinh);

    }
}
