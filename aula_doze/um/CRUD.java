import android.content.ContentValues;

import android.content.Context;

import android.database.Cursor;

import android.database.sqlite.SQLiteDatabase;


import com.google.android.material.bottomnavigation.BottomNavigationItemView;


import java.util.ArrayList;


public class CRUD {

   private Context context;


   public CRUD(Context context) {

       this.context = context;

   }


   public long adicionar(Pessoa p){

       SQLiteDatabase db = MainActivity.criarBanco(context)

               .getWritableDatabase();

       ContentValues values = new ContentValues();

       values.put(Banco.getNOME(), p.getNome());

       values.put(Banco.getTELEFONE(), p.getTelefone());

       long linhaID = db.insert(Banco.getBancoTabela(),

               null,values);

       db.close();

       return linhaID;

   }//adicionar


  public ArrayList<Pessoa> listar(){

       SQLiteDatabase db = MainActivity.criarBanco(context)

               .getReadableDatabase();

       ArrayList<Pessoa>dados = new ArrayList<>();

       String consulta = "SELECT * FROM "+Banco.getBancoTabela();

       Cursor cursor = db.rawQuery(consulta,null);

       while(cursor.moveToNext()){

           Pessoa p = new Pessoa();

           p.setId(Integer.parseInt(cursor.getString(0)));

           p.setNome(cursor.getString(1));

           p.setTelefone(cursor.getString(2));

           dados.add(p);

       }//while

      db.close();

       return dados;

  }//listar


   public int atualizar(Pessoa p){

       SQLiteDatabase db = MainActivity.criarBanco(context)

               .getWritableDatabase();

       ContentValues values = new ContentValues();

       values.put(Banco.getNOME(),p.getNome());

       values.put(Banco.getTELEFONE(),p.getTelefone());

       String where = Banco.getID()+"=?";

       String args[]={String.valueOf(p.getId())};

       int linhaID = db.update(Banco.getBancoTabela(),values,where,args);

       db.close();

       return linhaID;

   }//atualizar


   public int excluir(Pessoa p){

       SQLiteDatabase db = MainActivity.criarBanco(context)

               .getWritableDatabase();

       String where = Banco.getID()+"=?";

       String args[]={String.valueOf(p.getId())};

       int retorno = db.delete(Banco.getBancoTabela(),where,args);

       db.close();

       return retorno;

   }//excluir

}//class
