package ex01.example.com.ex02_list;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class PhonebookActivity extends AppCompatActivity {

    TextView txtResult;
    ListView list;
    List<PhonebookDTO> items;
    Uri number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.list2);

        //뷰연결
        txtResult=(TextView)findViewById(R.id.txtResult);
        list=(ListView)findViewById(R.id.list);
        items=new ArrayList<>();
        items.add(new PhonebookDTO("김철수","010-0000-9000"));
        items.add(new PhonebookDTO("박철수","010-0111-9004"));
        items.add(new PhonebookDTO("이철수","010-0222-9003"));
        items.add(new PhonebookDTO("최철수","010-0033-9002"));
        items.add(new PhonebookDTO("정철수","010-0004-9001"));

        //커스텀 아답터(사용자정의 리스트뷰)
        MyAdapter adapter=new MyAdapter(this, R.layout.phonebook, items);
        list.setAdapter(adapter);
    }

    class MyAdapter extends ArrayAdapter<PhonebookDTO>{ //내부클래스
        //control+enter
        public MyAdapter(Context context, int resource, List<PhonebookDTO> objects) {
            super(context, resource, objects);
        }

        //child view 를 출력하는 코드
        @Override
        public View getView(int position, View convertView, ViewGroup parent) { //convertView는 여러개의 리스트 중에 하나
            View v = convertView; //직전에 출력된 뷰
            if(v==null) {//처음에만 뷰를 생성
                LayoutInflater li = (LayoutInflater) getLayoutInflater(); //layoutinflater는 뷰를 동적으로 생성하는 것임
                v = li.inflate(R.layout.phonebook, null);
            }
            final PhonebookDTO dto=items.get(position); //position에 해당하는 레코드;
            TextView txtName=(TextView)v.findViewById(R.id.txtName); //v는 child view를 의미함
            TextView txtTel=(TextView)v.findViewById(R.id.txtTel);
            txtName.setText(dto.getName());
            txtTel.setText(dto.getTel());

            //자식뷰를 클릭하면 전화걸기 실행
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Intent intent=new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + dto.getTel()));
//                    startActivity(intent); //6.0이상부터 권한이 바뀜
                    number=Uri.parse("tel:" + dto.getTel()); //Uri는 스트링을 URI형식으로 바꿔줌.
                    check();
                }
            });
            return v;
        }
    } //내부클래스 끝

    void check() {
        //전화걸기 권한을 사용자가 동의했는지 확인
        int check = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);
        if(check != PackageManager.PERMISSION_GRANTED) { //비동의 상태
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.CALL_PHONE}, 1); //동의화면 출력, 리퀘스트코드 1은 의미없는 숫자임.아래 캐이스 몇 코드와 맞으면됨
        }else { //동의 상태이면 전화걸기 실행
            Intent intent=new Intent(Intent.ACTION_CALL, Uri.parse("tel:" +number));
            startActivity(intent);
        }
    }

    //사용자가 해당 권한을 동의, 거부 처리한 후 실행되는 코드

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case 1:
                if(grantResults.length > 0 &&
                        grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    check();
                }
                break;
        }
    }
}

