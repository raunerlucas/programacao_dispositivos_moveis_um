import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;


public class MainActivity extends AppCompatActivity {


   @Override

   protected void onCreate(Bundle savedInstanceState) {

       super.onCreate(savedInstanceState);

       setContentView(R.layout.activity_main);


       if (savedInstanceState == null) {

           Bundle bundle = new Bundle();

           bundle.putInt("some_int", 10);


           getSupportFragmentManager().beginTransaction()    //gerenciamento do fragmento

                   .setReorderingAllowed(true)  //como consta na documentação, este método sempre deve ser usado nas transações dos fragmentos, pois permite uma execução adequada das transações.

                   .add(R.id.fragment_container_view,

                           ExampleFragment.class, bundle)   //adicionando o fragmento e passando o valor

                   .commit();

       }

   }

}
