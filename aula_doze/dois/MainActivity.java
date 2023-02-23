public class MainActivity extends AppCompatActivity {

   private EditText editTextNome;

 private Button buttonS, buttonE;

  @Override

protected void onCreate(Bundle savedInstanceState) {

   super.onCreate(savedInstanceState);

   setContentView(R.layout.activity_main);

   editTextNome = findViewById(R.id.editTextNome);

   buttonE = findViewById(R.id.buttonE);

   buttonS = findViewById(R.id.buttonS);


   Intent i = getIntent();

   editTextNome.setText(i.getStringExtra("msg"));   //obter os dados quando a segunda activity passar os dados para esta.


}//onCreate
  
  public void clicar(View view) {

   switch (view.getId()){

       case R.id.buttonS:

           String dado = editTextNome.getText().toString();

           String state = Environment.getExternalStorageState();

           if(Environment.MEDIA_MOUNTED.equals(state)){

               File file =  new File("/sdcard/"+"meuArq.txt");  //criar o arquivo no cartão do dispositivo

               FileOutputStream fos = null;

               try {

                   fos = new FileOutputStream(file);  //obter uma referência de arquivo no modo de escrita

                   OutputStreamWriter osw = new OutputStreamWriter(fos);  //é necessário esta referência para ter acesso ao método de escrita

                   osw.write(dado);  //escreve no arquivo

                   osw.close();   //fecha o arquivo

                   fos.close();  //fecha o arquivo

                   Toast.makeText(getApplicationContext(),"Salvo",Toast.LENGTH_SHORT).show();

                   Intent intent = new Intent(getApplicationContext(), Activity2.class);

                   startActivity(intent);  //abrir a segunda tela


               } catch (FileNotFoundException e) {

                   e.printStackTrace();

               } catch (IOException e) {

                   e.printStackTrace();

               }


           }else{

               Toast.makeText(getApplicationContext(),"não há espaço",Toast.LENGTH_SHORT).show();

           }

           break;


       case R.id.buttonE:

               apagar();

               break;


   }

}//clicar
  
  private void apagar(){

   File file = new File("/sdcard/"+"meuArq.txt");

   file.delete();   //deleta o arquivo

   Toast.makeText(getApplicationContext(),"excluído", Toast.LENGTH_SHORT).show();

}//

}
