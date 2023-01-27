//único método cuja a implementação é obrigatória;
//executado apenas uma única vez durante todo o ciclo da atividade;
//usado para configurações iniciais da atividade.

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(getApplicationContext(), "OnCreate", Toast.LENGTH_SHORT).show();
    }
