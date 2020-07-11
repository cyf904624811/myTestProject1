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

<html>
<head>
    <title>Login</title>
</head>
<body>
    <form id="login_form" action="${pageContext.request.contextPath}/res1">
        <input type="text" id="userName" name="userName" placeholder="请输入账号">
        <input type="text" id="password" name="password" placeholder="请输入密码">
        <input type="text" id="checkCode" name="checkCode" placeholder="请输入验证码"><br>
        <input type="radio" id="猪" name="pet.level" value="81"><label for="猪">猪</label><br>
        <input type="radio" id="狗" name="pet.level" value="11"><label for="狗">狗</label><br>
        <input type="radio" id="猫" name="pet.level" value="7"><label for="猫">猫</label><br>
        <input type="checkbox" id="足球" name="hobby[0]" value="足球" ><label for="足球">足球</label>
        <input type="checkbox" id="篮球" name="hobby[1]" value="篮球" ><label for="足球">篮球</label>
        <input type="checkbox" id="网球" name="hobby[2]" value="网球" ><label for="足球">网球</label>
        <img src="${pageContext.request.contextPath}/checkCode" onclick="changeCode(this)">
        <input type="button" onclick="login()" value="登录">


    </form>
</body>
<script>function login() {
var form = document.getElementById("login_form");
var userName = document.getElementById("userName");
var password = document.getElementById("password");
var checkCode = document.getElementById("checkCode");
if (userName == null)
{
    alert("请输入账号");
    return;
}
if (password == null)
{
    alert("请输入密码");
    return;
}
<%--if (checkCode != "${randomString}")--%>
<%--{--%>
<%--    alert("验证码错误")--%>
<%--    return;--%>
<%--}--%>
form.submit();
}</script>
<script>function changeCode(obj){
obj.src ="${pageContext.request.contextPath}/checkCode?time="+new Date().getTime();}</script>
<%--<script>--%>
<%--    var hobby_list=[];--%>
<%--    $("input[name='hobby']:checked").each(function()--%>
<%--    {--%>
<%--        hobby_list.push($(this).val)--%>
<%--    });--%>

<%--    --%>


<%--</script>--%>
</html>
