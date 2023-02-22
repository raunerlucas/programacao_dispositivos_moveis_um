public class MainActivity extends AppCompatActivity {

   private Button buttonTela1,buttonTela2;

   private FragmentManager fm;


  @Override

protected void onCreate(Bundle savedInstanceState) {

   super.onCreate(savedInstanceState);

   setContentView(R.layout.activity_main);

   buttonTela1 = findViewById(R.id.buttonTela1);  //fazer as conversões

   buttonTela2 = findViewById(R.id.buttonTela2);

   fm = getSupportFragmentManager();   //obter uma referência do gerenciador

}

  public void trocar(View view){

   if(view.getId() == R.id.buttonTela1){

       FragmentTransaction ft = fm.beginTransaction();  //obter uma referência de FragmentTransaction, este serve para adicionar, remover e excluir o fragmento

       ft.add(R.id.telaPrincipal, new Tela1());  //adicionar a tela 1 no FrameLayout da tela principal

       ft.commit();  //confirmar a adição


   }


   if(view.getId() == R.id.buttonTela2){

       FragmentTransaction ft = fm.beginTransaction();

       ft.add(R.id.telaPrincipal, new Tela2());

       ft.commit();


   }

}//


}
