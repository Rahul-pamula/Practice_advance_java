<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Arithmetic in JSP</title>
</head>
<body>
<%

int a = 10, b = 5;
        int sum = a + b;
        int diff = a - b;
        int product = a * b;
        int division = a / b;
%>
<h2>Arithmetic Operations</h2>
    Sum: <%= sum %><br>
    Difference: <%= diff %><br>
    Product: <%= product %><br>
    Division: <%= division %><br>
</body>
</html>

