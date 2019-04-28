package ex01.example.com.ex02_list;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Button button1 = (Button)findViewById(R.id.button1);
//        button1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(MainActivity.this, List_demo1.class);
//                startActivity(intent);
//            }
//        });
    }

    public void onClick(View v){
        Intent intent= null;
        switch (v.getId()){
            case R.id.button1:
                intent=new Intent(this, List_demo1.class);
                break;
            case R.id.button2:
                intent=new Intent(this, ListDemo2.class);
                break;
            case R.id.button3:
                intent=new Intent(this, ListXml.class);
                break;
            case R.id.button4:
                intent=new Intent(this, ListArray.class);
                break;
            case R.id.button5:
                intent=new Intent(this, PhonebookActivity.class);
                break;
            case R.id.button6:
                intent=new Intent(this, SpinnerActivity.class);
                break;
            case R.id.button7:
                intent=new Intent(this, GridActivity.class);
                break;
            case R.id.button8:
                intent=new Intent(this, AutoActivity.class);
                break;
        }
        startActivity(intent);
    }
}
