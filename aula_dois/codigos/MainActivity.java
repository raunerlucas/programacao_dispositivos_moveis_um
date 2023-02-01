package com.example.applinearviewactivityintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText editText_palavra;
    private Button button_clicar;
    private TextView textView_resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText_palavra = findViewById(R.id.editText_palavra);
        button_clicar = findViewById(R.id.button_clicar);
        textView_resultado = findViewById(R.id.textView_resultado);

        button_clicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = editText_palavra.getText().toString();
                textView_resultado.setText(msg);
                Intent it = new Intent(MainActivity.this,SegundaActivity.class);
                it.putExtra("dados",msg);
                startActivity(it);

            }
        });

    }//onCreate
}//class