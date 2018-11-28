package iface;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Neto
 */
public class Message {
    private String message;
    private String sentBy;
    private boolean read;
    public void setMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
    public void setSentBy (String sent) {
        this.sentBy = sent;
    }
    public String getSentBy () {
        return sentBy;
    }
    public void setRead(boolean read) {
        this.read = read;
    }
    public boolean getRead() {
        return read;
    }
    public Message (String message,String sent,boolean read) {
        setMessage(message);
        setSentBy(sent);
        this.read = read;
    }
}
