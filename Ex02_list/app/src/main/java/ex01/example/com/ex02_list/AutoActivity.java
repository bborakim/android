package ex01.example.com.ex02_list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

public class AutoActivity extends AppCompatActivity {

    TextView txtResult;
    AutoCompleteTextView auto1;
    String[] items={"java", "java2", "java3", "java4", "c", "c++", "visual c++", "android", "appel"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auto);

        txtResult=(TextView)findViewById(R.id.txtResult);
        auto1=(AutoCompleteTextView)findViewById(R.id.auto1);

        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, items);
        auto1.setAdapter(adapter);

        auto1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                txtResult.setText(items[position]);
            }
        });
    }
}
