import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JavaActivity extends AppCompatActivity {
    private TextView textView_java;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java);
        textView_java = findViewById(R.id.textView_java);
        String msg = getIntent().getStringExtra("dados");
        textView_java.setText(msg);
    }//onCreate
}//class
