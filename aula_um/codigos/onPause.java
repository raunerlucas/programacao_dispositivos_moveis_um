//método chamado quando activity não tem mais foco;
//a atividade não está mais em primeiro plano, mas ainda existe uma referência dela.
 @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "OnPause", Toast.LENGTH_SHORT).show();
    }
