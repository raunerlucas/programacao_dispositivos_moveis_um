package com.example.applanchonete;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{
    private ImageView imageViewBolo, imageViewCafe;
    private Button buttonCalcular;
    private TextView textViewResultado;
    private Double valores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageViewBolo = findViewById(R.id.imageViewBolo);
        imageViewCafe = findViewById(R.id.imageViewCafe);
        buttonCalcular = findViewById(R.id.buttonCalcular);
        textViewResultado = findViewById(R.id.textViewResultado);

        Intent intent = getIntent();
        if (intent != null){
            double valor = intent.getDoubleExtra("total", 0);
            double valorBolo = intent.getDoubleExtra("totalBolo", 0);
            valores = valor + valorBolo;
        }
    }

    public  void click(View view){
        switch (view.getId()){
            case R.id.imageViewBolo:
                Intent intentBolo = new Intent(getApplicationContext(), ActivityBolo.class);
                if(valores != 0){
                    intentBolo.putExtra("valores", valores);
                }
                startActivity(intentBolo);
                break;
            case R.id.imageViewCafe:
                Intent intentCafe = new Intent(getApplicationContext(), ActivityCafe.class);
                if(valores != 0){
                    intentCafe.putExtra("valores", valores);
                }
                startActivity(intentCafe);
                break;
            case R.id.buttonCalcular:
                textViewResultado.setText(valores.toString());
                break;

        }
    }
}