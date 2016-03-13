package pvlinh.demo.mvcmodelapplication;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by Administrator on 12/03/2016.
 */
public class CustomListViewAdapter extends BaseAdapter{
    private ArrayList<Message> messageList;
    private LayoutInflater inflater;

    public CustomListViewAdapter(Context context, ArrayList<Message> messageList){
        this.messageList = messageList;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Log.i("TAG","size = "+messageList.size());
    }

    @Override
    public int getCount() {
        return messageList.size();
    }

    @Override
    public Message getItem(int position) {
        return messageList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        ViewHolder holder = new ViewHolder();

        if(convertView==null){
            vi = inflater.inflate(R.layout.item_layout, null);

            holder.tv = (TextView) vi.findViewById(R.id.tv);
            holder.btn = (Button) vi.findViewById(R.id.btn);

            vi.setTag( holder );
        }else {
            holder = (ViewHolder)convertView.getTag();
        }

        holder.tv.setText(getItem(position).getMessageContent());


        return vi;
    }
    public class ViewHolder
    {
        TextView tv;
        Button btn;
    }
}
