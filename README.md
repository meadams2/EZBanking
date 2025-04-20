# SynergyBank - A Banking Software

The goal of this project is to create a banking software with two separate user interfaces for the administrator and the customer. As with any bank, there are multiple administrators and multiple customers. 

# Use Case

There are two different users within this program: the administrator and the customer. 
- The administrator will have access to login, add customers, manage customer accounts, and apply interest. At this point, administrators can't change their PIN (for ease of testing and my sanity). Will possibly implement changePIN() in admin class in the future. 
- The customer will have access to login, deposit and/or withdrawal money from their account(s), and change their PIN.

# Testing

When testing the Bank, you will have the option to login as an administrator or as a customer. 

Customer Login
```
Username: Alice
PIN: 0000
```
Administrator Login
```
Username: Andy
PIN: 0000
```
OR
```
Username: Nolan
PIN: 0000
```
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
- addAccount() adds an account with a randomly generated 4 digit ID
- delAccount() deletes the account after displaying a warning message. 
- Serialization will be added in the future.

```
class SavingsAccount extends CheckingAccount{
        - String accountID
        - double balance
        - double interestRate
        + SavingsAccount()
        + void main()
        + void calcInterest()
        + void setInterestRate()
        + void getInterestRate()
    }
```
- Has many of the same methods and data members as CheckingAccount
- addAccount() and delAccount() may need to be overwritten
- calcInterest() calculates the interest based on the interest rate
- Standard getter and setter for interestRate

```
class User implements HasMenu, Serializable{
        <<Abstract>>
        -String userName
        -String PIN
        + boolean login()
        + boolean login(userName, PIN)
        + void setUserName(userName)
        + String getUserName()
        + void setPIN(PIN)
        + String getPIN()
        + String getReport()*
    }
```
- login() takes no parameters and instead asks the user for their userName and PIN. If both the userName and PIN are correct, login() returns true. This method will be primarily used the Customer class testing harness.
- login(userName, PIN) takes two parameters. If userName and PIN are correct, login(userName, PIN) returns true. This method is used in the Bank loginAsCustomer() method.
- Standard getters and setters for userName and PIN.
- getReport() is an abstract method that will be implemented in Customer and Admin classes.
- Will implement default menu(). Menu() can be empty
- Will implement default start(). Start() can be empty.
- Will be serializable

```
class Admin extends User{
        + Admin()
        + String menu()
        + String start()
        + String getReport()
    }
```
- start() is an empty method that is actually implemented in Bank
- String getReport() gets all the account information (userName and PIN) for the admin

```
class Customer extends User{
        - arraylist checkingAccts 
        - arraylist savingAccts
        + main()
        + Customer()
        + void start()
        + String menu()
        + void changePIN()
        + String getFullChAccountList()
        + String getFullSAccountList()
        + void accessChAccount(accountID)
        + void accessSAccount(accountID)
        + String getReport()
    }
```
- main() acts as a testing harness for testing in isolation of the Bank
- menu() calls the menu() method and returns a String response from the user
- start() acts as a traffic controller and directs the user to different utilities in the interface.
- changePIN() allows the user to change their PIN and accounts for illegal PINs
- getFullChAccountList() allows the user to view all their accounts with the accountID and balance
- accessChAccount(accountID) calls Checking Account start() for the respective checking account. 
- accessSAccount(accountID) calls Savings Account start() for the respective savings account.
- getReport() gets a string of the userName, fullCheckingAcctList, and fullSavingsAccountList
- Will be serializable

```
class Bank{
        - arraylist admins
        - arraylist customers
        + Bank()
        + main()
        + void loadDefaultAdmin()
        + void loadAdmin()
        + void saveAdmin()
        + void loadSampleCustomers()
        + void loadCustomers()
        + void saveCustomers()
        + void fullCustomerReport()
        + void addCustomer()
        + void addAdmin()
        + void applyInterest()
        + void loginAsCustomer()
        + void menu() 
        + void start()
        + void startAdmin()
    }
```
- main() acts as a wrapper for the Bank constructor.
- Bank() initializes data members and calls start()
- start() acts as traffic controller
- fullCustomerReport() prints the getReport() method for all customers
- addCustomer() adds a customer to the list of Customers
- addAdmin() adds an admin to the list of admins
- Will implement serializable

# Sample Menus
## Checking Account & Savings Account
```
0) Exit
1) View Account Report
2) Make deposit
3) Make withdrawal
```
## Customer
```
0) Exit
1) View All Account Balances
3) Access Checking
4) Access Savings
```
## Admin
```
0) Exit
1) View all Customer Reports
2) Access Customer
3) Apply Interest
4) Add Customer
5) Delete Customer
```

Potentially could contain a second menu with Access Customer option: 

```
0) Exit
1) Print Full Account List
2) Add Account
3) Delete Account
```
## Bank
```
0) Exit
1) Administrator Login
2) Customer Login
```

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

# Additions/Changes to UML

- Added makeAccountID() to CheckingAccount class and SavingsAccount class. 
- getReport() methods inside classes are void and instead print the report because the only instance they are used within the bank is when printing off the data members in a report style. This method could change as needs arise. 
- Added printChAccounts to Customer class for ease of getReport()
- Added printSvAccounts to Customer class for ease of getReport()
- Added accessCustomer() to Bank class. Has admin enter a username--if username is a Customer username, calls adminAccess() within Customer class.
- adminAccess() calls adminAccessMenu() and directs traffic accordingly. 
- At this time, admin has to manually apply interest for each customer. Interest is applied to all Savings Accounts for the Customer, but not to all customers.
- Bank constructor--added condition to make loadSampleCustomers() and loadSampleAdmin() only run when customers.dat and admins.dat is empty.
- Added changePIN() in Customer class.
