/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iface;

import java.util.Scanner;
import java.util.ArrayList;
public final class Profile {
	private String name;
	private String Gender;
	private String Civil_State;
	private int birth_day,birth_month,birth_year;
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setGender(String gender) {
		this.Gender = gender;
	}
	public String getGender() {
		return Gender;
	}
	public void setCivil_State (String civil_state) {
		this.Civil_State = civil_state ;
	}
	public String getCivil_State() {
		return Civil_State;
	}
	public void setBirth(int birth_day,int birth_month , int birth_year) {
		this.birth_day = birth_day ;
		this.birth_month = birth_month;
		this.birth_year = birth_year;
	}
        public int getDay() {
            return birth_day;
        }
        public int getMonth() {
            return birth_month;
        }
        public int getYear() {
            return birth_year;
        }
        public void edit_Profile(Scanner input) {
            System.out.println("Type 1 to change your name\n");
            System.out.println("type 2 to change your civil state");
            int decision = input.nextInt();
            input.nextLine();
            if(decision == 1) {
               setName(input.nextLine());
            }
            if(decision == 2) {
                setCivil_State(input.nextLine());
            }
        }
	public Profile (Scanner  input) {
            System.out.println("Type your name");
                setName(input.nextLine());
                System.out.println("Type your gender");
		setGender(input.nextLine());
                System.out.println("Type your  civil state");
		setCivil_State(input.nextLine());
                System.out.println("Tyoe your birth day , bith month and birth year");
		setBirth(input.nextInt(),input.nextInt(),input.nextInt());
		input.nextLine();
	}
}
