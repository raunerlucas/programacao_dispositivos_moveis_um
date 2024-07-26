package com.example.activity_ciclo_de_vida;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("onCreate","atividade criada");
        textView1 = findViewById(R.id.textView1);

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Activity2.class);
                startActivity(i);
            }
        });
    }//

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("onStart","atividade iniciada ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("onResume","atividade pronta ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("onPause","atividade pausada ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("onStop","atividade paralizada ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("onDestroy","atividade destruída ");
    }
}//class
