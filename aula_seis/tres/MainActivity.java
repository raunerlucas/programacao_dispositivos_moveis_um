package com.example.alertdialoglist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textViewHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewHello = findViewById(R.id.textViewHello);
        textViewHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAlertDialogList();
            }
        });
    }//onCreate

    private void openAlertDialogList() {
        MyDialogFragment mdf = new MyDialogFragment();
        mdf.show(getSupportFragmentManager(),"lista_semana");
    }


}//class
