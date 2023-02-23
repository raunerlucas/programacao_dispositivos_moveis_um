import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;

import android.content.Intent;

import android.database.sqlite.SQLiteOpenHelper;

import android.os.Bundle;

import android.view.View;

import android.widget.Button;

import android.widget.EditText;

import android.widget.Toast;


import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

   private EditText editTextNome, editTextTelefone;

   private Button buttonS, buttonD, buttonL;

   private Pessoa p;


   private static Banco helper;


   @Override

   protected void onCreate(Bundle savedInstanceState) {

       super.onCreate(savedInstanceState);

       setContentView(R.layout.activity_main);

       editTextNome = findViewById(R.id.editTextNome);

       editTextTelefone = findViewById(R.id.editTextTelefone);

       buttonS= findViewById(R.id.buttonS);

       buttonL= findViewById(R.id.buttonL);

       buttonD= findViewById(R.id.buttonD);


       p= (Pessoa) getIntent().getSerializableExtra("dado");

       if(p!=null){

           editTextNome.setText(p.getNome());

           editTextTelefone.setText(p.getTelefone());

       }


   }//onCreate


   public static SQLiteOpenHelper criarBanco(Context context){

       if(helper==null){

           helper = new Banco(context);

       }

       return helper;

   }//


   public void clicar(View view) {

       CRUD crud = new CRUD(getApplicationContext());

       switch (view.getId()){

           case R.id.buttonS:


               if(p==null){

                   p = new Pessoa();

                   p.setNome(editTextNome.getText().toString());

                   p.setTelefone(editTextTelefone.getText().toString());

                   long retorno = crud.adicionar(p);

                   if(retorno!=-1){

                       Toast.makeText(MainActivity.this,"salvo", Toast.LENGTH_SHORT).show();

                       p=null;

                       editTextNome.setText("");

                       editTextTelefone.setText("");

                   }else{

                       Toast.makeText(MainActivity.this,"não salvo", Toast.LENGTH_SHORT).show();

                   }

               }else{

                   p.setNome(editTextNome.getText().toString());

                   p.setTelefone(editTextTelefone.getText().toString());

                   int retorno = crud.atualizar(p);

                   if(retorno!=0){

                       Toast.makeText(MainActivity.this,"salvo", Toast.LENGTH_SHORT).show();

                   }else{

                       Toast.makeText(MainActivity.this,"não salvo", Toast.LENGTH_SHORT).show();

                   }

               }

               break;


           case R.id.buttonL:

               ArrayList<Pessoa> dados = crud.listar();

               if(dados!=null){

                   Intent it =new Intent(MainActivity.this,

                           Activity2.class);

                   it.putExtra("dados",dados);

                   startActivity(it);

                   finish();

               }//if

               else{

                   Toast.makeText(MainActivity.this,"sem dados",

                           Toast.LENGTH_SHORT).show();

               }

               break;


           case R.id.buttonD:

               int retorno = crud.excluir(p);

               if(retorno>0){

                   Toast.makeText(MainActivity.this,"dados deletados",

                           Toast.LENGTH_SHORT).show();

                   editTextNome.setText("");

                   editTextTelefone.setText("");

               }else{

                   Toast.makeText(MainActivity.this,"erro ao deletar",

                           Toast.LENGTH_SHORT).show();

               }

               break;


       }//switch

   }//clicar

}//class
