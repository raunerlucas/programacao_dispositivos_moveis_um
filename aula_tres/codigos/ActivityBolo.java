package com.example.app_lanchonete;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityBolo extends AppCompatActivity {
    private EditText editTextQuantidadeBolo;
    private Button buttonAdicionar;
    private Double valores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bolo);

        editTextQuantidadeBolo = findViewById(R.id.editTextQuantidadeBolo);
        buttonAdicionar = findViewById(R.id.buttonAdicionar);
        Intent intent = getIntent();
        if (intent != null){
            valores = intent.getDoubleExtra("valores", 0);
        }
    }

    public void clicar(View view){
        int unidade = Integer.parseInt(editTextQuantidadeBolo.getText().toString());
        double total = (unidade * 4.50);
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        valores = valores + total;
        intent.putExtra("total", valores);
        startActivity(intent);
    }
}
