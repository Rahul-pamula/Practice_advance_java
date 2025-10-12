<%@ page import="java.sql.*" %>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    String name = "", designation = "", department = "";
    double salary = 0;

    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ERP_5THSEM", "root", "@ROOT123");
    PreparedStatement ps = con.prepareStatement("SELECT * FROM emp WHERE id = ?");
    ps.setInt(1, id);
    ResultSet rs = ps.executeQuery();

    if (rs.next()) {
        name = rs.getString("name");
        designation = rs.getString("designation");
        department = rs.getString("department");
        salary = rs.getDouble("salary");
    }
%>
<html>
<body>
<h2>Edit Employee</h2>
<form action="update.jsp" method="post">
    <input type="hidden" name="id" value="<%= id %>">
    Name: <input type="text" name="name" value="<%= name %>"><br>
    Designation: <input type="text" name="designation" value="<%= designation %>"><br>
    Department: <input type="text" name="department" value="<%= department %>"><br>
    Salary: <input type="text" name="salary" value="<%= salary %>"><br>
    <input type="submit" value="Update">
</form>
<form action="index.jsp">
    <input type="submit" value="Close">
</form>
</body>
</html>
