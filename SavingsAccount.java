//SavingsAccount.java

import java.util.*;
import java.io.*;

class SavingsAccount extends CheckingAccount implements Serializable{
	private static final long serialVersionUID = 1L;
	private double interestRate;

	public static void main(String[] args){
		SavingsAccount account = new SavingsAccount(1000, 5);
		account.start();
	} //End main test harness

	public SavingsAccount(double balance, double interestRate){
		super(balance);
		this.interestRate = interestRate;
		this.accountID = this.makeAccountID();
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
