public class SegundaActivity extends AppCompatActivity {

   private TextView textView;

   private static final String NOME_FILE = "/sdcard/meuArq.txt";


   @Override

protected void onCreate(Bundle savedInstanceState) {

   super.onCreate(savedInstanceState);

   setContentView(R.layout.activity_2);

   textView = findViewById(R.id.textView);

   textView.setText(obterDados());   //chamar o método obterDados que devolve uma String

}//onCreate
  
  private String obterDados(){

   int retorno = 0;

   StringBuilder texto = new StringBuilder();

   String state = Environment.getExternalStorageState();  //obtém o diretório para ter acesso ao SDCARD. A partir da API 29, pode ser usado o método getExternalFilesDir(String) obtido através do Context.

   if(Environment.MEDIA_MOUNTED.equals(state)){  //verifica se o dispositivo está montado

       File file = new File(NOME_FILE); //Obtém o arquivo

       try {

           FileInputStream fis = new FileInputStream(file);   //necessário obter uma referência de FileInputStream para ter acesso ao método de leitura

           while((retorno = fis.read())!= -1){    //método read() retorna caractere por caractere do arquivo, quando o valor for -1 chegou-se no final do arquivo.

               texto.append((char) retorno);  //adiciona cada caractere ao StringBuffer

           }

           fis.close();

           Toast.makeText(getApplicationContext(),texto,Toast.LENGTH_SHORT).show();

       } catch (FileNotFoundException e) {

           e.printStackTrace();

       } catch (IOException e) {

           e.printStackTrace();

       }

   }else{

       Toast.makeText(getApplicationContext(),"não foi possível acessar",Toast.LENGTH_SHORT).show();

   }

   return texto.toString();  //retorna o texto que estava no arquivo

}//obter

}
