//CheckingAccount.java

import java.util.*;

class CheckingAccount implements HasMenu{
	private double balance;
//	private Random rnd = new Random();
//	Initially considered doing account numbers with Randomization...that has issues
	private int accountID;

	public static void main(String[] args){
		CheckingAccount c = new CheckingAccount();
		c.start();
	} //End main()

	public CheckingAccount(){
		this.balance = 1000d;
		this.accountID = this.makeAccountID();
		System.out.println("Account ID:" + this.accountID);

	//	private java.util.Random rnd. new java.util.Random();
	//	this.accountID = 1000 + rnd.nextInt(9000);
	} //End CheckingAccount()

	public CheckingAccount(double balance, int accountID){
		this.balance = balance;
		this.accountID = accountID;
	} //End CheckingAccount(balance, accountID)
	
	public int makeAccountID(){
		java.util.Random rand = new java.util.Random();
		int accountID = 190000 + rand.nextInt(10000);
		return accountID;
	} //End makeAccountID()

	public String menu(){
		java.util.Scanner menuInput = new java.util.Scanner(System.in);
		System.out.println("0) Exit");
		System.out.println("1) View Account Report");
		System.out.println("2) Make Deposit");
		System.out.println("3) Make Withdrawal");
		System.out.print("Action: ");

		String menuResponse = menuInput.nextLine();
		return menuResponse;
	} //End menu()

	public void start(){
		boolean keepGoing = true;
		while (keepGoing){
			String menuResponse = this.menu();
			if (menuResponse.equals("0")){
				keepGoing = false;
			} //End exit condition
			else if (menuResponse.equals("1")){
				System.out.println("Account Report");
			} //Account Report
			else if (menuResponse.equals("2")){
				System.out.println("Make Deposit");
			} //Deposit
			else if (menuResponse.equals("3")){
				System.out.println("Make Withdrawal");
			} //Withdrawal
			else {
				System.out.println("Please enter a valid input.");
			} //User is confused
		} //End while loop
	} //End start()
} //End class def
