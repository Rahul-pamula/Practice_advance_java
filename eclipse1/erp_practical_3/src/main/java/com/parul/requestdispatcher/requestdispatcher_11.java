package com.parul.requestdispatcher;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/requestdispatcher_11")
public class requestdispatcher_11 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext ctx = getServletContext();
        String uname = (String) ctx.getAttribute("username");

        PrintWriter pw = response.getWriter();
        response.setContentType("text/html");

        if (uname != null) {
            pw.println("<h1>Welcome, " + uname + "</h1>");
        } else {
            pw.println("<h3 style='color:red;'>Please login first.</h3>");
            pw.println("<a href='requestdispatcher_1'>Login Here</a>");
        }
    }
}
