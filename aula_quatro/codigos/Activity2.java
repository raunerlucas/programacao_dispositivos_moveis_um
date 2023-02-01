package com.example.app_listasimples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {
    private RadioButton radioButtonGuido,radioButtonDennis,radioButtonNiklaus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        radioButtonGuido = findViewById(R.id.radioButtonGuido);
        radioButtonDennis = findViewById(R.id.radioButtonDennis);
        radioButtonNiklaus = findViewById(R.id.radioButtonNiklaus);
    }

    public void onRadioButtonClicked(View view){
        RadioButton radioButton = (RadioButton) view;
        boolean select = radioButton.isChecked();
        switch (view.getId()){
            case R.id.radioButtonDennis:
                if(select){
                    Toast.makeText(this, "Acertou", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.radioButtonGuido:
                if (select){
                    radioButtonGuido.setText("");
                }
                break;
            case R.id.radioButtonNiklaus:
                if (select){
                    radioButtonNiklaus.setText("");
                }
                break;

        }
    }
}