<%--
  Created by IntelliJ IDEA.
  User: Mercurial
  Date: 2020/7/10
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>res</title>
</head>
<body>
<h1>成功进入了RES</h1>
<h2>${userName}</h2>
<h2>${password}</h2>
<h2>账号为：${user.userName}</h2>
<h2>密码为：${user.password}</h2>

<c:if test="${user.money<1000}"><h2>余额为：${user.money}</h2></c:if>



<h2></h2>

</body>
</html>
