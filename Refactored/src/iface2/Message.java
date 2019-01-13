/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iface2;

import java.util.Calendar;

/**
 *
 * @author Neto
 */
public class Message {
    private String message;
    private String sent_by;
    private java.util.Calendar time;
    private final java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyy HH:mm");
    public String getMessage() {
        return message;
    }

    public String getSent_by() {
        return sent_by;
    }

    public Calendar getTime() {
        return time;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSent_by(String sent_by) {
        this.sent_by = sent_by;
    }

    public void setTime(Calendar time) {
        this.time = time;
    }
    
    @Override
    public String toString() {
        return sent_by + " " + message + "\n"+ sdf.format(time.getTime());
    }
    public Message(String message, String sent_by, Calendar time  ) {
        this.message = message;
        this.sent_by = sent_by;
        this.time = time;
    }
    
}
