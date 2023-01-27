//a atividade não é mais visível ao usuário;
//nesta fase, na falta de recursos o sistema pode destruir a atividade. Portanto, é um bom lugar para realizar a persistência de dados.
 @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), "OnStop", Toast.LENGTH_SHORT).show();
    }
