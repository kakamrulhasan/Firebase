package com.example.firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class next extends AppCompatActivity {

    EditText name , age;
    FirebaseDatabase firebaseDatabase;
    Button addBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        name = findViewById(R.id.name_id);
        age = findViewById(R.id.age_id);
        firebaseDatabase = FirebaseDatabase.getInstance();
        addBtn = findViewById(R.id.add_id);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Here we using real time database
                //firebaseDatabase.getReference().child("vendor1").setValue("rani");
                HashMap<String,Object> m = new HashMap<>();
                m.put("name",name.getText().toString());
                m.put("age",age.getText().toString());
                firebaseDatabase.getReference().child("jax").push().setValue(m);
                //we are using push() for multiple values


            }
        });
    }
}