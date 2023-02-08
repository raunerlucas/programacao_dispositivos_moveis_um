public class MainActivity3 extends AppCompatActivity
        implements
        AdapterView.OnItemClickListener {

    private ListView listView;
    private MeuAdapter meuAdapter;
    private ArrayList<ItemLista> itens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView = (ListView) findViewById(R.id.lista);

        listView.setOnItemClickListener(this);

        criarLista();
    }


    private void criarLista()
        {

            itens = new ArrayList<ItemLista>();
            ItemLista item1 = new ItemLista("bolo",
                    R.drawable.bolo);
            ItemLista item2 = new ItemLista("pão",
                    R.drawable.pao);
            ItemLista item3 = new ItemLista("torta",
                    R.drawable.torta);

            itens.add(item1);
            itens.add(item2);
            itens.add(item3);

            meuAdapter = new MeuAdapter(this, itens);
            listView.setAdapter(meuAdapter);


        }

        public void onItemClick(AdapterView<?> arg0,
                                View arg1, int arg2, long arg3)
        {
            ItemLista item = meuAdapter.getItem(arg2);

            Toast.makeText(this, "Você Clicou em: "
                            + item.getDados(),
                    Toast.LENGTH_LONG).show();
        }

}
