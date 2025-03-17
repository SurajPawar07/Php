//Create a student table with fields roll number, name, and percentage. Insert values in the table. Display all the details of the student table in a tabular format on the screen (using Swing).**

import javax.swing.*;
import java.sql.*;

class AssA1 extends JFrame {
    JTable std;
    Connection cn = null;
    Statement stm;
    ResultSet rs;
    PreparedStatement pstmt;
    String[] colHeads = {"Roll", "Name", "Percentage"};
    String[][] data;
    int rowCount = 0;

    AssA1() {
        super("Table & DB Connectivity");
        setSize(300, 300);
        setLocation(100, 100);

        try {
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "root");
            stm = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery("SELECT COUNT(*) FROM stud");
            rs.next();
            rowCount = rs.getInt(1);
            data = new String[rowCount][3];
            rs = stm.executeQuery("SELECT * FROM stud ORDER BY roll");
            int i = 0;
            while (rs.next()) {
                data[i][0] = rs.getString(1);
                data[i][1] = rs.getString(2);
                data[i][2] = rs.getString(3);
                i++;
            }
            std = new JTable(data, colHeads);
            JScrollPane jSp = new JScrollPane(std, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            add(jSp);
        } catch (Exception ex) {
            System.out.println(ex);
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AssA1();
    }
}
