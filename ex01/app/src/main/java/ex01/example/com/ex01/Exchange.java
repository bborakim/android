package ex01.example.com.ex01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Exchange extends AppCompatActivity {

    //1.위젯 전역변수 선언
    EditText dollar;
    Button button;
    TextView textResult;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //R : 리소스 저장 클래스
        setContentView(R.layout.exchange);
        //2.xml에 선언한 위젝과 연결시키는 코드
        dollar=(EditText)findViewById(R.id.dollar);
        button=(Button)findViewById(R.id.button);
        textResult=(TextView)findViewById(R.id.textResult);

        //3.이벤트 처리
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dollar.getText().toString().equals("")){
                    //잠깐 화면에 떴다가 없어지는 임시 팝업창
                    Toast.makeText(Exchange.this, "숫자를 입력하세요.",
                            Toast.LENGTH_LONG).show();
                            //Length_Long => 2-3초 , Length_short = 1-2초
                    return;
                }
                //EditText에 입력된 내용을 읽어 옴
                int intDollar
                        = Integer.parseInt(dollar.getText().toString());
                int money=intDollar*1100;

                //텍스트뷰의 내용 수정
                textResult.setText(intDollar+"달러 = " +money +"원입니다.");
            }
        });

    }
}
