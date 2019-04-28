package ex01.example.com.ex02_list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ListArray extends AppCompatActivity {
    //1.변수 선언
    ListView list;
    Button button1;
    EditText edit1;
    List<String> items;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listarray);

        //2.뷰 연결
        list=(ListView)findViewById(R.id.list);
        edit1=(EditText)findViewById(R.id.edit1);
        button1=(Button)findViewById(R.id.button1);

        items=new ArrayList<>();
        items.add("사과");
        items.add("포도");
        items.add("파인애플");
        items.add("체리");
        items.add("자두");

        adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        list.setAdapter(adapter);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //EditText에 입력한 값 getText()까지 하면 Editable(string전단계임)
                String str=edit1.getText().toString();
                //Arraylist에 추가
                items.add(str);
                //목록이 갱신됨
                adapter.notifyDataSetChanged();
            }
        });
        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                //아이템을 리스트에서 제거
                items.remove(position);
                //리스트뷰가 갱신됨
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }
}
