import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;

import android.os.Bundle;

import android.view.View;

import android.widget.AdapterView;

import android.widget.ArrayAdapter;

import android.widget.ListView;


import java.util.ArrayList;


public class Activity2 extends AppCompatActivity

      implements AdapterView.OnItemClickListener {

  private ListView lista;

  private ArrayAdapter<Pessoa> adapter;


  @Override

  protected void onCreate(Bundle savedInstanceState) {

      super.onCreate(savedInstanceState);

      setContentView(R.layout.activity_2);

      lista = findViewById(R.id.lista);

      ArrayList<Pessoa>dados = (ArrayList<Pessoa>) getIntent()

              .getSerializableExtra("dados");

      adapter = new ArrayAdapter<>(this,

              android.R.layout.simple_list_item_1,dados);

      lista.setAdapter(adapter);

      lista.setOnItemClickListener(this);

  }//onCreate


  @Override

  public void onItemClick(AdapterView<?> parent, View view,

                          int position, long id) {

     Pessoa p = (Pessoa) parent.getItemAtPosition(position);

      Intent it = new Intent(Activity2.this, MainActivity.class);

      it.putExtra("dado",p);

      startActivity(it);

  }//onItem

}//class


