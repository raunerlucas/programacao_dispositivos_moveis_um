import java.io.Serializable;


public class Pessoa implements Serializable {

   private int id;

   private String nome, telefone;


   public Pessoa(int id, String nome, String telefone) {

       this.id = id;

       this.nome = nome;

       this.telefone = telefone;

   }//


   public Pessoa() {

   }


   public int getId() {

       return id;

   }


   public void setId(int id) {

       this.id = id;

   }


   public String getNome() {

       return nome;

   }


   public void setNome(String nome) {

       this.nome = nome;

   }


   public String getTelefone() {

       return telefone;

   }


   public void setTelefone(String telefone) {

       this.telefone = telefone;

   }


   @Override

   public String toString() {

       return "Pessoa{" +

               "id=" + id +

               ", nome='" + nome + '\'' +

               ", telefone='" + telefone + '\'' +

               '}';

   }

}//class
