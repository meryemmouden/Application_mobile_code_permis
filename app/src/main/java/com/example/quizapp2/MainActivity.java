package com.example.quizapp2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    /*   EditText email;
       EditText password;
       Button signin;
       Button toregister;
       @Override
       protected void onCreate(Bundle savedInstanceState) {
           super.onCreate(savedInstanceState);
           setContentView(R.layout.activity_main);
           //recupere les elements
           email=findViewById(R.id.email);
           password=findViewById(R.id.password);
           signin=findViewById(R.id.login);
           toregister=findViewById(R.id.toregist);
           //seteventlistner
           signin.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   Log.i("message",email.getText().toString());
                   if(email.getText().toString().trim().equals("test@gmail.com")&&password.getText().toString().equals("test123456")){
                       Toast.makeText(getApplicationContext(), "autentification done with succes", Toast.LENGTH_LONG).show();
                       Intent intent1=new Intent(MainActivity.this,quiz1.class);
                       startActivity(intent1);
                       finish();
                   }
                   else
                   { Toast.makeText(getApplicationContext(), "autentification done with failed", Toast.LENGTH_LONG).show();
                   }
               }
           });
           toregister.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   Intent intent=new Intent(MainActivity.this,signup.class);
                   startActivity(intent);
                   finish();
               }
           });

       }*/
    FirebaseAuth auth;
    EditText email;
    EditText password;
    Button signin;
    Button toregister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //renvoie une instance de la classe FirebaseAuth
        // Vous utilisez cette instance pour effectuer des tâches liées à l'authentification telles que la création d'un nouveau compte utilisateur, la connexion d'un utilisateur
        auth = FirebaseAuth.getInstance();
        //recupere les elements
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        signin = findViewById(R.id.login);
        toregister = findViewById(R.id.toregist);
        signin.setOnClickListener(new View.OnClickListener() {
            // on a l'objet de type View qui représente l'élément de l'interface utilisateur
            @Override
            public void onClick(View view) {
                String email1=email.getText().toString();
                String pass=password.getText().toString();
                // n'est pas vide et si elle correspond à un modèle d'adresse e-mail valide
                if(!email1.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email1).matches()){
                    if(!pass.isEmpty()){
                        //La méthode signInWithEmailAndPassword(email, password) est appelée sur l'objet auth de type FirebaseAuth, qui a été initialisé précédemment, pour s'authentifier avec les informations d'identification fournies par l'utilisateur. Cette méthode vérifie si l'adresse e-mail et le mot de passe correspondent à un compte utilisateur existant dans votre application Firebase.
                       //La méthode addOnSuccessListener permet d'ajouter un écouteur pour écouter les événements de succès de l'authentification. Si l'authentification réussit, la méthode onSuccess est appelée, qui affiche un message de notification "loginsuccessful" en utilisant la méthode Toast.makeText().
                        auth.signInWithEmailAndPassword(email1,pass).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                //La méthode Toast.makeText() crée un objet de type Toast, qui est une notification contextuelle qui s'affiche pendant une courte période de temps. Cette méthode prend trois arguments :
                                //le premier argument MainActivity.this est le contexte actuel de l'application, qui est généralement l'activité en cours ;
                                //le deuxième argument "loginsuccessful" est le texte à afficher dans la notification ;
                                //le troisième argument Toast.LENGTH_SHORT est la durée pendant laquelle la notification s'affiche à l'écran, qui est définie ici à courte durée.
                                Toast.makeText(MainActivity.this, "loginsuccessful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(MainActivity.this,quiz1.class));
                                finish();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(MainActivity.this, "login failed", Toast.LENGTH_SHORT).show();

                            }
                        });
                    }
                    else{
                        password.setError("password can't be empty");
                    }
                }else if(email1.isEmpty()){
                    email.setError("email can't be empty");
                }else{
                    email.setError("please enter valid email");
                }
            }
        });
        toregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,signup.class);
                startActivity(intent);
                finish();
            }
        });

    }

}