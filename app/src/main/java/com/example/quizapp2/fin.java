package com.example.quizapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class fin extends AppCompatActivity {

    Button logout;
    Button tryag;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fin);
        logout = findViewById(R.id.logout);
        tryag = findViewById(R.id.again);
        tryag.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(fin.this,quiz1.class);
                startActivity(intent1);
                finish();
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(fin.this,MainActivity.class);
                startActivity(intent1);
                finish();
            }
        });

    }
}