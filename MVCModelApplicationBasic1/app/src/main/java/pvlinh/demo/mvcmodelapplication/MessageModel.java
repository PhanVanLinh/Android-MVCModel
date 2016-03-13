package pvlinh.demo.mvcmodelapplication;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by Administrator on 12/03/2016.
 */
public class MessageModel {
    private ArrayList<Message> messageList;
    public interface OnMessageChangedListener{
        public void onMessageChanged();
    }

    OnMessageChangedListener onMessageChangedListener;

    public MessageModel(){
        messageList = new ArrayList<Message>();
    }

    public void getCount(){
        return;
    }

    public void addMessage(Message message){
        if (onMessageChangedListener != null){
            onMessageChangedListener.onMessageChanged();
        }
        messageList.add(message);
    }

    public Message getMessage(int messageId){
        return messageList.get(messageId);
    }

    public ArrayList<Message> getMessageList() {
        return messageList;
    }

    public void setOnMessageChangedListener(OnMessageChangedListener onMessageChangedListener) {
        this.onMessageChangedListener = onMessageChangedListener;
    }
}
