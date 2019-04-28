package ex01.example.com.ex01;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class YutActivity extends AppCompatActivity {

    //1.변수 선언
    int[] imgYut ={R.drawable.yut_0, R.drawable.yut_1};
    String[] strYut={"윶","걸","개","도","모"};
    Button button1;
    View layout1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yut);

        //2.뷰와 위젲변수 연결 작업
        button1=(Button)findViewById(R.id.button1);
        final ImageView img1=(ImageView)findViewById(R.id.img1);
        final ImageView img2=(ImageView)findViewById(R.id.img2);
        final ImageView img3=(ImageView)findViewById(R.id.img3);
        final ImageView img4=(ImageView)findViewById(R.id.img4);
        final TextView txtResult=(TextView)findViewById(R.id.txtResult);
        final View layout1=findViewById(R.id.layout1);


        //3. 이벤트 처리
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //랜던으로 윶 앞뒷면 설정
                Random random = new Random();
                int n1 = random.nextInt(2); //0,1
                int n2 = random.nextInt(2);
                int n3 = random.nextInt(2);
                int n4 = random.nextInt(2);

                int sum = n1+ n2 + n3 + n4;

                //4. 결과값 출력
                img1.setImageResource(imgYut[n1]);
                img2.setImageResource(imgYut[n2]);
                img3.setImageResource(imgYut[n3]);
                img4.setImageResource(imgYut[n4]);
                txtResult.setText(strYut[sum]);

                if(txtResult.getText().toString().equals("모")){
                    layout1.setBackgroundColor(Color.BLUE);
                }else {
                    layout1.setBackgroundColor(Color.WHITE);
                }

            }
        });

    }
}
