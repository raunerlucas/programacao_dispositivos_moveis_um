import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;

import android.provider.MediaStore;

import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import com.google.android.material.snackbar.Snackbar;


public class MainActivity extends AppCompatActivity {


   @Override

   protected void onCreate(Bundle savedInstanceState) {

       super.onCreate(savedInstanceState);

       setContentView(R.layout.activity_main);


       FloatingActionButton fab = findViewById(R.id.fab);  //conversão do xml para o tipo de classe

       fab.setOnClickListener(new View.OnClickListener() {  //adicionar um listener para capturar evento de clique

           @Override

           public void onClick(View view) {   //método fornecido pela interface

               Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)

                       .setAction("Action", null).show(); //mostrar uma mensagem, semelhante ao Toast. No método setAction é possível fazer que o Snackbar trate um evento. No exemplo, foi passado null, pois a ideia é apenas mostrar o texto na tela. 

               Intent intent =  new Intent(MediaStore.ACTION_IMAGE_CAPTURE); //cria um objeto de mensagem com a ação de capturar uma imagem. Dessa forma, o app que tem a capacidade de tratar essa ação será chamado. Por exemplo, o app nativo que aciona a câmera do celular.

               startActivity(intent);

           }

       });

   }

}
