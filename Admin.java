//Admin.java

import java.util.*;
import java.io.*;

class Admin extends User{
	private static final long serialVersionUID = 1L;

	public static void main(String[] args){
		Admin admin = new Admin();
		admin.menu();
		admin.getReport();
	} //End main

	public Admin(){
		super("admin", "0000");
	} //End constructor

	public Admin(String userName, String PIN){
		super(userName, PIN);
		this.userName = userName;
		this.PIN = PIN;
	} //End dual parameter constructor

	public String menu(){
		java.util.Scanner menuInput = new java.util.Scanner(System.in);
		String menuResponse;

		System.out.println("0) Exit");
		System.out.println("1) View All Customer Reports");
		System.out.println("2) Access Customer");
		System.out.println("3) Add Customer");
		System.out.println("4) Delete Customer");
		System.out.print("Action: ");

		menuResponse = menuInput.nextLine();
		return menuResponse;
	} //End menu()
 
	public void start(){
	} //End empty start

	public void getReport(){
		System.out.println("Username: " + this.userName);
		System.out.println("PIN: " + this.PIN);
	} //End getReport()
} //End class def

