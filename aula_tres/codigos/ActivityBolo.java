package com.example.applanchonete;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class ActivityBolo extends AppCompatActivity {
    private TextInputEditText textInputUnidadeBolo;
    private Button buttonAdicionar;
    private Double valores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bolo);

        textInputUnidadeBolo = findViewById(R.id.textInputUnidadeBolo);
        buttonAdicionar = findViewById(R.id.buttonAdicionar);
        Intent intent = getIntent();
        if (intent != null){
            valores = intent.getDoubleExtra("valores", 0);
        }
    }

    public void clicar(View view){
        int unidade = Integer.parseInt(textInputUnidadeBolo.getText().toString());
        double total = (unidade * 4.50);
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        valores = valores + total;
        intent.putExtra("totalBolo", valores);
        startActivity(intent);
    }
}