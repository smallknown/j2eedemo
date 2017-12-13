<%--
  Created by IntelliJ IDEA.
  User: codingBoy
  Date: 16/10/23
  Time: 下午2:43
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<script type="text/javascript" src="bootstrap/js/jquery/2.0.0/jquery.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap/3.3.6/bootstrap.min.js"></script>
<link href="bootstrap/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3 align="center">编辑客户</h3>
<form action="<c:url value='/UpdateServlet'/>" method="post" >
    <input type="hidden" name="method" value="edit"/>
    <input type="hidden" name="id" value="${user.id}"/>
    <table border="0" align="center"  style="width:600px; margin:44px auto"  class="table">
        <tr>
            <td width="100px">客户名称</td>
            <td width="40%">
                <input type="text" name="name" value="${user.name}"/>
            </td>
            <td align="left">
                <label id="nameError" class="error">&nbsp;</label>
            </td>
        </tr>
        <tr>
            <td>客户性别</td>
            <td>
                <input type="radio" name="gender" value="male" id="male" <c:if test="${user.gender eq 'male'}"/>checked="checked"/>
                <label for="male">男</label>
                <input type="radio" name="gender" value="female" id="female" <c:if test="${user.gender eq 'female'}"/> checked="checked"/>
                <label for="female">女</label>
            </td>
            <td>
                <label id="genderError"class="error">&nbsp;</label>
            </td>
        </tr>
        <tr>
            <td>手机</td>
            <td>
                <input type="text" name="phone" id="phone" value="${user.phone}"/>
            </td>
            <td>
                <label id="phoneError"class="error">&nbsp;</label>
            </td>
        </tr>
        <tr>
            <td>邮箱</td>
            <td>
                <input type="text" name="email" id="email" value="${user.email}"/>
            </td>
            <td>
                <label id="emailError"class="error">&nbsp;</label>
            </td>
        </tr>
        <tr>
            <td>描述</td>
            <td>
                <textarea rows="5" cols="30" name="description">${user.description}</textarea>
            </td>
            <td>
                <label id="discriptionError"class="error">&nbsp;</label>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" name="submit" value="编辑客户" class="btn btn-primary"/>
                <input type="reset" name="reset" class="btn btn-default"/>
            </td>
        </tr>
    </table>
</form>


</body>
</html>
