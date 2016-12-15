<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body style="margin:0">
<div style="width: 100%; height: 100%; background: #008B8B;background-size: cover;text-align: center; padding-top:10px;">
    <form method="POST" action="<%=request.getContextPath()%>/users">
        Name<br>
        <input type="text" name="login_login"/><br>
        Password<br>
        <input type="text" name="password_login"/><br>

        <input type="submit" value="add"/>
    </form>
</div>
</body>
</html>
