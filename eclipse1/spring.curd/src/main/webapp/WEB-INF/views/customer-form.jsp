<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Form</title>
</head>
<body>
    <h2>Customer Form</h2>
    <c:url var="saveLink" value="/customers/save"/>
    <form:form action="${saveLink}" modelAttribute="customer" method="POST">
        <form:hidden path="id" />
        <table>
            <tbody>
                <tr>
                    <td><label>First Name:</label></td>
                    <td><form:input path="firstname" /></td>
                </tr>
                <tr>
                    <td><label>Last Name:</label></td>
                    <td><form:input path="lastname" /></td>
                </tr>
                <tr>
                    <td><label>Address:</label></td>
                    <td><form:input path="address" /></td>
                </tr>
                <tr>
                    <td><label>City:</label></td>
                    <td><form:input path="city" /></td>
                </tr>
                <tr>
                    <td><label>Pincode:</label></td>
                    <td><form:input path="pincode" /></td>
                </tr>
                <tr>
                    <td><label>Email:</label></td>
                    <td><form:input path="email" /></td>
                </tr>
                <tr>
                    <td><label>Contact:</label></td>
                    <td><form:input path="contact" /></td>
                </tr>
                <tr>
                    <td><label></label></td>
                    <td><input type="submit" value="Save" /></td>
                </tr>
            </tbody>
        </table>
    </form:form>
    <div style="clear; both;"></div>
    <p>
        <c:url var="backLink" value="/customers/all"/>
        <a href="${backLink}">Back to List</a>
    </p>
</body>
</html>
