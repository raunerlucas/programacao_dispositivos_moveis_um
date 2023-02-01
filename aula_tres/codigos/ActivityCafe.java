package com.example.applanchonete;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

public class ActivityCafe extends AppCompatActivity {
    private TextInputEditText editTextNumber;
    private Button buttonCafe;
    private Double valores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafe);

        editTextNumber = findViewById(R.id.textInputUnidade);
        buttonCafe = findViewById(R.id.buttonCafe);
        Intent intent = getIntent();
        if (intent != null){
            valores = intent.getDoubleExtra("valores", 0);
        }
    }

    public void clicar(View view){
        int unidade = Integer.parseInt(editTextNumber.getText().toString());
        double total = (unidade * 2.50);
        Intent intent  = new Intent(getApplicationContext(), MainActivity.class);
        valores = valores + total;
        intent.putExtra("total", valores);
        startActivity(intent);
    }//
}