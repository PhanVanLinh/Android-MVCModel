package pvlinh.demo.mvcmodelapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements  MessageModel.OnMessageChangedListener, View.OnClickListener{
    private MessageModel messageModel;
    private ListView listViewMessage;
    private Button btnAdd;
    private CustomListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messageModel = new MessageModel();
        messageModel.addMessage(new Message(1,"Hello"));
        messageModel.addMessage(new Message(1,"Viet Nam"));

        listViewMessage = (ListView) findViewById(R.id.lvMessage);
        btnAdd = (Button) findViewById(R.id.btnAdd);

        adapter = new CustomListViewAdapter(MainActivity.this, messageModel.getMessageList());
        listViewMessage.setAdapter(adapter);

        messageModel.setOnMessageChangedListener(this);
        btnAdd.setOnClickListener(this);
    }

    @Override
    public void onMessageChanged() {
        Log.i("TAG","list view invalidate");
       // listViewMessage.invalidate();
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAdd:
                Log.i("TAG","Add button click");
                messageModel.addMessage(new Message(13,"Message add successful"));
                break;
        }
    }
}
