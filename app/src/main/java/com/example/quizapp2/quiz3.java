package com.example.quizapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class quiz3 extends AppCompatActivity implements View.OnClickListener{
    Button btn_suiv;
    RadioGroup rg;
    RadioButton rb;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz3);
        btn_suiv=(Button)findViewById(R.id.next3);
        rg=(RadioGroup)findViewById(R.id.radiogroup2);
        btn_suiv.setOnClickListener(this);
    }
    public void onClick(View v){
        switch (v.getId()){
            case R.id.next3:
                int id=rg.getCheckedRadioButtonId();
                rb =(RadioButton)findViewById(id);
                if(rb.getText().toString().equals("Le tram est areté"))
                {
                    score=getIntent().getExtras().getInt("score");
                    score=score+1;
                }
                else{
                    score=getIntent().getExtras().getInt("score");
                }
                Intent i=new Intent(this,quiz4.class);
                i.putExtra("score",score);
                startActivity(i);
        }
    }
}