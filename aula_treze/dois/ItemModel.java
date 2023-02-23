public class ItemModel {

   private int imagem;

   private String texto;


   public ItemModel(int imagem, String texto) {

       this.imagem = imagem;

       this.texto = texto;

   }


   public int getImagem() {

       return imagem;

   }


   public void setImagem(int imagem) {

       this.imagem = imagem;

   }


   public String getTexto() {

       return texto;

   }


   public void setTexto(String texto) {

       this.texto = texto;

   }


   @Override

   public String toString() {

       return "ItemModal{" +

               "imagem=" + imagem +

               ", texto='" + texto + '\'' +

               '}';

   }

}
