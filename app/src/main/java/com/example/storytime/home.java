package com.example.storytime;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        CardView s1=findViewById(R.id.s1);
        s1.setOnClickListener(view -> {
            Intent intent1 = new Intent(this, s1.class);
            startActivity(intent1);
        });

        CardView s2=findViewById(R.id.s2);
        s2.setOnClickListener(view -> {
            Intent intent1 = new Intent(this, s2.class);
            startActivity(intent1);
        });

        CardView s3=findViewById(R.id.s3);
        s3.setOnClickListener(view -> {
            Intent intent1 = new Intent(this, s3.class);
            startActivity(intent1);
        });

        CardView s4=findViewById(R.id.s4);
        s4.setOnClickListener(view -> {
            Intent intent1 = new Intent(this, s4.class);
            startActivity(intent1);
        });

        CardView s5=findViewById(R.id.s5);
        s5.setOnClickListener(view -> {
            Intent intent1 = new Intent(this, s5.class);
            startActivity(intent1);
        });

        CardView s6=findViewById(R.id.s6);
        s6.setOnClickListener(view -> {
            Intent intent1 = new Intent(this, s6.class);
            startActivity(intent1);
        });
    }
}