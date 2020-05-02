package com.example.food_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText phone,pw;
    Button login;
   // TextView Register;
    FirebaseAuth Auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Context context=MainActivity.this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Auth = FirebaseAuth.getInstance();
        phone=findViewById(R.id.inputphone);
        pw=findViewById(R.id.inputpass);
        login=findViewById(R.id.login_btn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(MainActivity.this,Dashboard.class));
            }
        });
    }
}
