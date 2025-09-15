🏦 Banking System – Java Project 💻

A simple Banking System desktop application built in Java (Swing GUI) that simulates core ATM functionalities such as user login, account management, and transactions, with MySQL database integration. 🔐💳

🚀 Overview

This project demonstrates how banking operations can be implemented with a desktop-based interface. It is designed with Java Swing for GUI, JDBC for database connectivity, and a SQL backend for secure storage and validation of user details.

✨ Features

🔑 Secure Login – Card number & PIN authentication.

📝 User Registration – Sign up for new accounts.

💸 Transaction Management – Deposit, withdrawal, and balance inquiry.

🔗 JDBC Connectivity – SQL database for user data and transactions.

🎨 Interactive GUI – Built with Java Swing components.

⚠️ Validation & Error Handling – Basic input checks and error messages.


🛠️ Requirements

☕ Java JDK 21 or higher

🐬 MySQL (or compatible SQL database)

🔌 JDBC Driver (for MySQL)

🛠️ IDE (IntelliJ IDEA, Eclipse) or command-line tools



📥 Setup & Installation

Clone the Repository

git clone https://github.com/Mayank1343/Banking-System-Java-.git

Import into IDE (IntelliJ/Eclipse) or open via command line.

Configure JDK – Ensure Java 21+ is set up.

Setup Database

Create a database and required tables. Example:

CREATE TABLE login (
    cardNumber VARCHAR(20) PRIMARY KEY,
    pin VARCHAR(20) NOT NULL
);


Update Connection Settings
In Conn.java, modify:

String url = "jdbc:mysql://localhost:3306/yourDatabase";
String user = "yourUsername";
String password = "yourPassword";


Resources Setup
Place banklogo.jpg inside the resources/ folder or project root.

Run Application
Start the program from Login.java.


🎮 Usage

Enter Card Number + PIN → Login 🏧

New user? → Click Sign Up 📝

Perform transactions: Deposit / Withdraw / Check Balance 💰


🗂️ Project Structure
Banking-System-Java/
│── Login.java          # Main login GUI
│── Conn.java           # Database connection handler
│── Transactions.java   # Transaction management GUI
│── signUpOne.java      # User registration GUI
│── /resources          # Bank logo & assets
│── /sql-scripts        # (Optional) DB setup scripts

📸 Screenshots

(Add UI screenshots here for better showcase 📷)


⚠️ Troubleshooting

✔️ Verify JDK installation & database connectivity

🖼️ Ensure images (e.g., banklogo.jpg) are in the correct folder

🛠️ Check class compilation (Conn, Transactions, signUpOne)

🐞 Use IDE console/logs to debug runtime issues


👤 Author

Mayank Sharma 🎓
