//package com.parul.controller;
//
//import java.io.*;
//import javax.servlet.*;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.*;
//
//@WebServlet("/cookie")
//public class CookieServlet extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//
//        String username = request.getParameter("username");
//
//        // Create cookie
//        Cookie cookie = new Cookie("username", username);
//        response.addCookie(cookie);
//
//        out.println("<html><body>");
//        out.println("<h3>Cookie created for user: " + username + "</h3>");
//        out.println("</body></html>");
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Cookie[] cookies = request.getCookies();
//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//
//        out.println("<html><body>");
//        if (cookies != null) {
//            for (Cookie c : cookies) {
//                out.println("<p>Cookie Name: " + c.getName() + ", Value: " + c.getValue() + "</p>");
//            }
//        } else {
//            out.println("<p>No cookies found</p>");
//        }
//        out.println("</body></html>");
//    }
//}
