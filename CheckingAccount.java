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
				this.getAccountReport();
			} //Account Report
			else if (menuResponse.equals("2")){
				System.out.println("Make Deposit");
				this.makeDeposit();
			} //Deposit
			else if (menuResponse.equals("3")){
				System.out.println("Make Withdrawal");
				this.makeWithdrawal();
			} //Withdrawal
			else {
				System.out.println("Please enter a valid input.");
			} //User is confused
		} //End while loop
	} //End start()

	public double getBalance(){
		return balance;
	} //End balance getter
	
	public void setBalance(double balance){
		this.balance = balance;
	} //End balance setter

	public int getAccountID(){
		return accountID;
	} //End accountID getter 
	
	public void setAccountID(int accountID){
		this.accountID = accountID;
	} //End accountID setter

	public String getBalanceString(){
		return String.format("$%.2f", balance);
	} //End formatted balance

	public void checkBalance(){
		String sBalance = getBalanceString();
		System.out.println("Current Balance: " + sBalance);
	} //End checkBalance

	public void getAccountReport(){
		System.out.println("Account ID: " + this.getAccountID());
		this.checkBalance();
	} //End getAccountReport()
	
	public double getDouble(){
		java.util.Scanner doubleInput = new java.util.Scanner(System.in);
		String sResult = doubleInput.nextLine();
		double result;
		try {
			result = Double.parseDouble(sResult);
		} catch(Exception e){
			System.out.println("Not a legal input. Changing to 0.");
			result = 0d;
		} 
		return result;
	} //End getDouble()
	
	public void makeDeposit(){
		System.out.print("Deposit Amount: ");
		double deposit = this.getDouble();
		this.balance += deposit;
		System.out.println("New Balance: " + this.getBalanceString());
	} //End makeDeposit()

	public void makeWithdrawal(){
		System.out.println("Withdrawal Amount: ");
		double withdrawal = this.getDouble();
		if(withdrawal >= this.getBalance()){
			System.out.println("Insufficient Funds");
		} 
		else {
			this.balance -= withdrawal; 
			System.out.println("New Balance: " + this.getBalanceString());
		} 
	} //End makeWithdrawal()

} //End class def

