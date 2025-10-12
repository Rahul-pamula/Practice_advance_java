package com.parul.requestdispatcher;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/requestdispatcher_2")
public class requestdispatcher_2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        out.println("<h1>RequestDispatcher Include Example</h1>");
        out.println("<b>Before including second servlet</b><br/>");

        RequestDispatcher rd = request.getRequestDispatcher("/requestdispatcher_22");
        rd.include(request, response);

        out.println("<b>After including second servlet</b>");
    }
}
