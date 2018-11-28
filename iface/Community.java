/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iface;

/**
 *
 * @author Neto
 */
import java.util.ArrayList;
public class Community {
    private String name;
    private String admin_id;
    private ArrayList <String> members;
    private String message;
    public ArrayList<String> getMembers() {
        return members;
    }
    public void setAdmin(String id) {
        this.admin_id = id;
    }
    public String getAdmin() {
        return admin_id;
    }
    public void setName (String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void AddToCom(int id,ArrayList <User> users) {
        this.members.add(users.get(id).getNick());
        users.get(id).getComs().add(this);
    }
    public void readMessage() {
        System.out.println(this.message);
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public int isMember(String nick) {
        int t = this.members.size();
        for(int i = 0;i<t;i++) {
            if(this.members.equals(nick)) {
                return i;
            }
        }
        return -1;
    }
    public Community (String admin,String name) {
        setAdmin(admin);
        setName(name);
        this.members = new ArrayList<>();
        this.members.add(admin);
    }
}
