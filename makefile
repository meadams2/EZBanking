Bank.class: Bank.java HasMenu.class Customer.class Admin.class
	javac -g Bank.java

Customer.class: Customer.java User.class CheckingAccount.class SavingsAccount.class
	javac -g Customer.java

Admin.class: Admin.java
	javac -g Admin.java

User.class: User.java HasMenu.class
	javac -g User.java

CheckingAccount.class: CheckingAccount.java HasMenu.class
	javac -g CheckingAccount.java

SavingsAccount.class: SavingsAccount.java CheckingAccount.class
	javac -g SavingsAccount.java

HasMenu.class: HasMenu.java
	javac -g HasMenu.java

run: Bank.class
	java Bank

testAdmin: Admin.class 
	java Admin

testCustomer: Customer.class
	java Customer

testChecking: CheckingAccount.class
	java CheckingAccount

testSavings: SavingsAccount.class
	java SavingsAccount

clean: 
	rm *.class

git: 
	git status
	git add .

