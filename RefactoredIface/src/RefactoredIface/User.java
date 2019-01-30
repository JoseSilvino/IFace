/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RefactoredIface;

/**
 *
 * @author Neto
 */
import java.awt.Image;
import java.util.*;
import javax.swing.ImageIcon;
/**
 *
 * @author Neto
 */
public class User  {

    private String name;
    private String password;
    private String nickname;
    private final HashMap<String, User> friends;
    private final ArrayList<String> friend_req;
    private final Profile profile;
    private final ArrayList<Message> messages;
    public ImageIcon image = new ImageIcon((new ImageIcon(getClass().getResource("/Images/Huxley.png"))).getImage().getScaledInstance(220, 220, Image.SCALE_SMOOTH)) ;
    public String getUsername() {
        return nickname;
    }
      public HashMap getFriendsHash() {
        return friends;
    }
    public void setUsername(String nick) {
        this.nickname = nick;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * reads all the current users friend requests
     */
    public void read_req() {
        String s = "";
        int t = this.friend_req.size();
        for(int i = 1 ; i < t ; i++) {
            s = s + friend_req.get(i) +" "+i+"\n";
        }
        javax.swing.JOptionPane.showMessageDialog(null,s);
    }
    public String[] Req_Arr() {
        int t = friend_req.size();
        String[] to_ret = new String[t];
        
        for(int i = 0;i<t;i++) {
            to_ret[i] = friend_req.get(i);
        }
        if(t!=0) {
        return to_ret;
        }
        else {
            return new String[] {"You Don't Have New Requests"};
        }
    }
    public void sendReq(String i, HashMap<String,User> users) {
        users.get(i).friend_req.add(this.nickname);
    }
    public String getReq(int i) {
        return this.friend_req.get(i);
    }
    public void removeMessages(String nick) {
        int t = messages.size();
        for(int i = 0 ; i < t ; i ++) {
            if(messages.get(i).getSent_by().equals(nick)) {
                messages.remove(i);
            }
        }
    }
    public void remove_req(String nick) {
        int t = this.friend_req.size();
        for(int i = 0 ; i < t ; i++) {
            if(this.friend_req.get(i).equals(nick)) {
                this.friend_req.remove(i);
            }
        }
    }
    public void add_friend(String nick, HashMap<String,User> users) {
        boolean is = false;
        int t = this.friend_req.size();
        for(int i = 0 ; i < t; i++) {
            if(friend_req.get(i).equals(nick)) {
                is = true;
            }
        }
        if(is) {
        this.remove_req(nick);
        this.friends.put(nick, users.get(nick));
        users.get(nick).friends.put(this.nickname, this);
        }
    }
    public String getFriends() {
        return friends.toString();
    }
    public User getFriend(String i) {
        return friends.get(i);
    }
    public Profile getProfile() {
        return profile;
    }
    public void editProfile(Scanner input) {
        this.profile.edit(input);
    }

    public void sendMessageTo(String User_nick, String message) {
        Calendar today = Calendar.getInstance();
        this.messages.add(new Message(User_nick,message,today));
    }

    public Message [] MessagesFrom(String by) {
        int t = this.messages.size(),q = 0;
        for (int i = 0 ; i < t ; i++) {
            if(messages.get(i).getSent_by().equals(by)) {
                q ++;
            }
        }
        Message[] mes_by = new Message[q];
        for(int i = 0,j = 0 ; i < t ; i++) {
            if(messages.get(i).getSent_by().equals(by)) {
                mes_by[j] = messages.get(i);
                j++;
            }
        }
        return  mes_by;
    }

    public User searchFriend(String name) {
        return friends.get(name);
    }

    public String seeUser() {
        return "Begin : \nName: " + this.name + "\nNickname: " + this.nickname + "\n:Password: " + this.password + "\nProfile: \n" + this.profile + "\nEnd\n";

    }

    @Override
    public String toString() {
        return "Begin : \nName: " + this.name + "\nNickname: " + this.nickname + "\nProfile: " + this.profile + "\nEnd\n";
    }
    public User(String name, String password, String nickname ,String gender,String civil_state,int day,int month,int year ) {
        this.name = name;
        this.password = password;
        this.nickname = nickname;
        this.friends = new HashMap<>();
        this.friend_req = new ArrayList<>();
        this.profile = new Profile(gender,civil_state,day,month,year);
        this.messages = new ArrayList<>();
    }
}
