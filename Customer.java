//Customer.java

import java.util.*;

class Customer extends User {
	class CheckingAcctList extends ArrayList<CheckingAccount>{};
	class SavingsAcctList extends ArrayList<SavingsAccount>{};
	protected CheckingAcctList chAccounts = new CheckingAcctList();
	protected SavingsAcctList svAccounts = new SavingsAcctList();

	protected String userName;
	protected String PIN;

	public static void main(String[] args){
		Customer alice = new Customer("Alice", "0000");
		alice.start();
		//testing adminAccess()
	//	alice.adminAccess();
	} //End main test harness

	public Customer(){
		super("", "");
		this.userName = "";
		this.PIN = "";
		this.loadSampleChAccount();
		this.loadSampleSvAccount();
	} //End constructor

	public Customer(String userName, String sPIN){
		super(userName, sPIN);
		this.userName = userName;
		this.PIN = sPIN;
		this.loadSampleChAccount();
		this.loadSampleSvAccount();
	} //End dual parameter constructor

	@Override
	public String menu(){
		java.util.Scanner menuInput = new java.util.Scanner(System.in);
		String menuResponse;

		System.out.println("0) Exit");
		System.out.println("1) View All Account Balances");
		System.out.println("2) Access Checking");
		System.out.println("3) Access Savings");
		System.out.print("Action (0-3): ");

		menuResponse = menuInput.nextLine();

		return menuResponse;
	} //End menu()

	public void start(){
		boolean keepGoing = true;
		while (keepGoing){
			String menuInput = this.menu();
			if(menuInput.equals("0")){
				keepGoing = false;
			} //Exit
				
			else if(menuInput.equals("1")){
				System.out.println("View All Account Balances");
				this.getReport();
			} //View All Account
				
			else if(menuInput.equals("2")){
				System.out.println("Access Checking");
				this.accessChAccounts();
			} //Access Checking

			else if(menuInput.equals("3")){
				System.out.println("Access Savings");
				this.accessSvAccounts();
			} //Access Savings
			else {
				System.out.println("Invalid input.");
			} //Invalid input
		} //End while
	} //End start()	

	@Override
	public void getReport(){
		System.out.println("Username: " + this.getUserName());
		System.out.println("Checking Accounts: ");
		this.printChAccounts();
		System.out.println("");

		System.out.println("Savings Accounts: ");
		this.printSvAccounts();	
	}

	public void loadSampleChAccount(){
		chAccounts.add(new CheckingAccount(1000d));
		chAccounts.add(new CheckingAccount(1000d));
	} //loadSampleChAccount()

	public void loadSampleSvAccount(){
		svAccounts.add(new SavingsAccount(1000d, 5));
		svAccounts.add(new SavingsAccount(1000d, 5));
	} //loadSampleSvAccount()

	public void printChAccounts(){
		for(CheckingAccount currentAccount : chAccounts){
			currentAccount.getAccountReport();
		} //End for loop

		/*
		Iterator<CheckingAccount> it = chAccounts.iterator();
		CheckingAccount currentAccount = null;
		boolean keepGoing = true;
		while(keepGoing){
			while(it.hasNext()){
				currentAccount = it.next();
				currentAccount.getAccountReport();
			} //Iterator

			if(currentAccount == null){
				keepGoing = false;
			} //Patch?
		} //End while
		*/
	} //printChAccounts()

	public void printSvAccounts(){
		for(SavingsAccount currentAccount: svAccounts){
			currentAccount.getAccountReport();
		} //End for
		/*
		Iterator<SavingsAccount> it = svAccounts.iterator();
		SavingsAccount currentAccount = null;
		boolean keepGoing = true;
		while(keepGoing){
			while(it.hasNext()){
				currentAccount = it.next();
				currentAccount.getAccountReport();
			} //Iterator

			if(currentAccount == null){
				keepGoing = false;
			} //Patch?
		} //End while
		*/
	} //printSvAccounts()
	
	public void accessChAccounts(){
		this.printChAccounts();

		java.util.Scanner checkingInput = new java.util.Scanner(System.in);
	//	CheckingAccount currentAccount = null;
		
		System.out.print("Account Number: ");
		String sAccount = checkingInput.nextLine();
		int accountID = 0;	
		try {
			accountID = Integer.parseInt(sAccount);
		} catch (NumberFormatException e){
			e.printStackTrace();
			//Lets program die gracefully if user inputs a nonnumeric
		} 
		
		for(CheckingAccount currentAccount: chAccounts){
			if(accountID == currentAccount.getAccountID()){
				currentAccount.start();
			} 
		} //End for

		/*
		Iterator<CheckingAccount> it = chAccounts.iterator();
		CheckingAccount iterChecking;
		boolean keepGoing = true;
		while (keepGoing){
			while(it.hasNext()){
				iterChecking = it.next();
				if (accountID == iterChecking.getAccountID()){
					currentAccount = iterChecking;
					currentAccount.start();
					keepGoing = false;
				} //Account found
			} //End iterator
			if (currentAccount == null){
				System.out.println("Account not found.");
				keepGoing = false;
			} //Account not found
		} //End while loop
		*/
	} ///End accessChecking()

