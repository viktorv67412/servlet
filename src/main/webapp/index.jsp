<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %><%--
  Created by IntelliJ IDEA.
  User: BGClassTeacher
  Date: 08.12.2016
  Time: 19:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
my first web page
<c:out value="jstl out test"/>
<%
    List<String> userNamesList = Arrays.asList("name1", "name2", "name3");
    response.getWriter().print(userNamesList);
    request.setAttribute("userNamesList1", userNamesList);
%>
<table border="3">
    <tr>
        <th>User Name</th>
    </tr>

    <c:forEach var="usrName" items="${userNamesList1}">
        <tr>
            <td>
            >>>>> ${usrName}
            </td>
        </tr>
    </c:forEach>

</table>
<a href="addUser.jsp">add_user_link</a>
</body>
</html>
