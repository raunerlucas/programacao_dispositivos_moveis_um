package com.example.app_listasimples;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
    private ListView listViewLinguagens;
    private ArrayList<String> listaDados;
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listViewLinguagens = findViewById(R.id.listaLinguagens);
        preencherLista();
        preencherAdapter();
        listViewLinguagens.setAdapter(adapter);
        listViewLinguagens.setOnItemClickListener(this);
        listViewLinguagens.setOnItemLongClickListener(this);
    }

    private void preencherAdapter() {
        adapter = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,listaDados);
    }

    private void preencherLista() {
        listaDados = new ArrayList<>();
        listaDados.add("C");
        listaDados.add("JAVA");
        listaDados.add("KOTLIN");
        listaDados.add("LUA");
        listaDados.add("PASCAL");
        listaDados.add("PYTHON");
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String item = adapterView.getItemAtPosition(i).toString();
        abrirTela(item);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        String linguagem = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(this, "click Longo "+ linguagem, Toast.LENGTH_SHORT).show();
        return true;
    }

    public void abrirTela(String item){

        Intent intent;
        switch (item){
            case "C":
                intent= new Intent(getApplicationContext(), Activity2.class);
                startActivity(intent);
                break;

        }

    }
}