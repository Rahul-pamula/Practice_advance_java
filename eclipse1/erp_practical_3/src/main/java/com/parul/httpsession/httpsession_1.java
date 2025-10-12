package com.parul.httpsession;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/httpsession_1")
public class httpsession_1 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public httpsession_1() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute("uname") != null) {
            String username = (String) session.getAttribute("uname");
            pw.print("<h1>Welcome, " + username + "</h1>");
            pw.print("<br/><a href='httpsession'>Logout</a>");
            session.invalidate();
        } else {
            pw.print("<h1>No active session found. Please <a href='httpsession'>login</a>.</h1>");
        }
    }
}
