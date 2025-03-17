//Write a menu-driven program (Command Line Interface) to perform the following operations on the student table:**
1. Insert
2. Modify
3. Delete
4. Search
5. View All
6. Exit



import java.sql.*;
import java.util.*;

class AssB1 {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            Connection cn = null;
            PreparedStatement pstmt;
            ResultSet rs;
            String name;
            String sql;
            int roll, percentage, ch;
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "root");
            pstmt = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            do {
                System.out.println("Enter 1: INSERT");
                System.out.println("Enter 2: MODIFY");
                System.out.println("Enter 3: DELETE");
                System.out.println("Enter 4: SEARCH");
                System.out.println("Enter 5: VIEW ALL");
                System.out.println("Enter 6: EXIT");
                System.out.println("Enter your choice:");
                ch = sc.nextInt();

                switch (ch) {
                    case 1:
                        System.out.println("Enter Roll to insert:");
                        roll = sc.nextInt();
                        System.out.println("Enter Name to insert:");
                        name = sc.next();
                        System.out.println("Enter Percentage to insert:");
                        percentage = sc.nextInt();
                        sql = "INSERT INTO stud VALUES (" + roll + ", '" + name + "', " + percentage + ")";
                        pstmt = cn.prepareStatement(sql);
                        pstmt.execute();
                        pstmt.close();
                        break;

                    case 2:
                        System.out.println("Enter Roll to update:");
                        roll = sc.nextInt();
                        System.out.println("Enter new Name:");
                        name = sc.next();
                        System.out.println("Enter new Percentage:");
                        percentage = sc.nextInt();
                        sql = "UPDATE stud SET name = '" + name + "', percentage = " + percentage + " WHERE roll = " + roll;
                        pstmt = cn.prepareStatement(sql);
                        pstmt.execute();
                        pstmt.close();
                        break;

                    case 3:
                        System.out.println("Enter Roll to delete:");
                        roll = sc.nextInt();
                        sql = "DELETE FROM stud WHERE roll = " + roll;
                        pstmt = cn.prepareStatement(sql);
                        pstmt.execute();
                        pstmt.close();
                        break;

                    case 4:
                        System.out.println("Enter Roll to search:");
                        roll = sc.nextInt();
                        rs = pstmt.executeQuery("SELECT * FROM stud WHERE roll = " + roll);
                        if (rs.next()) {
                            System.out.println("Roll: " + rs.getInt(1) + ", Name: " + rs.getString(2) + ", Percentage: " + rs.getInt(3));
                        } else {
                            System.out.println("Record not found.");
                        }
                        break;

                    case 5:
                        rs = pstmt.executeQuery("SELECT * FROM stud");
                        while (rs.next()) {
                            System.out.println("Roll: " + rs.getInt(1) + ", Name: " + rs.getString(2) + ", Percentage: " + rs.getInt(3));
                        }
                        break;

                    case 6:
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (ch != 6);

            cn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
