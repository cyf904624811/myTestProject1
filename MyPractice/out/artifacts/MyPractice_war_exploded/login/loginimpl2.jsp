<%--
  Created by IntelliJ IDEA.
  User: Mercurial
  Date: 2020/7/10
  Time: 9:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%--<%@ taglib prefix="test" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="fm" %>

<html>
<head>
    <title>Login</title>
</head>
<body>
    <form id="login_form" action="${pageContext.request.contextPath}/res1">
      <fm:form modelAttribute="user">
          <fm:input path="userName"/><br>
          <fm:input path="password"/><br>
            <%--通过radiobutton修改money属性 用label显示--%>
          <fm:radiobutton path="money" value="995" label="钱多"/>
          <fm:radiobutton path="money" value="1" label="钱少"/>
            <%--通过checkbox修改hobby属性 用user.hobbys内对象显示--%>
          <fm:checkboxes path="hobby" items="${user.hobbys}"></fm:checkboxes><br>
            <%--通过select修改pet.level属性 用user.pets内对象显示--%>
          <fm:select path="pet.level" items="${user.pets}" itemValue="level" itemLabel="name"/><br>
          <input type="submit" value="修改">
      </fm:form>


    </form>
</body>




</html>
