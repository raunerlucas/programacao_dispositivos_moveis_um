public class MeuAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private ArrayList<ItemLista> itens;

    public MeuAdapter(Context context,
                      ArrayList<ItemLista> itens)
    {

        this.itens = itens;

        inflater = LayoutInflater.from(context);
    }

    public int getCount()
    {

        return itens.size();
    }


    public ItemLista getItem(int position)
    {

        return itens.get(position);
    }


    public long getItemId(int position)
    {

        return position;
    }

    public View getView(int position, View view, ViewGroup parent)
    {

        ItemLista item = itens.get(position);

        view = inflater.inflate(R.layout.item_lista, null);

        TextView texto = (TextView) view.findViewById(R.id.texto);
        texto.setText(item.getDados());

        ImageView imagem = (ImageView)view.findViewById(R.id.imagem);
        imagem.setImageResource(item.getImagem());

        return view;
    }
}
