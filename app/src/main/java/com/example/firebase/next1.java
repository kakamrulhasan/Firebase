package com.example.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class next1 extends AppCompatActivity {

    Button show;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next1);
        show = findViewById(R.id.btn_show_values);
        list = findViewById(R.id.listview_id);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArrayList<String> a = new ArrayList<>();
                ArrayAdapter adapter = new ArrayAdapter(next1.this,R.layout.items,a);
                list.setAdapter(adapter);
                FirebaseDatabase.getInstance().getReference().child("jax").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()) {

                            a.clear();
                            for (DataSnapshot snapshot1:snapshot.getChildren()){
                                vendor1 i = snapshot1.getValue(vendor1.class);
                                String t = i.getName()+":"+i.getAge();
                                a.add(t);
                            }
                            adapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }
}