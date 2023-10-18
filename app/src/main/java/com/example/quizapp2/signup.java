package com.example.quizapp2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.quizapp2.databinding.ActivitySignupBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signup extends AppCompatActivity {
 /*   EditText nom;
    EditText email;
    EditText password;
    EditText confirmpassword;

    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        //recupere les elements
        nom=findViewById(R.id.name);
        email=findViewById(R.id.emaill);
        password=findViewById(R.id.password1);
        confirmpassword=findViewById(R.id.password2);
        register=findViewById(R.id.register);
        //seteventlistner
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("message",email.getText().toString());
                if(nom.getText().toString().trim().equals("test")&&email.getText().toString().trim().equals("test@gmail.com")&&password.getText().toString().equals("test123456")&&confirmpassword.getText().toString().equals("test123456")){
                    Toast.makeText(getApplicationContext(), "inscription done with succes", Toast.LENGTH_LONG).show();
                }
                else
                { Toast.makeText(getApplicationContext(), "inscription done with failed", Toast.LENGTH_LONG).show();
                }
            }

        });
    }*/
FirebaseAuth auth;
    EditText nom;
    EditText email;
    EditText password;
    EditText confirmpassword;

    Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    auth=FirebaseAuth.getInstance();
        nom=findViewById(R.id.name);
        email=findViewById(R.id.emaill);
        password=findViewById(R.id.password1);
        confirmpassword=findViewById(R.id.password2);
        register=findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //La méthode trim() est enfin appelée sur cet objet String pour supprimer les espaces blancs inutiles au début et à la fin de la chaîne.
                String name=nom.getText().toString().trim();
                String user=email.getText().toString().trim();
                String pass=password.getText().toString().trim();
                String confirm=confirmpassword.getText().toString().trim();
                if(user.isEmpty()) {
                    nom.setError("email est obligatoire");
                }
                if(pass.isEmpty()) {
                    password.setError("mode de passe est obligatoire");
                }
                else{
                    auth.createUserWithEmailAndPassword(user,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                      //La méthode addOnCompleteListener permet d'ajouter un écouteur pour écouter les événements de succès ou d'échec de la création de l'utilisateur. Si la création de l'utilisateur est réussie, la méthode onComplete est appelée avec une instance de AuthResult qui contient les informations d'identification de l'utilisateur nouvellement créé.
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {//task conntient les info de l'utilisateur
                            if(task.isSuccessful()){
                                Toast.makeText(signup.this, "signup successful", Toast.LENGTH_SHORT).show();
                           startActivity(new Intent(signup.this,MainActivity.class));
                            }
                            else{
                                Toast.makeText(signup.this, "signup failed"+task.getException(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }

            }});
    }
}