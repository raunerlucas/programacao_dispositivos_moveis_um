package com.example.app_lanchonete;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private ImageView imageViewBolo, imageViewCafe;
    private Button buttonCalcular;
    private TextView textViewResultado;
    private double valores;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageViewBolo = findViewById(R.id.imageBolo);
        imageViewCafe = findViewById(R.id.imageCafe);
        buttonCalcular = findViewById(R.id.btCalcular);
        textViewResultado = findViewById(R.id.textViewResultado);

        Intent intent = getIntent();
        if (intent != null) {
            double valor = intent.getDoubleExtra("total", 0);
            // double valorBolo = intent.getDoubleExtra("totalBolo", 0);
            valores = valores + valor;
        }


    }

    public void escolher(View view) {
        if (R.id.imageBolo == view.getId()) {
            Intent intentBolo = new Intent(getApplicationContext(), ActivityBolo.class);
            if (valores != 0) {
                intentBolo.putExtra("valores", valores);
            }
            startActivity(intentBolo);
        }

        if (R.id.imageCafe == view.getId()) {
            Intent intentCafe = new Intent(getApplicationContext(), ActivityCafe.class);
            if (valores != 0) {
                intentCafe.putExtra("valores", valores);
            }
            startActivity(intentCafe);
        }

        if (R.id.btCalcular == view.getId()) {
            textViewResultado.setText(String.valueOf(valores));
        }
    }

}//class
