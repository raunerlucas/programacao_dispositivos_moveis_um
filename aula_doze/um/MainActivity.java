public class MainActivity extends AppCompatActivity {

   private EditText editTextNome;

   private Button buttonS, buttonE;


  @Override

protected void onCreate(Bundle savedInstanceState) {

   super.onCreate(savedInstanceState);

   setContentView(R.layout.activity_main);

   editTextNome = findViewById(R.id.editTextTexto);

   buttonS = findViewById(R.id.buttonS);

   buttonE = findViewById(R.id.buttonE);


   Intent  i = getIntent();  

   editTextNome.setText(i.getStringExtra("texto"));  //obter os dados quando a segunda activity passar os dados para esta.

}//onCreate
  
  public void clicar(View v){

   FileOutputStream fos = null;

   if(v.getId() == R.id.buttonS){

       String conteudo = editTextNome.getText().toString();   //obter o dado digitado no campo de entrada

       try {

           fos = openFileOutput("meuArq.txt",

                   Context.MODE_PRIVATE);  //se o arquivo existir, este será aberto. Caso não exista, este será criado. O arquivo é exclusivo do aplicativo.

           fos.write(conteudo.getBytes());  //escreve no arquivo

           fos.close();  //sempre que o arquivo for aberto, este deverá ser fechado.

           Toast.makeText(getApplicationContext(),"Salvo",

                   Toast.LENGTH_SHORT).show();

           editTextNome.setText("");

           Intent i = new Intent(getApplicationContext(),Activity2.class); 

           startActivity(i);   //abrir a segunda tela

       } catch (FileNotFoundException e) {

           e.printStackTrace();

           Log.e("erro1","arquivo não encontrado");

       } catch (IOException e) {

           e.printStackTrace();

           Log.e("erro2","não foi possível escrever");

       }

   }//if


   if(v.getId() == R.id.buttonE){

          getApplicationContext().deleteFile("meuArq.txt");  //deletar o arquivo

          editTextNome.setText("");

          Toast.makeText(getApplicationContext(),"arquivo excluído",Toast.LENGTH_SHORT).show();

   }//if

}//clicar

}
