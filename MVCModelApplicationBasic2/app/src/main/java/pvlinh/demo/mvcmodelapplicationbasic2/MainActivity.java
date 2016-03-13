package pvlinh.demo.mvcmodelapplicationbasic2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity implements Observer,View.OnClickListener{
    private Button btn1,btn2,btn3;
    private Model mModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mModel = new Model();
        mModel.addObserver(this);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn1:
                mModel.setValueAtIndex(0);
                break;
            case R.id.btn2:
                mModel.setValueAtIndex(1);
                break;
            case R.id.btn3:
                mModel.setValueAtIndex(2);
                break;
        }
    }

    @Override
    public void update(Observable observable, Object data) {
        btn1.setText(""+mModel.getValueAtIndex(0));
        btn2.setText(""+mModel.getValueAtIndex(1));
        btn3.setText(""+mModel.getValueAtIndex(2));
    }
}
