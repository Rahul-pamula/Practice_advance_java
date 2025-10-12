package com.parul.testcookie;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookiesuccess")
public class cookiesuccess extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public cookiesuccess() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("username".equals(cookie.getName())) {
                    username = cookie.getValue();
                    break;
                }
            }
        }

        PrintWriter pw = response.getWriter();
        response.setContentType("text/html");

        pw.print("<!DOCTYPE html>");
        pw.print("<html><head><title>Welcome</title></head><body>");
        if (username != null) {
            pw.print("<h2>Welcome, " + username + "!</h2>");
            pw.print("<a href='cookielogout'>Logout</a>");
        } else {
            pw.print("<h2 style='color:red;'>Session expired or not logged in.</h2>");
            pw.print("<a href='cookiesexample1'>Login Again</a>");
        }
        pw.print("</body></html>");
    }
}
