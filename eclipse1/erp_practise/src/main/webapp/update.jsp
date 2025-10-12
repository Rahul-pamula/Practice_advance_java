<%@ page import="java.sql.*" %>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    String name = request.getParameter("name");
    String designation = request.getParameter("designation");
    String department = request.getParameter("department");
    double salary = Double.parseDouble(request.getParameter("salary"));

    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ERP_5THSEM", "root", "@ROOT123");
    PreparedStatement ps = con.prepareStatement(
        "UPDATE emp SET name=?, designation=?, department=?, salary=? WHERE id=?");
    ps.setString(1, name);
    ps.setString(2, designation);
    ps.setString(3, department);
    ps.setDouble(4, salary);
    ps.setInt(5, id);

    int i = ps.executeUpdate();
    if (i > 0) {
        response.sendRedirect("index.jsp");
    } else {
        out.println("Update failed!");
    }
%>
