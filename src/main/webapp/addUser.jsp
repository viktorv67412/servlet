<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>
<%--
  Created by IntelliJ IDEA.
  User: BGClassTeacher
  Date: 12.12.2016
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add User</title>
</head>
<body style="margin:0">
<div style="width: 100%; height: 100%; background: #16DB8B;background-size: cover;text-align: center; padding-top:10px;">
    <form method="POST" action="<%=request.getContextPath()%>/users">
        Name<br>
        <input type="text" name="login_ui"/><br>
        Password<br>
        <input type="text" name="password_ui"/><br>
        Age<br>
        <input type="text" name="age_ui"/><br>
        Phone number<br>
        <input type="text" name="phoneNumber_ui"/><br>
        Home address<br>
        <input type="text" name="homeAddress_ui"/><br>
        Email address<br>
        <input type="text" name="email_ui"/><br>

        <input type="submit" value="add"/>
    </form>
    <a href="login.jsp">login</a>
</div>

</body>
</html>
