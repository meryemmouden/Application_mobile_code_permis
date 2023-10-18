package com.example.quizapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class quiz1 extends AppCompatActivity implements View.OnClickListener {
Button btn_suiv;
RadioGroup rg;
RadioButton rb;
int score=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz1);
        btn_suiv = (Button) findViewById(R.id.next1);
        rg = (RadioGroup) findViewById(R.id.radiogroup);
        //Lorsque l'utilisateur cliquera sur ce bouton, l'événement sera détecté et la méthode onClick sera appelée pour effectuer une action spécifiée.
       // Cela permet à la méthode onClick d'être appelée lorsqu'un événement de clic se produit sur le bouton "btn_suiv".
        btn_suiv.setOnClickListener(this);

    }
//La méthode onClick est appelée lorsque l'utilisateur clique sur le bouton "btn_suiv" (comme défini dans la ligne de code "btn_suiv.setOnClickListener(this);"). Cette méthode prend en argument la vue qui a déclenché l'événement de clic, dans ce cas, le bouton "btn_suiv"
      public void onClick(View v){
        //Le bloc switch permet de vérifier si l'identifiant de la vue passée en argument correspond à celui du bouton "next1" (R.id.next1). Si c'est le cas, le score est calculé en fonction de la réponse sélectionnée dans le groupe de boutons radio (RadioGroup) identifié par "rg".
        switch (v.getId()){
            case R.id.next1:
        //La méthode getCheckedRadioButtonId() est utilisée pour obtenir l'identifiant de l'option sélectionnée dans le groupe de boutons radio. Cet identifiant est ensuite utilisé pour obtenir la référence de l'objet RadioButton correspondant en utilisant la méthode findViewById.
            int id=rg.getCheckedRadioButtonId();
            rb =(RadioButton)findViewById(id);
            if(rb.getText().toString().equals("Oui"))
            {
            score=1;}
            Intent i=new Intent(this,quiz2.class);
            i.putExtra("score",score);
            startActivity(i);
        }
    }
}
