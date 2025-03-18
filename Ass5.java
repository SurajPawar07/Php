// EXPERIMENT: No. Assignment 5

// Set A

// 1. Design a servlet that provides information about an HTTP request from a client, such as IP address and browser type. 
// The servlet also provides information about the service on which the servlet is running, such as the operating system type, 
// and the format of currently loaded services.

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

class Ass5A1 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h3>Request Information Example</h3>");
        out.println("Method Name: " + request.getMethod() + "<br>");
        out.println("Local Name: " + request.getLocalName() + "<br>");
        out.println("Server Name: " + request.getServerName() + "<br>");
        out.println("IP Address: " + request.getLocalAddr() + "<br>");
        out.println("Servlet Name: " + this.getServletName() + "<br>");
        out.println("Remote Address: " + request.getRemoteAddr() + "<br>");
        java.util.Properties p = System.getProperties();
        out.println("Operating System Type: " + p.getProperty("os.name") + "<br>");
        out.println("</body></html>");
    }
}

// 2. Write a servlet which counts how many times a user has visited a web page. If the user is visiting the page for the first time, 
// display a welcome message. If the user is re-visiting the page, display the number of times visited (use cookies).

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class Ass5A2 extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cnt = 0;
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("counter")) {
                    cnt = Integer.parseInt(cookies[i].getValue());
                    cnt++;
                    out.println("Number of Times Visited = " + cnt);
                }
            }
        } else {
            out.println("Welcome user!");
            cnt = 1;
        }
        Cookie c = new Cookie("counter", Integer.toString(cnt));
        response.addCookie(c);
        out.println("</body></html>");
    }
}

// Set B

// 1. Design an HTML page which passes student roll number to a servlet. The servlet searches for the roll number in a database 
// ("Student table") and returns student details if found or an error message otherwise.

import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class Ass5B1 extends HttpServlet {
    Connection cn;
    Statement stmt;
    ResultSet rs;

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        pw.println("<HTML><HEAD><TITLE>Database Connectivity</TITLE></HEAD>");
        pw.println("<BODY>");
        pw.println("<P align=center><BIG>Data from database</BIG></P>");
        pw.println("<Table align=center border=1>");
        pw.println("<TR>");
        pw.println("<TH>Roll Number</TH><TH>Name</TH><TH>Age</TH></TR>");
        try {
            int roll = Integer.parseInt(request.getParameter("txt"));
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_db", "root", "root");
            stmt = cn.createStatement();
            rs = stmt.executeQuery("Select * from student where roll=" + roll);
            rs.next();
            pw.println("<TR>");
            pw.println("<TD>" + rs.getString(1) + "</TD>");
            pw.println("<TD>" + rs.getString(2) + "</TD>");
            pw.println("<TD>" + rs.getString(3) + "</TD>");
            pw.println("</TR>");
            rs.close();
            stmt.close();
            cn.close();
        } catch (Exception e) {
            pw.println("<TR><TD colspan=3>Student Info. Not Found</TD></TR>");
        }
        pw.println("</Table></BODY></HTML>");
        pw.close();
    }
}

// HTML Page for Ass5B1
<html>
<body>
<center>
<form name="frm" method="POST" action="http://localhost:9990/examples/servlet/Ass5B1">
Enter student Roll No: <input type="textbox" name="txt"><br><br>
<input type="submit" value="Submit">
</center>
</form>
</body>
</html>

// 2. Write a program to create a shopping mall. The user must be allowed to do purchases. From two pages, each page should have a page total. 
// The third page should display a bill, which consists of a page total of whatever the purchase has been done and print the total. (Use HttpSession)

// Page1Servlet.java
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class Page1Servlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int sum = 0;
        String[] values = req.getParameterValues("item");
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                sum += Integer.parseInt(values[i]);
            }
        }
        HttpSession hs = req.getSession(true);
        hs.setAttribute("Page1", sum);
        res.sendRedirect("Page2.html");
    }
}

// Page1.html
<html>
<head><title>Page1</title></head>
<body>
<form method="GET" action="http://localhost:9090/examples/servlet/Page1Servlet">
    <input type="checkbox" name="item" value="100">Book 100<br>
    <input type="checkbox" name="item" value="200">CD 200<br>
    <input type="checkbox" name="item" value="300">Tape 300<br>
    <input type="submit">
    <input type="reset">
</form>
</body>
</html>

// Page2Servlet.java
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

class Page2Servlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        int sum2 = 0;
        String[] values = req.getParameterValues("item");
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                sum2 += Integer.parseInt(values[i]);
            }
        }
        HttpSession hs = req.getSession();
        int sum1 = (Integer) hs.getAttribute("Page1");
        out.println("<html><body>");
        out.println("Total of Page1=" + sum1 + "<BR>");
        out.println("Total of Page2=" + sum2 + "<BR><BR>");
        int total = sum1 + sum2;
        out.println("Total Bill=" + total);
        out.println("</body></html>");
    }
}

// Page2.html
<html>
<head><title>Page2</title></head>
<body>
<form method="GET" action="http://localhost:8888/examples/servlet/Page2Servlet">
    <input type="checkbox" name="item" value="10000">Printer 10000<br>
    <input type="checkbox" name="item" value="200">Pen drive 200<br>
    <input type="checkbox" name="item" value="15000">Camera 15000<br>
    <input type="submit">
    <input type="reset">
</form>
</body>
</html>

// 3. Design an HTML page containing 4 option buttons (Painting, Drawing, Singing, and Swimming) and 2 buttons reset and submit. 
// When the user clicks submit, the server responds by adding a cookie containing the selected hobby and sends a message back to the client. 
// The program should not allow duplicate cookies to be written.

// Ass5B2.java
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.util.*;

public class Ass5B2 extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int cnt = 0;
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<html><body>");
        String option = req.getParameter("options");
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("hobby")) {
                    out.println("Cookie exists for Hobby=" + cookies[i].getValue());
                    cnt++;
                }
            }
        }
        if (cnt == 0) {
            Cookie c = new Cookie("hobby", option);
            c.setPath("/");
            res.addCookie(c);
            out.println("Cookie Added for Hobby=" + option);
        }
        out.println("</body></html>");
    }
}

// Ass5B2.html
<html>
<body>
<form method="POST" action="http://localhost:9090/examples/servlet/Ass5B2">
<h2>Select an option:</h2><br>
Painting <input type="radio" value="painting" name="options"><br>
Drawing <input type="radio" value="drawing" name="options"><br>
Singing <input type="radio" value="singing" name="options"><br>
Swimming <input type="radio" value="swimming" name="options"><br>
<input type="reset" value="Reset" style="background-color:red; color:white">
<input type="submit" value="Submit" style="background-color:red; color:white">
</form>
</body>
</html>
