package com.example.applinearviewactivityintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {
    private TextView textView_resultado2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        textView_resultado2 = findViewById(R.id.textView_resultado2);
        Intent i = getIntent();
        String palavra = i.getStringExtra("dados");
        textView_resultado2.setText(palavra);
        
    }//onCreate
}//class