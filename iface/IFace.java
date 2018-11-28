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
public class IFace {
    public static int search(ArrayList <User> users,String nick) {
        int t = users.size();
        for(int i =0;i<t;i++) {
            if(users.get(i).getNick().equals(nick)) {
                return i;
            }
        }
        return -1;
    }
	public static void main(String[]args) {
		ArrayList <User> users = new ArrayList <> ();
		int decision;
		Scanner input = new Scanner(System.in);
            OUTER:
            while (true) {
                decision = input.nextInt();
                input.nextLine();
                switch (decision) {
                    case 1:
                        users.add(new User(users,input.nextLine(),input.nextLine(),input.nextLine()));
                        break;
                    case 2:
                        int errors =0;
                        System.out.println("Tell the Username");
                        String login =  input.nextLine();
                        int index = -1,t = users.size();
                        for (int i =0;i< t; i++) {
                            if(users.get(i).getLogin().equals(login)) {
                                index = i;
                            }
                        }   User user_loged = null;
                        if(index!=-1) {
                            while(errors<3) {
                                System.out.println("Tell me your password");
                                String password =  input.nextLine();
                                if(!password.equals(users.get(index).getPassword())) {
                                    System.out.printf("Wrong password\n");
                                    errors++;
                                    user_loged =null;
                                }
                                else {
                                    user_loged = users.get(index);
                                    break;
                                }
                            }
                            while(user_loged!=null) {
                                System.out.printf("Welcome %s\nWhat would you do ?\n1: edit profile\n2: send friend invite\n3:send message\n4: read messages\n5: enter community tab\n6:see an user's profile\n7:remove accoutn(can't be undone)\n",user_loged.getNick());
                                int new_decision = input.nextInt();
                                input.nextLine();
                                if(new_decision == 1) {
                                    user_loged.getProfile().edit_Profile(input);
                                }
                                else if(new_decision == 2) {
                                    System.out.println("You would send friend invite to ?");
                                    String nick = input.nextLine();
                                    user_loged.send_invite(users,search(users,nick));
                                }
                                else if(new_decision == 3) {
                                    System.out.println("You would send message to ?");
                                    String nick = input.nextLine();
                                    int id;
                                    id = search (users,nick);
                                    user_loged.sendMessage(users,id,input.nextLine());
                                }
                                else if(new_decision == 4) {
                                    user_loged.readMessage();
                                }
                                else if(new_decision == 5) {
                                    System.out.println("1: create community\n2: see al your communitys\n3:read community message");
                                    int com_decision = input.nextInt();
                                    input.nextLine();
                                    switch (com_decision) {
                                        case 1:
                                            System.out.println("Wich name would you give to your community ?");
                                            String community_name = input.nextLine();
                                            user_loged.getComs().add(new Community(user_loged.getNick(),community_name));
                                            break;
                                        case 2:
                                            user_loged.printCommunitys();
                                            break;
                                        case 3:
                                            System.out.println("Type the community name");
                                            String com_name = input.nextLine();
                                            user_loged.printC(com_name);
                                            break;
                                        case 4:
                                            System.out.println("Type the community name");
                                            String comname = input.nextLine();
                                            user_loged.MessC(comname,input);
                                            break;
                                        default:
                                            break;
                                    }
                                }
                                else if(new_decision == 6) {
                                    System.out.println("Type the nick of the user you want to see the profile");
                                    String name = input.nextLine();
                                    user_loged.seeProfile(name, users);
                                }
                                else if(new_decision == 7) {
                                    user_loged.remove(users,index);
                                }
                                else {
                                    user_loged = null;
                                }
                            }
                        }   break;
                    default:
                        break OUTER;
                }
            }
        }
}