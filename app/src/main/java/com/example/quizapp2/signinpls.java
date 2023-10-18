/*package com.example.quizapp2;

import android.content.Intent;
import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

        import androidx.appcompat.app.AppCompatActivity;

public class signinpls extends AppCompatActivity {
    EditText email;
    EditText password;
    Button signin;
    Button toregister;
    protected void oncreate (Bundle savedinstancestate){
        super.onCreate(savedinstancestate);
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
                if(email.getText().toString().trim().equals("test@gmail.com")&&password.getText().equals("test123456")){
                    Toast.makeText(getApplicationContext(), "autentification done with succes", Toast.LENGTH_LONG).show();
                }
                else
                { Toast.makeText(getApplicationContext(), "autentification done with failed", Toast.LENGTH_LONG).show();
                }
            }
        });
        toregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(signinpls.this,signup.class);
                startActivity(intent);
                finish();
            }
        });

    }}
*/