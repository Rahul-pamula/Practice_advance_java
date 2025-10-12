package com.parul.httpsession;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/httpsession")
public class httpsession extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public httpsession() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        response.setContentType("text/html");

        pw.print("<html><body>");
        ServletContext context = getServletContext();
        if (context.getAttribute("error") != null) {
            String message = (String) context.getAttribute("error");
            pw.write("<h1 style='color:red'>" + message + "</h1>");
            context.removeAttribute("error");
        }

        pw.print("<form method='post'>");
        pw.print("Username: <input type='text' name='txtuser'/><br>");
        pw.print("Password: <input type='password' name='txtpassword'/><br>");
        pw.print("<input type='submit' value='Login'>");
        pw.print("</form>");
        pw.print("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("txtuser");
        String password = request.getParameter("txtpassword");

        if (name.equals("rahul") && password.equals("@RAHUL123")) {
            HttpSession session = request.getSession();
            session.setAttribute("uname", name);
            session.setAttribute("upass", password);

            response.sendRedirect("httpsession_1");
        } else {
            ServletContext context = getServletContext();
            context.setAttribute("error", "Invalid Username / Password");
            response.sendRedirect("httpsession");
        }
    }
}