	public void accessSvAccounts(){
		this.printSvAccounts();

		java.util.Scanner savingInput = new java.util.Scanner(System.in);
	//	SavingsAccount currentAccount = null;

		System.out.print("Account Number: ");
		String sAccount = savingInput.nextLine();
		int accountID = 0;

		try {
			accountID = Integer.parseInt(sAccount);
		} catch (NumberFormatException e){
			e.printStackTrace();
		} //End exception handling 
		
		for(SavingsAccount currentAccount: svAccounts){
			if (accountID == currentAccount.getAccountID()){
				currentAccount.start();
			} 
		} //End for

		/*
		Iterator<SavingsAccount> it = svAccounts.iterator();
		SavingsAccount iterSavings;
		boolean keepGoing = true;

		while(keepGoing){
			while(it.hasNext()){
				iterSavings = it.next();
				if(accountID == iterSavings.getAccountID()){
					currentAccount = iterSavings;
					currentAccount.start();
					keepGoing = false;
				} //Account found
			} //End iterator

			if(currentAccount == null){
				System.out.println("Account not found.");
				keepGoing = false;
			} //Account not found
		} //End while loop
		*/
	} //End accessSavings()
	
	public String adminAccessMenu(){
		java.util.Scanner accessInput = new java.util.Scanner(System.in);
		String accessResponse;

		System.out.println("0) Exit");
		System.out.println("1) Print Full Account List");
		System.out.println("2) Apply Interest");
		System.out.println("3) Add Account");
		System.out.println("4) Delete Account");
		System.out.print("Action: ");

		accessResponse = accessInput.nextLine();
		return accessResponse;
	} //End adminAccessMenu()

	public void adminAccess(){
		boolean keepGoing = true;
		while(keepGoing){
			String accessResponse = this.adminAccessMenu();
			if(accessResponse.equals("0")){
				System.out.println("Exiting to Admin Menu.");
				keepGoing = false;
			} //Quit

			else if(accessResponse.equals("1")){
				this.getReport();
			} //Full Account List
			
			else if(accessResponse.equals("2")){
				this.applyInterest();
			} //Add interest

			else if(accessResponse.equals("3")){
				this.addAccount();
			} //Add account

			else if(accessResponse.equals("4")){
				this.delAccount();
			} //Del account
			
			else {
				System.out.println("Invalid input.");
			} //Invalid
		} //End while loop
	} //End adminAccess


	public void applyInterest(){
		for(SavingsAccount currentAccount: svAccounts){
			currentAccount.calcInterest();
			System.out.println("New Balance: " + currentAccount.getBalanceString());
		} //End for

		/*
		Iterator<SavingsAccount> it = svAccounts.iterator();
		SavingsAccount currentAccount = null;
		boolean keepGoing = true;
		
		while(keepGoing){
			while(it.hasNext()){
				currentAccount = it.next();
				currentAccount.calcInterest();
				System.out.println("New Balance: " + currentAccount.getBalanceString());
			} //Iterator

			if(currentAccount == null){
				keepGoing = false;
			} //Patch?
		} //End while
		*/
	} //End applyInterest()

	public void addAccount(){
		java.util.Scanner accountInput = new java.util.Scanner(System.in);
		String accountType;

		System.out.println("0) Checking");
		System.out.println("1) Savings");
		System.out.print("Account (0-1): ");
		
		accountType = accountInput.nextLine();

		if(accountType.equals("0")){
			chAccounts.add(new CheckingAccount(1000d));
			System.out.println("Account added.");
		} //Checking

		else if(accountType.equals("1")){
			svAccounts.add(new SavingsAccount(1000d, 5));
		} //Savings

		else{
			System.out.println("Invalid account type.");
		} //Invalid
	} //End addAccount()
	
	public void delAccount(){
		java.util.Scanner delInput = new java.util.Scanner(System.in);
		String accountType;

		System.out.println("0) Checking");
		System.out.println("1) Savings");
		System.out.print("Action: ");

		accountType = delInput.nextLine();
		if(accountType.equals("0")){
			this.delChecking();
		} //End delete checking

		if (accountType.equals("1")){
			this.delSaving();
		} //End delete saving
	} //End delAccount()
	
	public void delChecking(){
		java.util.Scanner accountInput = new java.util.Scanner(System.in);
		String sAccountID;

		this.printChAccounts();
		
		System.out.print("Account Number: ");
		sAccountID = accountInput.nextLine();
		int accountID = 0;

		try {
			accountID = Integer.parseInt(sAccountID);
		} catch (NumberFormatException e){
			e.printStackTrace();
		} //Exception handling
		
		Iterator<CheckingAccount> it = chAccounts.iterator();
	//	CheckingAccount iterChecking;
		CheckingAccount currentAccount = null;

		boolean keepGoing = true;
		while(keepGoing){
			while(it.hasNext()){
				currentAccount = it.next();
				if(accountID == currentAccount.getAccountID()){
					it.remove();
					this.printChAccounts();
					keepGoing = false; 
				} //Remove checking
			} //Iterator
			
			if(currentAccount == null){
				System.out.println("Account does not exist.");
				keepGoing = false;
			} //Account not found
		} //End while
		
	} //End delChecking()
	
	public void delSaving(){
		java.util.Scanner accountInput = new java.util.Scanner(System.in);
		String sAccountID;

		this.printSvAccounts();
		System.out.print("Account Number: ");
		sAccountID = accountInput.nextLine();
		int accountID = 0;

		try {
			accountID = Integer.parseInt(sAccountID);
		}  catch (NumberFormatException e){
			e.printStackTrace();
		} //Exception handling
		
		Iterator<SavingsAccount> it = svAccounts.iterator();
	//	SavingsAccount iterSaving;
		SavingsAccount currentAccount = null;

		boolean keepGoing = true;
		while(keepGoing){
			while(it.hasNext()){
				currentAccount = it.next();
				if(accountID == currentAccount.getAccountID()){
					it.remove();
					this.printSvAccounts();
					keepGoing = false;
				} //Remove Saving
			} //Iterator

			if(currentAccount == null){
				System.out.println("Account does not exist.");
				keepGoing = false;
			} //Account not found
		} //End while
	} //End delSaving()

} //End class def
