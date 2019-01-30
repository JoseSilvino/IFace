/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RefactoredIface;

import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import javax.swing.*;
/**
 *
 * @author INFOR
 */
public class Community {
    private HashMap<String,User> members;
    private HashMap<String,User>admins;
    private ImageIcon profileImg = new ImageIcon((new ImageIcon(getClass().getResource("/Images/Huxley.png"))).getImage().getScaledInstance(220, 220, Image.SCALE_SMOOTH)) ;
    private User main_admin;
    private String name;
    private ArrayList<Message> messages;
    

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public ImageIcon changeImage(URL path) {
        ImageIcon imageIcon = new ImageIcon(path);
        Image image = imageIcon.getImage();
        Image newImg = image.getScaledInstance(220, 220,Image.SCALE_SMOOTH);
        this.profileImg = imageIcon;
        imageIcon = new ImageIcon(newImg);
        return imageIcon;
    }
    public HashMap<String,User> getAdmins() {
        return admins;
    }
    public HashMap<String, User> getMembers() {
        return members;
    }
    public ImageIcon getProfileImg() {
        return profileImg;
    }
    public void addAdmin(User admin_new) {
        admins.put(admin_new.getUsername(),admin_new);
    }
    public void removeAdmin(String nick) {
        admins.remove(nick);
    }
    public void addMember(User member) {
        this.members.put(member.getUsername(),member);
    }
    public void RemoveMember(String nick) {
        this.members.remove(nick);
    }
    public boolean isMember(String name) {
        return members.containsKey(name);
    }
    public boolean isAdmin(String name) {
        return admins.containsKey(name);
    }
    public User getMain_admin() {
        return main_admin;
    }
    public void setMain_admin(User main_admin) {
        this.main_admin = main_admin;
    }
    public void setImage(ImageIcon profileImg) {
        this.profileImg = profileImg;
    }
    public void addMessage(Message mes) {
        this.messages.add(mes);
    }
    public Community(String name,User admin) {
        this.members = new HashMap<>();
        this.admins = new HashMap<>();
        this.members.put(admin.getUsername(),admin);
        this.admins.put(admin.getUsername(),admin);
        this.main_admin = admin;
        this.messages = new ArrayList<>();
    }
}
