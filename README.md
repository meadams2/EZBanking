# SynergyBank - A Banking Software

The goal of this project is to create a banking software with two separate user interfaces for the administrator and the customer. As with any bank, there are multiple administrators and multiple customers. 

# Use Case

There are two different users within this program: the administrator and the customer. 
- The administrator will have access to login, add customers, manage customer accounts, change their PIN, and apply interest.
- The customer will have access to login, deposit and/or withdrawal money from their account(s), and change their PIN.

# UML
![UML Diagram](main/SynergyBankUML.svg)

```
 class HasMenu {
        <<interface>>
        String menu()
        void start()
    }
```
HasMenu dictates that any class that implements HasMenu must include a menu() and start() method with a String and void return respectively. 
```
class CheckingAccount implements HasMenu{
        - String accountID
        - double balance
        + CheckingAccount()
        + void main()
        + String menu()
        + String start()
        + double getBalance()
        + double getBalanceString()
        + String getAccountID()
        + void setBalance(balance)
        + void checkBalance()
        - double getDouble()
        + String getAccountReport()
        + void makeDeposit()
        + void makeWithdrawal() 
        + void addAccount()
        + void delAccount()
    }
```
- menu() prints out a menu and gets a response.
- start() calls menu() and directs traffic accordingly.
- makeDeposit() asks for user input on how much to deposit and adds that amount to the balance.
- makeWithdrawal() asks for user input on how much to withdrawal and removes the amount from the balance if the withdrawal amount is less than or equal to the balance
- checkBalance() prints out the balance of the checking account as a nicely formatted string (getBalanceString()).
- Serialization will be added in the future.


# Technology/Implementation

This project will primarily use Java. 

# Milestones
- UML Approved
- CheckingAccount functional and tested in isolation
- SavingsAccount functional and tested in isolation
- User functional
- Customer functional and tested
- Admin functional and tested
- Bank functional and tested
- Serialization added
