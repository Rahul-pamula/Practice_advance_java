<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert JSP</title>
</head>
<body>
<%@ page import="java.sql.*" %>
<%
    String name = request.getParameter("name");
    String email = request.getParameter("email");

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ERP_5THSEM", "root", "@ROOT123");

        String query = "INSERT INTO users (name, email) VALUES (?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, name);
        ps.setString(2, email);


        int i = ps.executeUpdate();
        if(i > 0){
            out.println("<h2>Record inserted successfully</h2>");
        } else {
            out.println("<h2>Failed to insert record</h2>");
        }

        con.close();
    } catch(Exception e){
        out.println(e);
    }
%>

</body>
</html>