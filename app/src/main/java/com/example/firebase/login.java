package com.example.firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {

    Button Login;
    EditText email, password;

    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Login = findViewById(R.id.btn_login_id);
        email = findViewById(R.id.login_email_id);
        auth = FirebaseAuth.getInstance();
        password = findViewById(R.id.login_password_id);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email1 = email.getText().toString();
                String password1 = password.getText().toString();
                if (email1.isEmpty()||password1.isEmpty()){
                    Toast.makeText(login.this, "Enter Email and password", Toast.LENGTH_SHORT).show();
                }
                else {
                    loginx(email1,password1);
                }

            }
        });

    }

    private void loginx(String email1, String password1) {
        auth.signInWithEmailAndPassword(email1,password1).addOnSuccessListener(login.this, new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {

                Toast.makeText(login.this, "Loign successful", Toast.LENGTH_SHORT).show();
            }
        });
    }
}