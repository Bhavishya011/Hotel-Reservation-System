# Hotel Reservation System 

A simple command-line based **Hotel Reservation System** built in Java using **JDBC** to connect to a MySQL database. This project allows hotel staff to manage room reservations by providing an interactive text-based interface.

---

##  Features

-  Reserve a room
-  View all current reservations
-  Placeholder for search functionality
-  Update a reservation
-  Delete a reservation
-  Exit the system with a graceful message

---

##  Exception Handling

This project is built with **full exception handling** to ensure robust behavior even during unexpected inputs or system issues.

###  Handled Scenarios

| Exception | Description |
|----------|-------------|
| `ClassNotFoundException` | Thrown when the MySQL JDBC driver is not found. |
| `SQLException` | Catches all DB-related issues: connection failure, invalid query, etc. |
| `InputMismatchException` | Prevents crashes when users enter non-numeric input for numeric fields. |
| `InterruptedException` | Handles system exit animation delays. |
| `RuntimeException` | Safeguards against uncaught input or logic errors during runtime. |

###  Defensive Programming Measures

- Scanner `.nextLine()` calls used smartly to **consume newlines** after `.nextInt()` inputs.
- Input validation using `hasNextInt()` (in earlier versions).
- Structured try-catch blocks around **every DB call** and risky input area.
- Graceful fallback messages such as `"Insertion Failed"` or `"Invalid Choice"` instead of abrupt crashes.

---

##  Database Schema

Table: `reservations`

| Column Name      | Data Type     | Description                          |
|------------------|---------------|--------------------------------------|
| reservation_id   | INT (PK, AI)  | Unique ID for each reservation       |
| guest_name       | VARCHAR(100)  | Full name of the guest               |
| contact_number   | INT           | Guest’s contact number               |
| room_number      | INT           | Room number being reserved           |
| reservation_date | TIMESTAMP     | Automatically generated on insert    |

###  SQL Setup

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
##  Getting Started

###  Prerequisites

- Java JDK 8+  
- MySQL Server (running on localhost)  
- IntelliJ IDEA / Eclipse (or any Java IDE)  
- MySQL JDBC Connector  

---

##  Setup Steps

1. **Clone the repository:**

```bash
git clone https://github.com/yourusername/hotel-reservation-system.git
cd hotel-reservation-system
Add the MySQL JDBC driver to your project's classpath.

You can download it from MySQL Connector/J

Update your database credentials in the Java file:

java
Copy
Edit
private static final String url = "jdbc:mysql://localhost:3306/hotel_db";
private static final String username = "root";
private static final String password = "yourpassword";
Compile and run the Java file:

bash
Copy
Edit
javac Hotel_Reservation_System.java
java Hotel_Reservation_System
📂 Project Structure
Copy
Edit
Hotel_Reservation_System/
├── Hotel_Reservation_System.java
└── README.md
🖥 Sample Output
markdown
Copy
Edit
Hotel Management System
1. Reserve a Room
2. Show Reservations
3. Search Room
4. Update Reservation
5. Delete Reservation
0. Exit
Enter Your Choice:
 Features
- Reserve a room

- Show all reservations

- Update a reservation

- Delete a reservation

 Full Exception Handling

 Continuous interaction via console menu

 Future Enhancements
 Implement room search and filtering

 Add date-range input and availability checking

 Admin login authentication

🖼 Develop GUI version using JavaFX/Swing

 Convert to web app using Spring Boot + JSP

🧑‍💻 Author
Bhavishya Jain
