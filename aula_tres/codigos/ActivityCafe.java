package com.example.app_lanchonete;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityCafe extends AppCompatActivity {
    private EditText editTextQuantidadeCafe;
    private Button buttonCafe;
    private Double valores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafe);

        editTextQuantidadeCafe = findViewById(R.id.editTextQuantidadeCafe);
        buttonCafe = findViewById(R.id.buttonCafe);
        Intent intent = getIntent();
        if (intent != null){
            valores = intent.getDoubleExtra("valores", 0);
        }
    }

    public void clicar(View view){
        int unidade = Integer.parseInt(editTextQuantidadeCafe.getText().toString());
        double total = (unidade * 2.50);
        Intent intent  = new Intent(getApplicationContext(), MainActivity.class);
        valores = valores + total;
        intent.putExtra("total", valores);
        startActivity(intent);
    }//
}
