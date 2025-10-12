package com.parul.testcookie;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookieexample1")
public class cookieexample1 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public cookieexample1() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        response.setContentType("text/html");

        pw.print("<!DOCTYPE html>");
        pw.print("<html><head><title>Login</title></head><body>");
        pw.print("<h2>Login Form</h2>");
        pw.print("<form method='post'>");
        pw.print("Username: <input type='text' name='txtuser' required/><br><br>");
        pw.print("Password: <input type='password' name='txtpassword' required/><br><br>");
        pw.print("<input type='submit' value='Login'>");
        pw.print("</form>");
        pw.print("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        response.setContentType("text/html");

        String username = request.getParameter("txtuser");
        String password = request.getParameter("txtpassword");

        if ("rahul".equals(username) && "@RAHUL123".equals(password)) {
            Cookie loginCookie = new Cookie("username", username);
            loginCookie.setMaxAge(5 * 60); // 5 minutes
            response.addCookie(loginCookie);

            response.sendRedirect("cookiesuccess");
        } else {
            pw.print("<!DOCTYPE html>");
            pw.print("<html><head><title>Login Failed</title></head><body>");
            pw.print("<h2 style='color:red;'>Invalid username or password!</h2>");
            pw.print("<a href='cookiesexample1'>Try Again</a>");
            pw.print("</body></html>");
        }
    }
}
