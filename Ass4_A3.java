//Write a program to display information about all columns in the student table (use ResultSetMetaData).**

import java.sql.*;

public class AssA3 {
    public static void main(String[] args) {
        Connection cn = null;
        Statement stm;
        ResultSet rs;
        ResultSetMetaData metaData;

        try {
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "root");
            stm = cn.createStatement();
            rs = stm.executeQuery("SELECT * FROM stud");
            metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                System.out.println("Column Name: " + metaData.getColumnName(i));
                System.out.println("Column Type: " + metaData.getColumnTypeName(i));
                System.out.println("Is Nullable: " + metaData.isNullable(i));
                System.out.println("Column Size: " + metaData.getColumnDisplaySize(i));
                System.out.println("---");
            }
            rs.close();
            stm.close();
            cn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
