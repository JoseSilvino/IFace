/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iface;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Neto
 */
public class User {
        private ArrayList <String> requests ;
	private String login;
	private String password;
	private String nick;
	private Profile profile;
        private ArrayList <String> friends;
        private ArrayList <Message> messages;
        private ArrayList <Community> communitys;
        public void setPassword(String password) {
            this.password = password;
        }
	public String getPassword() {
		return password;
	}
	public Profile getProfile(){
		return profile;
	}
        public void setProfile(Scanner input) {
            this.profile = new Profile(input);
        }
	public String getLogin() {
		return login;
	}
        public ArrayList<Community> getComs() {
            return communitys;
        }
        public String getNick() {
            return nick;
        }
	public void edit_profile() {
		Scanner input = new Scanner(System.in);
		int decision = input.nextInt();
		input.nextLine();
		if(decision==1) {

		}
	}
        public void send_invite (ArrayList <User> users,int index) {
            if(index==-1) {
                System.out.printf("This user does'nt exist\n");
            }
            else {
            users.get(index).requests.add(this.nick);
            }
        }
        public void printCommunitys() {
            int t = this.communitys.size();
            for(int i =0;i<t;i++) {
                System.out.println(this.communitys.get(i).getName());
            }
        }
        public int find(ArrayList <User> users,String request) {
            int t = users.size();
            for(int i =0 ;i<t;i++) {
               if(users.get(i).nick.equals(request)) {
                   return i;
               }
            }
            return -1;
        }
        public void receive_invite(ArrayList <User> users) {
            Scanner input = new Scanner(System.in);
            int id,t = this.requests.size();
            if(t==0) {
                System.out.println("you don't have friend requests");
            }
            for(int i=0;i<t;i++) {
            System.out.printf("You accept be friend to %s ?\n 1 to accept 2 to reject\n",this.requests.get(i));
                id = find(users,this.requests.get(i));
                if(input.nextInt() == 1) {
                    System.out.printf("you added %s to your friends list\n",users.get(i).nick);
                this.friends.add(users.get(id).nick);
                users.get(id).friends.add(this.nick);
                }
                else {
                    this.requests.remove(id);
                }
            }
        }
	public boolean has(ArrayList <User> users,String search,String type) {
		int t = users.size();
		for(int i=0;i<t;i++) {
			if (((((users.get(i)).login).equals(search)&&type.equals("login")))||(users.get(i).nick.equals("nick"))&&type.equals("nick")) {
				return true;
			}
		}
		return false;
	}
	public User(ArrayList <User> users,String login,String password,String nick) {
		if(false==has(users,login,"login")) {
			this.login = login;
		}
		this.password = password; 
		if(false==has(users,nick,"nick")) {
		 this.nick = nick; 
                 this.friends = new ArrayList <> ();
                 this.requests = new ArrayList <> ();
		}
                Scanner input = new Scanner(System.in);
               this.profile = new Profile(input);
               this.messages = new ArrayList <>();
               this.communitys = new ArrayList<> ();
	}
    public void sendMessage(ArrayList<User> users, int id,String message) {
        User sent_to = users.get(id);
        sent_to.messages.add(new Message(message,this.nick,false));
    }
    public void readMessage() {
        int t = this.messages.size();
        for(int i =0 ; i<t;i++) {
            if(messages.get(i).getRead()==false) {
                System.out.printf("You have a new message from %s\n",this.messages.get(i).getSentBy());
                System.out.printf("%s\n",this.messages.get(i).getMessage());
                this.messages.get(i).setRead(true);
            }
        }
        System.out.println("Do you want to see all messages sent by an user?\n1 to see , 2 to not");
        Scanner input = new Scanner(System.in);
        int dec  = input.nextInt();
        input.nextLine();
        if(dec==1) {
            String nickname = input.nextLine();
            for(int i =0;i<t;i++) {
                if(this.messages.get(i).getSentBy().equals(nickname)) {
                    System.out.printf("%s\n", this.messages.get(i).getMessage());
                }
            }
            
        }
    }
    public void seeProfile(String name,ArrayList <User> users) {
        int t = users.size();
        User see = null;
        for(int i = 0 ;i<t;i++) {
            if(users.get(i).nick.equals(name)) {
                see = users.get(i);
                break;
            }
        }
        if(see!=null) {
        System.out.printf("Name : %s\n",see.profile.getName());
        System.out.printf("Gender : %s\n",see.profile.getGender());
        System.out.printf("Civil State : %s\n",see.profile.getCivil_State());
        System.out.printf("Birth Day : %d/%d/%d\n",see.profile.getDay(),see.profile.getMonth(),see.profile.getYear());
        this.printCommunitys();
        }
    }
    public void Find_To_Remove_Friends(String nick) {
    	int t = this.friends.size();
    	for(int  i=0;i<t;i++) {
    		if(nick.equals(this.friends.get(i))) {
    			this.friends.remove(i);
    		}
    	}
    }
    public void removeRequests(String nick) {
    	    	int t = this.requests.size();
    	for(int  i=0;i<t;i++) {
    		if(nick.equals(this.requests.get(i))) {
    			this.requests.remove(i);
    		}
    	}
    }
    public void removeFromCommunitys(String nick) {
        int t = this.communitys.size(),index;
        for(int i =0;i<t;i++) {
            index = (this.communitys.get(i).isMember(nick));
            if(index!=-1) {
                this.communitys.get(i).getMembers().remove(index);
            }
        }
    }
    public void remove(ArrayList<User> users, int index) {
    	int t = users.size();
    	for(int i =0;i>t;i++) {
    		users.get(i).Find_To_Remove_Friends(users.get(index).nick);
    		removeRequests(users.get(index).nick);
                removeFromCommunitys(users.get(index).nick);
    	}
        users.remove(index);
    
    }
    public void printC(String com_name) {
     int t =  this.communitys.size();
     for(int i = 0;i<t;i++) {
         if(this.communitys.get(i).getName().equals(com_name)) {
             this.communitys.get(i).readMessage();
         }
     }
    }

    void MessC(String com_name,Scanner input) {
             int t =  this.communitys.size();
     for(int i = 0;i<t;i++) {
         if(this.communitys.get(i).getName().equals(com_name)) {
             if(this.nick.equals(this.communitys.get(i).getAdmin()))
             System.out.println("Type your message");
             ((this.communitys).get(i)).setMessage(input.nextLine());
         }
     }
    }
}
