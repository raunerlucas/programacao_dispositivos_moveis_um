package com.example.appprogressbar_spinner_radio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements AdapterView.OnItemSelectedListener {

    private EditText editTextNome;
    private RadioButton radioButtonR, radioButtonI;
    private Button button;
    private Spinner spinner;
    private ArrayAdapter<String> adapter;
    private String idades[] = {"20","30","40","50","60","70","80","90","100"};
    private ProgressBar progressBar;
    private TextView textViewResultado;
    private Estudante e;
    private int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextNome=findViewById(R.id.editTextNome);
        radioButtonR=findViewById(R.id.radioButtonR);
        radioButtonI=findViewById(R.id.radioButtonI);
        button=findViewById(R.id.button);
        spinner=findViewById(R.id.spinner);
        adapter=new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_1,idades);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        progressBar=findViewById(R.id.progressBar);
        textViewResultado=findViewById(R.id.textViewResultado);
    }

    private void executarProgressBar(){

        final Handler handler =  new Handler();
        progressBar.setVisibility(View.VISIBLE);
        i = progressBar.getProgress();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(i<100){
                    i = i+10;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(i);
                            if(i>=100){
                                textViewResultado.setText(e.toString());
                            }//if
                        }//run
                    });
                    try{
                        Thread.sleep(2000);
                    }catch (InterruptedException e){
                        System.out.println(e.getMessage());
                    }
                }
            }//run
        }).start();
    }//

    private String obterSituacao(){
        String s="";
        if(radioButtonR.isChecked()){
            s="regular";
        }
        if(radioButtonI.isChecked()){
            s="irregular";
        }
        return s;
    }//

    public void clicar(View v){
        if(e!=null){
            executarProgressBar();
        }
    }//

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            //adapterView refere-se ao spinner
            //view refere-se ao item do spinner. Cada item no spinner é uma view.
            //i o índice da lista de dados
            //l ID exclusivo do item que geralmente é o mesmo índice.
        int item = Integer.parseInt(idades[i]);
        e = new Estudante(editTextNome.getText().toString(),
                obterSituacao(),
                item);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        //acionado quando o spinner é limpo ou  a seleção é removida.
    }
}
