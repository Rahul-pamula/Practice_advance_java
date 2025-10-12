<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer List</title>
</head>
<body>
    <h2>Customer List</h2>
    <p>
        <c:url var="addLink" value="/customers/create"/>
        <a href="${addLink}">Add Customer</a>
    </p>
    <table border="1">
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Address</th>
            <th>City</th>
            <th>Pincode</th>
            <th>Email</th>
            <th>Contact</th>
            <th>Action</th>
        </tr>
        <c:forEach var="tempCustomer" items="${customers}">
            <c:url var="updateLink" value="/customers/editcustomer">
                <c:param name="customerId" value="${tempCustomer.id}"/>
            </c:url>
            <c:url var="deleteLink" value="/customers/deletecustomer">
                <c:param name="customerId" value="${tempCustomer.id}"/>
            </c:url>
            <tr>
                <td>${tempCustomer.firstname}</td>
                <td>${tempCustomer.lastname}</td>
                <td>${tempCustomer.address}</td>
                <td>${tempCustomer.city}</td>
                <td>${tempCustomer.pincode}</td>
                <td>${tempCustomer.email}</td>
                <td>${tempCustomer.contact}</td>
                <td>
                    <a href="${updateLink}">Update</a>
                    |
                    <a href="${deleteLink}" 
                       onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
