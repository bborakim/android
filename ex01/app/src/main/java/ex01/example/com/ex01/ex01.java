package ex01.example.com.ex01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class ex01 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //화면 레이아웃 파일 정의
        // R : Resource
        setContentView(R.layout.activity_ex01);
    }

    //버튼을 클릭할 때 호출되는 메서드
    public void mOnClick(View v){
        Intent intent=null;
        switch (v.getId()){
            case R.id.button1:
                intent=new Intent(this, ImageViewDemo.class);
                break;
            case R.id.button2:
                intent=new Intent(this, Exchange.class);
                break;
            case R.id.button3:
                intent=new Intent(this, BmiActivity.class);
                break;
            case R.id.button4:
                intent=new Intent(this, CheckboxDemo.class);
                break;
            case R.id.button5:
                intent=new Intent(this,RadioDemo.class);
                break;
            case R.id.button6:
                intent=new Intent(this,YutActivity.class);
                break;

            case R.id.button7:
                intent=new Intent(this,ScrollActivity.class);
                break;
        }
        startActivity(intent);
    }
}
