package com.example.quizapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class quiz2 extends AppCompatActivity implements View.OnClickListener{
    Button btn_suiv;
    RadioGroup rg;
    RadioButton rb;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz2);
        btn_suiv=(Button)findViewById(R.id.next2);
        rg=(RadioGroup)findViewById(R.id.radiogroup1);
        btn_suiv.setOnClickListener(this);

    }
    public void onClick(View v){
        switch (v.getId()){
            case R.id.next2:
                int id=rg.getCheckedRadioButtonId();
                rb =(RadioButton)findViewById(id);
                if(rb.getText().toString().equals("A droite"))
                {// permet de récupérer le score précédemment calculé dans l'activité Quiz1
                 score=getIntent().getExtras().getInt("score");
                score=score+1;
                }
                else{
                    score=getIntent().getExtras().getInt("score");
                }
                Intent i=new Intent(this,quiz3.class);
                i.putExtra("score",score);
                startActivity(i);
        }
    }
}