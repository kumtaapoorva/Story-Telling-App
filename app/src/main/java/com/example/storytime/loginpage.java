package com.example.storytime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class loginpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginpage);

        Button button=findViewById(R.id.btn);
        button.setOnClickListener(view -> {
            Intent intent1 = new Intent(this, home.class);
            startActivity(intent1);
        });
    }
}