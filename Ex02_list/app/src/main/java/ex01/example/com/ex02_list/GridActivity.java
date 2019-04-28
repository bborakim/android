package ex01.example.com.ex02_list;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class GridActivity extends AppCompatActivity {

    TextView txtResult;
    GridView grid1;
    String[] items={"사과", "포도", "바나나", "자두","귤","자몽","사과", "포도", "바나나", "자두","귤","자몽"
    ,"사과", "포도", "바나나", "자두","귤","자몽","사과", "포도", "바나나", "자두","귤","자몽"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid);

        txtResult=(TextView)findViewById(R.id.txtResult);
        grid1=(GridView)findViewById(R.id.grid1);
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, items);
        grid1.setAdapter(adapter);

        grid1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                txtResult.setText(items[position]);
                txtResult.setTextColor(Color.BLUE);
                txtResult.setTextSize(20);
            }
        });
    }
}
