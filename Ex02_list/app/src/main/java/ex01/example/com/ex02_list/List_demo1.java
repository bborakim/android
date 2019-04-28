package ex01.example.com.ex02_list;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class List_demo1 extends ListActivity {
    //1.위젯의 전역 변수 선언
    TextView txtResult;
    String[] items={"사과", "포도", "레몬", "수박", "바나나", "체리"};

    //control+enter
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Log.i("test", "position :" + position); //단순정보(i)
        txtResult.setText("좋아하는 과일 : "+items[position]);//position 첫번째는 0, 두번째는 1 이런식임..
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //2.레이아웃 xml파일 설정
        setContentView(R.layout.list_demo1);

        //3.뷰연결
        txtResult=(TextView)findViewById(R.id.txtResult);

        //4.아답터 생성(배열의 데이터 각각을 리스트뷰에 출력시키는 코드)
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, items);
        //ListActivity를 상속받아야함
        setListAdapter(adapter);

    }
}
