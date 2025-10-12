package com.parul.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/requestDetails")
public class RequestDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h1>Request Details</h1>");

        out.println("<p><strong>Method:</strong> " + request.getMethod() + "</p>");
        out.println("<p><strong>Request URI:</strong> " + request.getRequestURI() + "</p>");
        out.println("<p><strong>Protocol:</strong> " + request.getProtocol() + "</p>");
        out.println("<p><strong>Remote Address:</strong> " + request.getRemoteAddr() + "</p>");

        out.println("<h3>Headers:</h3>");
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String header = headerNames.nextElement();
            out.println("<p><strong>" + header + ":</strong> " + request.getHeader(header) + "</p>");
        }

        out.println("</body></html>");
    }
}
