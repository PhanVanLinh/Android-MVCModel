package pvlinh.demo.mvcmodelapplication;

/**
 * Created by Administrator on 12/03/2016.
 */
public class Message {
    private int messageId;
    private String messageContent;

    public Message(int messageId, String messageContent){
        this.messageId = messageId;
        this.messageContent = messageContent;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public String getMessageContent() {
        return messageContent;
    }
}
