//método chamado quando uma interrupção ocorrer;
//a atividade não está mais em primeiro plano, mas ainda existe uma referência dela.
 @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "OnPause", Toast.LENGTH_SHORT).show();
    }
