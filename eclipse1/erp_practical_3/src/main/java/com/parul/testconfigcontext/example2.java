package com.parul.testconfigcontext;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class example2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public example2() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        try {
            // Get DB details from ServletContext
            ServletContext context = getServletContext();

            String url = context.getInitParameter("dburl");
            String dbUsername = context.getInitParameter("username");
            String dbPassword = context.getInitParameter("password");

            // Load JDBC Driver
            Class.forName(context.getInitParameter("driver"));

            // Connect to Database
            Connection con = DriverManager.getConnection(url, dbUsername, dbPassword);

            // Execute Query
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");

            // Display Users
            pw.println("<h1>Users from example2:</h1>");
            while (rs.next()) {
                pw.println("<p>ID: " + rs.getInt("id") +
                        ", Username: " + rs.getString("username") +
                        ", Password: " + rs.getString("password") + "</p>");
            }

            con.close();
        } catch (Exception e) {
            pw.println("<h2 style='color:red;'>Error: " + e.getMessage() + "</h2>");
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
