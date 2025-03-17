// Write a program to display information about the database and list all the tables in the database (use DatabaseMetaData).**

import java.sql.*;

class AssA2 {
    public static void main(String[] args) throws Exception {
        Connection conn = null;
        Statement stm;
        ResultSet rs;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "root");
            DatabaseMetaData dbmd = conn.getMetaData();
            System.out.println("Database = " + dbmd.getDatabaseProductName());
            System.out.println("Database version = " + dbmd.getDatabaseProductVersion());
            System.out.println("Driver Name = " + dbmd.getDriverName());
            System.out.println("Driver Version = " + dbmd.getDriverVersion());
            System.out.println("User Name = " + dbmd.getUserName());
            System.out.println("Catalog = " + dbmd.getCatalog());
            System.out.println("Tables in the database:");
            rs = dbmd.getTables(null, null, null, new String[]{"TABLE"});
            while (rs.next()) {
                String tableName = rs.getString("TABLE_NAME");
                System.out.println(tableName);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
                                }
