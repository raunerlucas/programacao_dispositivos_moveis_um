package com.example.exemploappbar_01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.meu_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("AppBar");
    }//onCreate

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar,menu);
        return super.onCreateOptionsMenu(menu);
    }//

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent it = null;
        switch(item.getItemId()){
            case R.id.java:
                it= new Intent(getApplicationContext(), JavaActivity.class);
                it.putExtra("dados","Java");
                startActivity(it);
                return true;

            case R.id.php:
                it= new Intent(getApplicationContext(), PhpActivity.class);
                it.putExtra("dados","PHP");
                startActivity(it);
                return true;

            case R.id.C:
                it= new Intent(getApplicationContext(), CActivity.class);
                it.putExtra("dados","C");
                startActivity(it);
                return true;

            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }//

    }//onOptions
}//class
