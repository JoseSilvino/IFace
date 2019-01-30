/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RefactoredIface;
import java.util.*;

/**
 *
 * @author Neto
 */
public class RefactoredIface {

    /**
     *
     * @param users
     * @param nick
     * @return
     */
    public static User search(HashMap<String,User>users,String nick) {
        if(users.containsKey(nick)) {
        return users.get(nick);
        }
        return null;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LOGGUI nlg = new LOGGUI();
        nlg.setVisible(true);
}
}
