<%@ page import="java.sql.*" %>
<html>
<head><title>Employee Table</title></head>
<body>
<h2>Employee Details</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Designation</th>
        <th>Department</th>
        <th>Salary</th>
        <th>Operations</th>
    </tr>
<%
    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ERP_5THSEM", "root", "@ROOT123");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM emp");

        while (rs.next()) {
%>
    <tr>
        <td><%= rs.getInt("id") %></td>
        <td><%= rs.getString("name") %></td>
        <td><%= rs.getString("designation") %></td>
        <td><%= rs.getString("department") %></td>
        <td><%= rs.getDouble("salary") %></td>
        <td>
            <form action="edit.jsp" method="get" style="display:inline;">
                <input type="hidden" name="id" value="<%= rs.getInt("id") %>">
                <input type="submit" value="Edit">
            </form>
            <form action="delete.jsp" method="get" style="display:inline;">
                <input type="hidden" name="id" value="<%= rs.getInt("id") %>">
                <input type="submit" value="Del">
            </form>
        </td>
    </tr>
<%
        }
        con.close();
    } catch(Exception e) {
        out.println("Error: " + e);
    }
%>
</table>
</body>
</html>
