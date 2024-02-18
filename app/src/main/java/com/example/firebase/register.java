package com.example.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class register extends AppCompatActivity {

    EditText remail, rpassword;
    FirebaseAuth auth;
    Button Register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        remail = findViewById(R.id.register_email_id);
        rpassword = findViewById(R.id.register_password_id);
        Register = findViewById(R.id.btn_register_id);
        auth = FirebaseAuth.getInstance();
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = remail.getText().toString();
                String password = rpassword.getText().toString();
                if (email.isEmpty()||password.isEmpty()){
                    Toast.makeText(register.this, "Enter Email and password", Toast.LENGTH_SHORT).show();
                }
                else {
                    regis(email,password);
                }
                
            }
        });

    }

    private void regis(String email, String password) {
        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(register.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(register.this, "successfully registered", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(register.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}