package ex01.example.com.ex02_list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ListDemo2 extends AppCompatActivity {

    //1.변수선언
    TextView txtResult;
    ListView list;
    String[] items={"TV", "냉장고", "세탁기", "오디오", "스마트폰"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list2);

        //2. 리소스 연결
        txtResult=(TextView)findViewById(R.id.txtResult);
        list=(ListView)findViewById(R.id.list);

        //3.아답터 생성
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, items);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                txtResult.setText(items[position]);
            }
        });
    }
}
