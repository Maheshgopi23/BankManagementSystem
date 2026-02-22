# 🏦 Bank Management System

A desktop-based **Bank Management System** developed using **Java** and
**MySQL** that simulates basic banking operations such as account
creation, deposits, withdrawals, balance enquiry, and transaction
management.

This project provides a simple ATM-like interface to perform core
banking functionalities.

------------------------------------------------------------------------

## 📌 Features

-   User account registration
-   Secure login using account number & PIN
-   Deposit money
-   Withdraw money
-   Fast cash withdrawal
-   Balance enquiry
-   Mini statement view
-   PIN change functionality
-   Database-backed transaction storage

------------------------------------------------------------------------

## 🛠️ Technologies Used

-   **Java (Swing & AWT)** -- GUI development
-   **JDBC** -- Database connectivity
-   **MySQL** -- Database management
-   **NetBeans / Eclipse / IntelliJ IDEA** -- Recommended IDE
-   **XAMPP / MySQL Server** -- Database server

------------------------------------------------------------------------

## 📂 Project Structure

    BankManagementSystem/
    │
    ├── src/bank/management/system/
    │   ├── MainClass.java
    │   ├── Login.java
    │   ├── SignUp.java
    │   ├── SignUp2.java
    │   ├── SignUp3.java
    │   ├── Deposit.java
    │   ├── Withdrawl.java
    │   ├── FastCash.java
    │   ├── BalanceEnquiry.java
    │   ├── Mini.java
    │   ├── ChangePin.java
    │   └── Conn.java
    │
    ├── database.sql
    ├── screenshots/
    └── README.md

------------------------------------------------------------------------

## ⚙️ Setup Instructions

### 1️⃣ Clone the Repository

``` bash
git clone <your-repository-url>
```

### 2️⃣ Setup Database

1.  Start MySQL server.
2.  Create a database:

``` sql
CREATE DATABASE bankmanagementsystem;
```

3.  Import `database.sql` file into MySQL.

------------------------------------------------------------------------

### 3️⃣ Configure Database Connection

Update database credentials in:

    Conn.java

Example:

``` java
c = DriverManager.getConnection(
    "jdbc:mysql:///bankmanagementsystem",
    "root",
    "password"
);
```

------------------------------------------------------------------------

### 4️⃣ Run the Project

-   Open project in your IDE.
-   Run:

```{=html}
<!-- -->
```
    MainClass.java

------------------------------------------------------------------------

## 🖥️ Application Modules

  Module            Description
  ----------------- ----------------------
  Login             User authentication
  SignUp            Account registration
  Deposit           Add money
  Withdraw          Withdraw money
  Fast Cash         Quick withdrawal
  Mini Statement    Recent transactions
  Balance Enquiry   Account balance
  Change PIN        Update PIN

------------------------------------------------------------------------


## 🚀 Future Improvements

-   Online banking integration
-   Admin dashboard
-   Account transfer feature
-   Mobile/web interface
-   Transaction reports
-   Enhanced security

------------------------------------------------------------------------

## 👨‍💻 Author

**Mahesh**\
2026 Graduate\
Java Full Stack Developer (Aspirant)

------------------------------------------------------------------------

## 📄 License

This project is for educational and learning purposes.
