public class SegundaActivity extends AppCompatActivity {

   private TextView textViewTexto;

   @Override

protected void onCreate(Bundle savedInstanceState) {

   super.onCreate(savedInstanceState);

   setContentView(R.layout.activity_segunda);

   textViewTexto = findViewById(R.id.textViewTexto);

   String texto = getInfo();

   textViewTexto.setText(texto);

}//onCreate
  
  private String getInfo() {

   StringBuffer sb = null;

   try {

       FileInputStream fis = openFileInput("meuArq.txt");  //solicita a abertura do arquivo no modo de leitura. O arquivo precisa existir.

       sb = new StringBuffer();   

       int retorno = 0;

       char texto = 0;

       while((retorno = fis.read())!=-1){  //o método read() devolve o caractere presente no arquivo, dessa forma é colocado em um laço de repetição. Os caracteres serão devolvidos até encontrar o valor -1 (significando o fim o arquivo)

           texto = (char)retorno;

           sb.append(texto);  //adicionar o caractere no StringBuffer

       }//while

       fis.close();   //encerra o arquivo

   } catch (FileNotFoundException e) {

       e.printStackTrace();

   } catch (IOException e) {

       e.printStackTrace();

   }


   return sb.toString();


}//getInfo
  
  public void abrirTela(View view) {

   Intent i = new Intent(getApplicationContext(), MainActivity.class);

   i.putExtra("texto",textViewTexto.getText().toString());

   startActivity(i);

}

}
