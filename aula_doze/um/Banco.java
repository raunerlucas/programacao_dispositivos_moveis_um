import android.content.Context;

import android.database.sqlite.SQLiteDatabase;

import android.database.sqlite.SQLiteOpenHelper;


import androidx.annotation.Nullable;


public class Banco extends SQLiteOpenHelper {

   private static final int BANCO_VERSAO = 1;

   private static final String BANCO_NOME = "meu_banco";

   private static final String BANCO_TABELA = "contato";

   private static final String ID = "_id";

   private static final String NOME = "nome";

   private static final String TELEFONE = "telefone";


   private static final String CRIA_TABELA = "CREATE TABLE "+BANCO_TABELA +

           "("+ID +" INTEGER PRIMARY KEY AUTOINCREMENT, " +

           NOME+" TEXT, "+TELEFONE+" TEXT"+")";


   private static final String DELETA_TABELA = "DROP TABLE IF EXISTS "+

           BANCO_TABELA;


   public Banco(@Nullable Context context) {

       super(context, BANCO_NOME, null, BANCO_VERSAO);

   }


   @Override

   public void onCreate(SQLiteDatabase sqLiteDatabase) {

       sqLiteDatabase.execSQL(CRIA_TABELA);

   }


   @Override

   public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

       sqLiteDatabase.execSQL(DELETA_TABELA);

       onCreate(sqLiteDatabase);

   }



   public static int getBancoVersao() {

       return BANCO_VERSAO;

   }


   public static String getBancoNome() {

       return BANCO_NOME;

   }


   public static String getBancoTabela() {

       return BANCO_TABELA;

   }


   public static String getID() {

       return ID;

   }


   public static String getNOME() {

       return NOME;

   }


   public static String getTELEFONE() {

       return TELEFONE;

   }

}//class
