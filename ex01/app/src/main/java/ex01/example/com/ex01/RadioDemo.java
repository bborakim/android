package ex01.example.com.ex01;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class RadioDemo extends AppCompatActivity
        implements RadioGroup.OnCheckedChangeListener{
    //1. 변수 선언
    RadioButton rdoRed, rdoGreen, rdoBlue;
    RadioGroup radio1;
    View layout1;
    //View layout1; //linearlayout의 부모가 view 라서 이렇게 해도 괜찮음..(다형성)


    //control + enter
    //41번라인에서 호출되는 메서드
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.rdoRed:
                layout1.setBackgroundColor(Color.RED);
                break;
            case R.id.rdoGreen:
                layout1.setBackgroundColor(Color.GREEN);
                break;
            case R.id.rdoBlue:
                layout1.setBackgroundColor(Color.BLUE);
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.radio_demo);

        //2.레이아웃 xml 파일에 선언한 뷰와 위젯변수를 연결시켜주는 작업
        rdoRed=(RadioButton)findViewById(R.id.rdoRed);
        rdoGreen=(RadioButton)findViewById(R.id.rdoGreen);
        rdoBlue=(RadioButton)findViewById(R.id.rdoBlue);
        radio1=(RadioGroup)findViewById(R.id.radio1);
        layout1=findViewById(R.id.layout1);
        //layout1=findViewById(R.id.layout1);


        //3.이벤트 처리
        radio1.setOnCheckedChangeListener(this); //radio1그룹에 묶인 체크가 변경되면 this(현재 클래스에서 선언된
        //메서드의 onCheckedChange가 호출됨.
    }
}
