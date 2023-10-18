package com.example.quizapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class quiz5 extends AppCompatActivity implements View.OnClickListener{
    Button btn_suiv;
    RadioGroup rg;
    RadioButton rb;
    int score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz5);
        btn_suiv=(Button)findViewById(R.id.next5);
        rg=(RadioGroup)findViewById(R.id.radiogroup4);
        btn_suiv.setOnClickListener( this);

    }
    public void onClick(View v){
        switch (v.getId()){
            case R.id.next5:
                int id=rg.getCheckedRadioButtonId();
                rb =(RadioButton)findViewById(id);
                if(rb.getText().toString().equals("Oui"))
                {
                    score=getIntent().getExtras().getInt("score");
                    score=score+1;
                }
                else{
                    score=getIntent().getExtras().getInt("score");
                }
                Toast.makeText(this, String.valueOf(score), Toast.LENGTH_SHORT).show();
                Intent i=new Intent(this,fin.class);

                startActivity(i);
        }
    }
}