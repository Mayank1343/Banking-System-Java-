🏦 Banking System Java Project 💻

🚀 Overview
This project is a simple banking system desktop application developed in Java using Swing for the GUI. It simulates ATM functionalities such as user login, account management, and transactions with backend connectivity to a SQL database. 🔐💳

✨ Features
🔑 User login with card number and PIN authentication.
📝 User registration (sign up).
💸 Transaction management interface (deposit, withdrawal, balance inquiry).
🔗 JDBC connectivity with a SQL database to store and validate user data.
🎨 Responsive GUI built with Java Swing components.
⚠️ Basic error handling and validation.


🛠️ Requirements
☕ Java Development Kit (JDK) 21 or higher.
🐬 MySQL or compatible SQL database.
🔌 JDBC driver for database connectivity.
🛠️ IDE like IntelliJ IDEA, Eclipse, or command-line tools.


📥 Setup and Installation
Clone the repository:

bash
git clone https://github.com/Mayank1343/Banking-System-Java-.git
Import the project in your preferred Java IDE.

Ensure the required JDK is configured (version 21 recommended). ✅

Create a database and table structure to store user login details and transactions. Example table structure:

sql
CREATE TABLE login (
    cardNumber VARCHAR(20) PRIMARY KEY,
    pin VARCHAR(20) NOT NULL
);
Update the database connection settings in the Conn class (database URL, username, password). 🔧

Place banklogo.jpg inside the resources folder or project root so the app can load the logo. 🖼️

Build and run the Login class to start the application. ▶️


🎮 Usage
Enter your card number and PIN to login 🏧.
If you are a new user, click the "Sign Up" button to register 📝.
Perform banking operations like deposits, withdrawals, and checking balance 💰.

🗂️ Project Structure
Login.java - Main login GUI class.
Conn.java - Handles database connection.
Transactions.java - Transaction management GUI.
signUpOne.java - User registration GUI.
Resources folder - Contains the bank logo image and other assets.
SQL scripts (if any) for database setup.


📸 Screenshots
(Add screenshots here to showcase your app's UI)

⚠️ Troubleshooting
Ensure JDK and database connections are properly configured. ✔️
Verify the placement of resource files like images. 🖼️
Check that required classes (Conn, Transactions, signUpOne) exist and are compiled. 🛠️
Use IDE logs or terminal output for debugging. 🐞

👤 Author
Mayank Sharma 🎓
