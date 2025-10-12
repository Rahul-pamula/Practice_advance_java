package com.parul.requestdispatcher;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/requestdispatcher_1")
public class requestdispatcher_1 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        response.setContentType("text/html");

        pw.println("<h1>RequestDispatcher Forward Example</h1>");
        pw.println("<form method='post'>");
        pw.println("Username: <input type='text' name='txtuname'><br/>");
        pw.println("Password: <input type='password' name='txtupass'><br/>");
        pw.println("<input type='submit' value='Login'>");
        pw.println("</form>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname = request.getParameter("txtuname");
        String upass = request.getParameter("txtupass");

        if ("rahul".equals(uname) && "@RAHUL123".equals(upass)) {
            ServletContext ctx = getServletContext();
            ctx.setAttribute("username", uname);
            request.getRequestDispatcher("/requestdispatcher_11").forward(request, response);
        } else {
            PrintWriter pw = response.getWriter();
            pw.println("<h3 style='color:red;'>Invalid Username or Password</h3>");
            pw.println("<a href='requestdispatcher_1'>Try Again</a>");
        }
    }
}
