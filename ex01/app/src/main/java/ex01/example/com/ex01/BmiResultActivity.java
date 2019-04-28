package ex01.example.com.ex01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BmiResultActivity extends AppCompatActivity {

    //결과 출력 변수 선언
    TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi_result);

        textResult=(TextView)findViewById(R.id.textResult);

        //앞 화면(BmiActivity)에서 넘어온 값을 읽어오기 위해 intent객체를 받아옴
        Intent intent=getIntent();
        BmiDTO dto=(BmiDTO)intent.getSerializableExtra("dto");
        String result=dto.getResult();
        String name = dto.getName();
        int age = dto.getAge();
        double height = dto.getHeight();
        double weight = dto.getWeight();
//        String result= intent.getStringExtra("result"); //스트링 변수
//        String name = intent.getStringExtra("name");
//        int age = intent.getIntExtra("age", 0);//정수 변수
//        double height = intent.getDoubleExtra("height",0);//실수
//        double weight = intent.getDoubleExtra("weight", 0);
        textResult.setText("이름 : " + name + "\n"
                +"나이 : " + age + "\n"
                +"신장 : " + height + "\n"
                +"체중 :" + weight + "\n"
                +"결과 : " + result);
    }
}
