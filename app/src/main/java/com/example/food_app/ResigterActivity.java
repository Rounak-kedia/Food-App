package com.example.food_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class ResigterActivity extends AppCompatActivity {

    EditText phone,pw;
    Button reg;
    TextView Login;
    FirebaseAuth Auth_r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resigter);
        Auth_r = FirebaseAuth.getInstance();
        phone=findViewById(R.id.inputphone_r);
        pw=findViewById(R.id.inputpass_r);
        reg=findViewById(R.id.register_btn);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ph1=phone.getText().toString();
                String ps1=pw.getText().toString();
                if(ph1.isEmpty())
                {
                    phone.setError("Please Enter a Phone Number");
                    phone.requestFocus();
                }
                else if(ps1.isEmpty())
                {
                    pw.setError("Please Enter Your Password");
                    pw.requestFocus();
                }
                else if(ph1.isEmpty() && ps1.isEmpty())
                {
                    Toast.makeText(ResigterActivity.this,"Please Enter your Credentials",Toast.LENGTH_SHORT);
                }
                else if(!(ph1.isEmpty() && ps1.isEmpty()))
                {
                    
                }
            }
        });
    }
}