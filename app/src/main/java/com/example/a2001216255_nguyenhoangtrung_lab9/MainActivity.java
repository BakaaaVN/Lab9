package com.example.a2001216255_nguyenhoangtrung_lab9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn2, btn3, btn4, btn5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    void addControl() {
        btn1 = (Button) findViewById(R.id.menu_bai1);
        btn2 = (Button) findViewById(R.id.menu_bai2);
        btn3 = (Button) findViewById(R.id.menu_bai3);
        btn4 = (Button) findViewById(R.id.menu_bai4);
        btn5 = (Button) findViewById(R.id.menu_bai5);
    }

    void addEvent() {
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Bai1.class);
                startActivity(intent);
            }
        });
    }
}