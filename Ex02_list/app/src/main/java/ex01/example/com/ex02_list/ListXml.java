package ex01.example.com.ex02_list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class ListXml extends AppCompatActivity {

    //1. 변수 선언
    TextView txtResult;
    ListView list;
    List<String> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.list2);

        txtResult=(TextView)findViewById(R.id.txtResult);
        list=(ListView)findViewById(R.id.list);
        //로컬 xml파일 내용을 읽어서 리스트뷰에 출력시킴
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,
                R.array.fruit, android.R.layout.simple_list_item_1);
        list.setAdapter(adapter);

        //xml에 저장된 내용을 ArrayList로 변환
        items= Arrays.asList(getResources().getStringArray(R.array.fruit));
        //리스트뷰의 세부 아이템 클릭 이벤트 처리
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                txtResult.setText(items.get(position));
            }
        });
    }
}
