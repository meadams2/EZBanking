//User.java

import java.util.*;

public abstract class User implements HasMenu{
	protected String userName = ""; 
       	protected String PIN = "";
	
	public User(){
		this.userName = "";
		this.PIN = "";
	 } //End constructor

	public User(String userName, String PIN){
		this.userName = userName;
		this.PIN = PIN;
	} //End dual parameter constructor

	public boolean login(){
		java.util.Scanner loginInput = new java.util.Scanner(System.in);
		boolean login;
		String sUsername;
		String sPIN;

		System.out.print("Username: ");
		sUsername = loginInput.nextLine();
		System.out.print("PIN: ");
		sPIN = loginInput.nextLine();

		if (sUsername.equalsIgnoreCase(this.userName)){
			if (sPIN.matches("^\\d{4}$")){
				if (sPIN.equals(this.PIN)){
					login = true;
					System.out.println("Login Successful.");
				} //Correct PIN

				else {
					System.out.println("Incorrect PIN.");
					login = false;
				} //Incorrect PIN
			} //PinLength condition

			else {
				System.out.println("PIN must be 4 digits.");
				login = false;
			} //Incorrect PIN length
		} //Correct Username
		else {
			login = false;
		} //Incorrect Username

		return login;
	} //End login()
	
	public boolean login(String userName, String PIN){
		boolean login; 
		if (userName.equals(this.userName)){
			if (PIN.equals(this.PIN)){
				login = true;
				System.out.println("Login Successful.");
			} //Correct PIN
			else {
				login = false;
			} //Incorrect PIN
		} //Correct userName
		else {
			login = false;
		} //Incorrect userName

		return login;
	} //End login(userName, PIN)

	public String menu(){
		java.util.Scanner menuInput = new java.util.Scanner(System.in);
		String menuResponse;

		System.out.println("0) Exit");
		System.out.println("1) Manage Checking");
		System.out.println("2) Manage Savings");
		System.out.println("3) Change PIN");
		System.out.print("Action: ");

		menuResponse = menuInput.nextLine();

		return menuResponse;
	} //End menu()

	public void setUserName(String userName){
		this.userName = userName;
	} //UserName setter

	public String getUserName(){
		return userName;
	} //userName getter

	public void setPIN(String sPIN){
		if (sPIN.matches("^\\d{4}$")){
			this.PIN = sPIN;
		} 
		else {
			System.out.println("PIN must be numeric with 4 digits. Changing PIN to 0000");
		} 
	} //PIN setter

	public String getPIN(){
		return PIN;
	} //PIN getter

	public abstract String getReport();
} //End class def
