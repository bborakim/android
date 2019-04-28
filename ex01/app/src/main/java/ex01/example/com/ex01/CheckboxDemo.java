package ex01.example.com.ex01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class CheckboxDemo extends AppCompatActivity {

    //1. 위젯 변수 선언
    CheckBox check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkbox_demo);

        //2.위젯 생성
        check =(CheckBox)findViewById(R.id.check);

        //3.이벤트 처리
        check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    check.setText("체크된 상태");
                }else{
                    check.setText("체크되지 않은 상태");
                }
            }
        });
    }
}
