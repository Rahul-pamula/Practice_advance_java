package com.parul.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Display Login Form (GET request)
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html><head><title>Login Page</title></head><body>");
        out.println("<h2>Login Form</h2>");
        out.println("<form method='post' action='login'>");
        out.println("Username: <input type='text' name='username' required><br><br>");
        out.println("Password: <input type='password' name='password' required><br><br>");
        out.println("<input type='submit' value='Login'>");
        out.println("</form>");
        out.println("</body></html>");
    }

    // Process Login (POST request)
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html><head><title>Login Result</title></head><body>");
        if ("rahul".equalsIgnoreCase(username) && "@RAHUL123".equals(password)) {
            out.println("<h2 style='color:green;'>Welcome, " + username + "!</h2>");
            out.println("<p>Login Successful </p>");
        } else {
            out.println("<h2 style='color:red;'>Invalid Credentials </h2>");
            out.println("<p>Please try again <a href='login'>here</a>.</p>");
        }
        out.println("</body></html>");
    }
}
