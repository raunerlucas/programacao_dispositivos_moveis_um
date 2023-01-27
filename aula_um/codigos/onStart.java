//a atividade está visível, porém não esta apta para atender as solicitações do usuário.
@Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "OnStart", Toast.LENGTH_SHORT).show();
    }
