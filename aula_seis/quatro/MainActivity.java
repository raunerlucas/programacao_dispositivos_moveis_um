package com.example.alertdialogfragmenttest;


import androidx.appcompat.app.AppCompatActivity;


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

               openAlertDialog();

           }

       });

   }//onCreate


   private void openAlertDialog(){

       MyDialogFragment mdf = new MyDialogFragment();   //criação do objeto da classe MyDialogFragment

       mdf.show(getSupportFragmentManager(),"clima");    //chame o método show passando um gerenciador de fragmento e a tag necessária para salvar/restaurar os dados referente do fragmento

   }//open

}//class
