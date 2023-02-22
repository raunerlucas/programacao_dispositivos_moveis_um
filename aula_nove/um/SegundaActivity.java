import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class SegundaActivity extends AppCompatActivity
        implements AdapterView.OnItemClickListener {

    private TextView textViewNome;
    private String[] cores = {"Verde","Vermelha","Azul"};
    private ListView listViewCores;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        textViewNome = findViewById(R.id.textViewNome);
        listViewCores = findViewById(R.id.listViewCores);

        Intent intent = getIntent();
        String nome_usuario = intent.getStringExtra("nome_usuario");
        textViewNome.setText(nome_usuario);

        adapter = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_list_item_1,cores);
        listViewCores.setAdapter(adapter);
        listViewCores.setOnItemClickListener(this);
    }//onCreate

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String escolhido = cores[i];
        gravar(escolhido);
    }//onItemClick

    private void gravar(String escolhido) {
        SharedPreferences sharedPreferences =
                getSharedPreferences("dados",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("nome_usuario",textViewNome.getText().toString());
        editor.putString("cor_usuario",escolhido);
        boolean resposta = editor.commit();
        if(resposta){
            Intent intent = new Intent(this, TerceiraActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(this,"Não salvo", Toast.LENGTH_LONG).show();
        }
    }//gravar
}//class
