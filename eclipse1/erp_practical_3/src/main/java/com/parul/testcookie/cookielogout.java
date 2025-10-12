package com.parul.testcookie;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookielogout")
public class cookielogout extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public cookielogout() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("username".equals(cookie.getName())) {
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                    break;
                }
            }
        }

        PrintWriter pw = response.getWriter();
        response.setContentType("text/html");

        pw.print("<!DOCTYPE html>");
        pw.print("<html><head><title>Logout</title></head><body>");
        pw.print("<h2 style='color:green;'>You have been logged out successfully!</h2>");
        pw.print("<a href='cookiesexample1'>Login Again</a>");
        pw.print("</body></html>");
    }
}
