# Hotel Reservation System

A simple command-line based Hotel Reservation System built in Java using JDBC to connect to a MySQL database. This project allows hotel staff to manage room reservations via an interactive text-based interface.

---

## Features

- Reserve a room  
- View all current reservations  
- (Placeholder) Search functionality  
- Update an existing reservation  
- Delete a reservation  
- Exit with a graceful animation  

---

## Exception Handling

This project includes full exception handling to ensure robust and user-friendly execution during unexpected scenarios.

### Handled Scenarios

| Exception                | Description                                                     |
|--------------------------|-----------------------------------------------------------------|
| `ClassNotFoundException` | Thrown if the MySQL JDBC driver is not found                    |
| `SQLException`           | Handles all database issues: invalid queries, connection errors |
| `InputMismatchException` | Catches non-numeric input where numbers are expected            |
| `InterruptedException`   | Ensures smooth exit animation using `Thread.sleep()`            |
| `RuntimeException`       | General fallback for logic errors                               |

### Defensive Programming Measures

- `.nextLine()` used after `.nextInt()` to consume newline characters  
- Try-catch blocks around all I/O and DB operations  
- Friendly prompts and messages instead of crashes  
- Graceful menu loop to allow repeated interaction  

---

## Database Schema

**Table: `reservations`**

| Column Name      | Data Type     | Description                          |
|------------------|---------------|--------------------------------------|
| reservation_id   | INT (PK, AI)  | Unique ID for each reservation       |
| guest_name       | VARCHAR(100)  | Guest's full name                    |
| contact_number   | INT           | Guest’s contact number               |
| room_number      | INT           | Room number reserved                 |
| reservation_date | TIMESTAMP     | Automatically generated on insert    |

### SQL Setup

```sql
CREATE DATABASE hotel_db;
USE hotel_db;

CREATE TABLE reservations (
  reservation_id INT AUTO_INCREMENT PRIMARY KEY,
  guest_name VARCHAR(100),
  contact_number INT,
  room_number INT,
  reservation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```
Getting Started
Prerequisites
Java JDK 8 or above

MySQL Server (running locally)

IntelliJ IDEA / Eclipse (any Java IDE)

MySQL JDBC Driver

Setup Instructions
Clone this repository:
```
git clone https://github.com/yourusername/hotel-reservation-system.git
cd hotel-reservation-system
```
Add the JDBC Driver to your project’s classpath.

Configure database credentials in your Java file:
```
private static final String url = "jdbc:mysql://localhost:3306/hotel_db";
private static final String username = "root";
private static final String password = "yourpassword";
```
Compile and run the project:
```
javac Hotel_Reservation_System.java
java Hotel_Reservation_System
```
Project Structure
```
Hotel_Reservation_System/
├── Hotel_Reservation_System.java
└── README.md
```
Sample Console Output
```
Hotel Management System
1. Reserve a Room
2. Show Reservations
3. Search Room
4. Update Reservation
5. Delete Reservation
0. Exit
Enter Your Choice:
```
Future Enhancements
Implement full room search and filtering

Add availability checks and date-range inputs

Admin login authentication feature

Build GUI version using JavaFX or Swing

Migrate to web app using Spring Boot and JSP

## 
Author 

Bhavishya Jain
