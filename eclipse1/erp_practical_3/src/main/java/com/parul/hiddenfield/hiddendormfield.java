package com.parul.hiddenfield;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hiddenfield/hiddendormfield")
public class hiddendormfield extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public hiddendormfield() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        response.setContentType("text/html");

        Date today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        String dt = sdf.format(today);

        pw.print("<html><body>");
        pw.print("<form action ='hiddefieldmsg' method='post'>");
        pw.print("Enter your email:<input type='text' name='txtemail'/>");
        pw.print("<br/><input type='hidden' value='" + dt + "' name='visittime'/>");
        pw.print("<br/><br/><input type='submit' value='Show Message'/>");
        pw.print("</form>");
        pw.print("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
