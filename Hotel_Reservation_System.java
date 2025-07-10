import java.sql.*;
import java.util.Scanner;

public class Hotel_Reservation_System {
    private static final String url = "jdbc:mysql://localhost:3306/hotel_db";
    private static final String username = "root";
    private static final String password = "abhay910";
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            while(true){
                Scanner sc = new Scanner(System.in);
                System.out.println();
                System.out.println("Hotel Management System");
                System.out.println("1. Reserve a Room");
                System.out.println("2. Show Reservations");
                System.out.println("3. Search Room");
                System.out.println("4. Update Reservation");
                System.out.println("5. Delete Reservation");
                System.out.println("0. Exit");
                System.out.print("Enter Your Choice: ");
                int choice = sc.nextInt();
                switch (choice){
                    case 1 :
                        reserveRoom(connection,sc);
                        break;
                    case 2 :
                        showReservation(connection);
                        break;
                    case 3 :
                        searchReservation(connection);
                        break;
                    case 4 :
                        updateReservation(sc,connection);
                        break;
                    case 5 :
                        deleteReservation(sc, connection);
                        break;
                    case 0 :
                        exit();
                        sc.close();
                        return;
                    default:
                        System.out.println("Invalid Choice");
                }
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void reserveRoom(Connection connection, Scanner sc) {
        System.out.println("Enter The details");
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Contact Number: ");
        int contact_no = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Room Number: ");
        int room_no = sc.nextInt();
        sc.nextLine(); // again consume newline if more inputs to come
        String query = "Insert Into reservations(guest_name, contact_number, room_number) values('"+ name +"', '"+ contact_no +"', '"+ room_no +"');";
        try{
            Statement stmt = connection.createStatement();
            int rowsAffected = stmt.executeUpdate(query);
            if(rowsAffected>0){
                System.out.println("Insertion Successfull");
            }
            else{
                System.out.println("Insertion Failed");

            }        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    private static void showReservation(Connection connection) {
        String query = "Select * from reservations;";
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("Current Reservation");
            System.out.printf("%-15s %-20s %-15s %-15s %-25s\n",
                    "Res_ID", "Guest_Name", "Contact_No", "Room_No", "Reservation_Date");
            System.out.println("--------------------------------------------------------------------------------------------");
            while(rs.next()){
                int res_id = rs.getInt("reservation_id");
                String guest_name = rs.getString("guest_name");
                int contact_number = rs.getInt("contact_number");
                int room_number = rs.getInt("room_number");
                String date = String.valueOf(rs.getTimestamp("reservation_date"));
                System.out.printf("%-15d %-20s %-15d %-15d %-25s\n",
                        res_id, guest_name, contact_number, room_number, date);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    private static void searchReservation(Connection connection) {

    }

    private static void updateReservation(Scanner sc , Connection connection) {
        System.out.println("Enter the Reservation id of Entry to be updated");
        int id = sc.nextInt();
        System.out.println("Enter The Updated details");
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Contact Number: ");
        int contact_no = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Room Number: ");
        int room_no = sc.nextInt();
        sc.nextLine();
        String query = "Update reservations set guest_name = '" + name +"', contact_number = '"+ contact_no +"', room_number = '"+ room_no +"' where reservation_id = '"+ id +"' ;";
        try {
            Statement stmt = connection.createStatement();
            int rowsAffected = stmt.executeUpdate(query);
            if (rowsAffected > 0) {
                System.out.println("Updation Successfull");
            } else {
                System.out.println("Update Failed");

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void deleteReservation(Scanner sc,Connection connection) {
        System.out.print("Enter the Reservation id of Entry to be Deleted: ");
        int id = sc.nextInt();
        System.out.println();
        String query = "Delete from reservations where reservation_id = '"+ id +"';";
        try {
            Statement stmt = connection.createStatement();
            int rowsAffected = stmt.executeUpdate(query);
            if (rowsAffected > 0) {
                System.out.println("Deletion Successfull");
            } else {
                System.out.println("Deletion Failed");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void exit() throws InterruptedException {
        int i=5;
        System.out.print("Exiting System");
        while(i!=0){
            System.out.print(".");
            Thread.sleep(450);
            i--;
        }
        System.out.println();
        System.out.println("Thank You for Using Hotel Reservation System");
    }
}
