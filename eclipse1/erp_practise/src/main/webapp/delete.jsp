<%@ page import="java.sql.*" %>
<%
    int id = Integer.parseInt(request.getParameter("id"));

    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ERP_5THSEM", "root", "@ROOT123");
    PreparedStatement ps = con.prepareStatement("DELETE FROM emp WHERE id = ?");
    ps.setInt(1, id);
    int i = ps.executeUpdate();

    if (i > 0) {
        response.sendRedirect("index.jsp");
    } else {
        out.println("Delete failed!");
    }
%>
