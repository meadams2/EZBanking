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
				//loginAsAdmin();
			} //Admin login

			else if (menuInput.equals("2")){
				System.out.println("Logging in as customer.");
				//loginAsCustomer();
			} //Customer login

			else{
				System.out.println("Invalid input.");
			} //Invalid input
		} //End while
	} //End start()

} //End class def


