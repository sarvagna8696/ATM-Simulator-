# ATM-Simulator-
An ATM Simulator application built using Java and MySQL, designed to emulate the core functionalities of an Automated Teller Machine (ATM).

#Features
User Authentication: Secure login system using PIN-based authentication.
Account Management: Create new accounts and manage existing ones.
Transaction Processing: Perform deposits, withdrawals, and balance inquiries.
Transaction History: View detailed transaction history.
Graphical User Interface: User-friendly interface built with Java Swing.

#Technologies Used
Programming Language: Java
Database: MySQL
GUI Framework: Swing
Database Connectivity: JDBC

#Setup Instructions
Clone the repository:
sh
git clone https://github.com/sarvagna8696/ATM-Simulator.git
cd atm-simulator

#Setup the MySQL Database:
Create a new database in MySQL.
Use the provided SQL scripts to create necessary tables:

#sql

CREATE TABLE login(formno VARCHAR(20), CardNumber VARCHAR(100), PinNumber VARCHAR(20));
CREATE TABLE Bank(pinNumber VARCHAR(20), date VARCHAR(20), type VARCHAR(30), amount VARCHAR(30));
CREATE TABLE signupThree(formno VARCHAR(20), accountType VARCHAR(40), CardNumber VARCHAR(100), PinNumber VARCHAR(20), facility VARCHAR(100));


#Configure Database Connection:
Update the conn.java file with your MySQL database credentials.

#Compile and Run the Application:
sh
javac -d bin src/*.java
java -cp bin bank.MainClass

#Usage
Sign Up: Create a new account using the sign-up form.
Login: Use the assigned card number and PIN to log in.
Perform Transactions: Access various features like deposit, withdrawal, balance inquiry, and view transaction history.


#Contributing
Contributions are welcome! Please create a pull request or open an issue for any changes or suggestions.
