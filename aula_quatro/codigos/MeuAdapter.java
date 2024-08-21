public class MeuAdapter extends BaseAdapter {
    private LayoutInflater inflater; //LayoutInflater é uma classe cuja responsabilidade é converter o layout XML em objetos View 
    private ArrayList<ItemLista> itens;

    public MeuAdapter(Context context,
                      ArrayList<ItemLista> itens)
    {
        this.itens = itens;
        inflater = LayoutInflater.from(context);
    }
 
    public int getCount() //retorna a quantidade de itens da lista a serem mostradas
    //o adapter usa esse int para saber quantas vezes o getView()será invocado.
    {

        return itens.size();
    }


    public ItemLista getItem(int position) //position corresponde a um índice da lista
    {
//retorna um item específico da lista que será mostrado.
        return itens.get(position);
    }


    public long getItemId(int position)
    {
//retorna um ID único que identifica o item da lista, geralmente corresponde ao índice (position) da lista
        return position;
    }

    public View getView(int position, View view, ViewGroup parent)
    // position - a posição do item na lista.
//view - referência de uma view já criada. 
//parent - o ViewGroup pai ao qual a view será adicionada.
    {
  //retorna uma view com as características do layout do item criado.
        ItemLista item = itens.get(position); 
        view = inflater.inflate(R.layout.item_lista, null);
//seta o conteúdo da view com os dados do item da lista.
        TextView texto = (TextView) view.findViewById(R.id.texto);
        texto.setText(item.getDados());
        ImageView imagem = (ImageView)view.findViewById(R.id.imagem);
        imagem.setImageResource(item.getImagem());

        return view;
    }
}
