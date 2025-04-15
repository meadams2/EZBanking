//Bank.java

import java.util.*;

class Bank implements HasMenu{
	class AdminList extends ArrayList<Admin>{};
	class CustomerList extends ArrayList<Customer>{};

	protected AdminList admins = new AdminList();
	protected CustomerList customers = new CustomerList();

	public static void main(String[] args){
		Bank synergyBank = new Bank();
	} //End main()

	public Bank(){
		this.loadSampleCustomers();
		this.loadSampleAdmin();
		this.start();
	} //End constructor
	
	public void loadSampleCustomers(){
		customers.add(new Customer("Alice", "0000"));
		customers.add(new Customer("Bob", "0000"));
		customers.add(new Customer("Cindy", "0000"));
	} //End loadSampleCustomers()

	public void loadSampleAdmin(){
		admins.add(new Admin("Andy", "0000"));
		admins.add(new Admin("Nolan", "0000"));
	} //End loadSampleAdmin()

	public String menu(){
		java.util.Scanner menuInput = new java.util.Scanner(System.in);
		String menuResponse;

		System.out.println("0) Exit");
		System.out.println("1) Administrator Login");
		System.out.println("2) Customer Login");
		System.out.print("Action: ");

		menuResponse = menuInput.nextLine();
		return menuResponse;
	} //End menu()

	public void start(){
		boolean keepGoing = true;
		
		while (keepGoing){
			String menuInput = this.menu();
			
			if(menuInput.equals("0")){
				System.out.println("Exiting.");
				keepGoing = false;
			} //Exit
			
			else if (menuInput.equals("1")){
				System.out.println("Logging in as admin.");
				this.loginAsAdmin();
			} //Admin login

			else if (menuInput.equals("2")){
				System.out.println("Logging in as customer.");
				this.loginAsCustomer();
			} //Customer login

			else{
				System.out.println("Invalid input.");
			} //Invalid input
		} //End while
	} //End start()

	public void loginAsAdmin(){
		java.util.Scanner adminInput = new java.util.Scanner(System.in);
		Admin currentAdmin = null;

		System.out.print("Username: ");
		String sUserName = adminInput.nextLine();
		
		System.out.print("PIN: ");
		String sPIN = adminInput.nextLine();

		Iterator<Admin> it = admins.iterator();
		Admin iterAdmin;
		boolean keepGoing = true;

		while(keepGoing){
			while(it.hasNext()){
				iterAdmin = it.next();
				if(iterAdmin.login(sUserName, sPIN)){
					currentAdmin = iterAdmin;
					this.adminStart(currentAdmin);
					keepGoing = false;
				} //User found
			} //End iterator

			if(currentAdmin == null){
				System.out.println("User not found.");
				keepGoing = false;
			} //User not found
		} //End while loop
	} //End loginAsAdmin()

	public void adminStart(Admin admin){
		boolean keepGoing = true;
		while(keepGoing){
			String menuResponse = admin.menu();
			if (menuResponse.equals("0")){
				System.out.println("Exiting to Bank Menu.");
				keepGoing = false;
			} //Exit

			else if(menuResponse.equals("1")){
				System.out.println("Viewing All Customer Reports");
				this.fullCustomerReport();
			} //Full Customer Report

			else if(menuResponse.equals("2")){
				System.out.println("Access Customer.");
				this.accessCustomer();
			} //Access Customer

			else if(menuResponse.equals("3")){
				System.out.println("Add Customer.");
			} //Add customer

			else if(menuResponse.equals("4")){
				System.out.println("Delete Cusotmer.");
			} //Delete customer

			else {
				System.out.println("Invalid input.");
			} //Invalid
		} //End while loop
	} //End adminStart()

	public void loginAsCustomer(){
		java.util.Scanner customerInput = new java.util.Scanner(System.in);
		Customer currentCustomer = null;

		System.out.print("Username: ");
		String sUsername = customerInput.nextLine();

		System.out.print("PIN: ");
		String sPIN = customerInput.nextLine();

		Iterator<Customer> it = customers.iterator();
		Customer iterCustomer;
		boolean keepGoing = true;
		while(keepGoing){
			while(it.hasNext()){
				iterCustomer = it.next();
				if(iterCustomer.login(sUsername, sPIN)){
					currentCustomer = iterCustomer;
					currentCustomer.start();
					keepGoing = false;
				} //User found
			} //End iterator

			if (currentCustomer == null){
				System.out.println("User not found.");
				keepGoing = false;
			} //User not found

		} //End while loop
	} //End loginAsCustomer()

	public void fullCustomerReport(){
		Iterator<Customer> it = customers.iterator();
		while(it.hasNext()){
			Customer currentCustomer = it.next();
			currentCustomer.getReport();
		} //Iterator
	} //End fullCustomerReport()
	
	public void accessCustomer(){
		java.util.Scanner accountInput = new java.util.Scanner(System.in);
		Customer currentCustomer = null;
		
		System.out.print("Client Username: ");
		String sUsername = accountInput.nextLine();

		Iterator<Customer> it = customers.iterator();
		Customer iterCustomer;
		
		boolean keepGoing = true;
		while(keepGoing){
			while(it.hasNext()){
				iterCustomer = it.next();
				if (sUsername ==iterCustomer.getUserName()){
					currentCustomer = iterCustomer;

} //End class def


