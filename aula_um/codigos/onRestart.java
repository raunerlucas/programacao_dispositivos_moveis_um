//a atividade sai do estado de interrompido e será reiniciada;
//em seguida, o sistema chama o método onStart().
 @Override
    protected void onRestart() {
        super.onStop();
        Toast.makeText(getApplicationContext(), "OnRestart", Toast.LENGTH_SHORT).show();
    }
