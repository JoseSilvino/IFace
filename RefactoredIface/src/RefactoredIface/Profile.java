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
import java.util.*;
import java.text.*;
public class Profile {
    private String gender;
    private final Calendar birthday;
    private String civil_state;
    public void setState(String state) {
        this.civil_state = state;
    }
    public void edit(Scanner input) {
        System.out.println("What do you want to edit :");
        System.out.println("1 : Civil State\n"+"2 : Birth Day");
        int d = input.nextInt();
        input.nextLine();
        switch(d) {
            case 1:
                System.out.println("Type the changed State");
                this.civil_state = input.nextLine();
                break;
            case 2:
                System.out.println("Type the new birth day");
                setBirth_day(input);
                break;
        }
    }
    @Override
    public String toString() {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return "Gender : "+this.gender +"\nBirth day : "+ format.format(this.birthday.getTime())+"\nCivil State : "+this.civil_state;
    }
    public void setBirth_day(Scanner input) throws InputMismatchException {
        this.birthday.set(Calendar.DAY_OF_MONTH,input.nextInt());
        this.birthday.set(Calendar.MONTH,input.nextInt()-1);
        this.birthday.set(Calendar.YEAR,input.nextInt());
        input.nextLine();
    }
    public Profile(Scanner input) throws InputMismatchException {
        System.out.println("Type your gender");
        this.gender = input.nextLine();
        System.out.println("Type your civil state");
        this.civil_state = input.nextLine();
        System.out.println("Type your birthday");
        this.birthday = Calendar.getInstance();
        setBirth_day(input);
    }
    public Calendar getBirthDay() {
        return birthday;
    }
    public String getCivil_State() {
        return civil_state;
    }
    public Profile(String gender,String state,int day,int month,int year) {
        this.gender = gender;
        this.civil_state = state;
        this.birthday = Calendar.getInstance();
        this.birthday.set(Calendar.DAY_OF_MONTH,day);
        this.birthday.set(Calendar.MONTH,month-1);
        this.birthday.set(Calendar.YEAR,year);
    }
    public void setGender(String g) {
        this.gender = g;
    }
    public String getGender() {
        return gender;
    }
}
