//SavingsAccount.java

import java.util.*;

class SavingsAccount extends CheckingAccount{
	private double interestRate;

	public static void main(String[] args){
		SavingsAccount account = new SavingsAccount(100, 5, 240001);
		account.start();
	} //End main test harness

	public SavingsAccount(double balance, double interestRate, int accountID){
		super(balance, accountID);
		this.interestRate = interestRate;
	} //End constructor

	@Override
	public int makeAccountID(){
		java.util.Random rand = new java.util.Random();
		int accountID = 240000 + rand.nextInt(10000);
		return accountID;
	} 

	public void setInterestRate(double interestRate){
		this.interestRate = interestRate; 
	} //End interestRate setter

	public double getInterestRate(){
		return interestRate;
	} //End interestRate getter

	public void calcInterest(){
		double balance = this.getBalance();
		double interest = balance * (interestRate/100);
		this.setBalance(balance + interest);
	} //End calcInterest
} //End class def
