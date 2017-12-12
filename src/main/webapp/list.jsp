<%--
  Created by IntelliJ IDEA.
  User: codingBoy
  Date: 16/10/23
  Time: 下午12:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>客户列表</title>
</head>
<body>
<table align='center' border='1' cellspacing='0'>
<tr>
    <th>客户姓名</th>
    <th>性别</th>
    <th>手机</th>
    <th>邮箱</th>
    <th>描述</th>
    <th>操作</th>
</tr>
<c:forEach items="${users}" var="user" varStatus="st">
    <tr>
        <td>${user.name}</td>
        <td>${user.gender}</td>
        <td>${user.phone}</td>
        <td>${user.email}</td>
        <td>${user.description}</td>
        <td>
            <a href="<c:url value='/EditServlet?id=${user.id}'/> ">编辑</a>
            <a href="<c:url value='/DeleteServlet?id=${user.id}'/> ">删除</a>
        </td>
            </form>
    </tr>
</c:forEach>
    <tr>
        <td colspan="6" align="center">
            <a href="?start=0">[首页]</a>
            <a href="?start=${pre}">[上一页]</a>
            <a href="?start=${next}">[下一页]</a>
            <a href="?start=${last}">[末页]</a>
        </td>
    </tr>
</table>

</body>
</html>
