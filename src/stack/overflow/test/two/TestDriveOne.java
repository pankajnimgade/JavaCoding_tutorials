package stack.overflow.test.two;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Pankaj Nimgade on 14-02-2016.
 */
public class TestDriveOne {

    public static void main(String[] args) {
        QueuedMessage queuedMessage = new QueuedMessage("123", "Hello World");
        System.out.println((new Gson()).toJson(queuedMessage));
    }


}

class QueuedMessage {

    @SerializedName("message_id")
    private String id;

    @SerializedName("message")
    private String msg;

    public QueuedMessage() {
    }

    public QueuedMessage(String id, String msg) {
        this.id = id;
        this.msg = msg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
