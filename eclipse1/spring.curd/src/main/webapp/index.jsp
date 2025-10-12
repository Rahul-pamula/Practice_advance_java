<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring MVC Customer App</title>
</head>
<body>
    <h2>Welcome to the Customer Relationship Management App</h2>
    <c:url var="customerListLink" value="/customers/all"/>
    <a href="${customerListLink}">View Customers</a>
</body>
</html>
