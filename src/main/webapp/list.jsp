<%--
  Created by IntelliJ IDEA.
  User: codingBoy
  Date: 16/10/23
  Time: 下午12:22
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<script type="text/javascript" src="bootstrap/js/jquery/2.0.0/jquery.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap/3.3.6/bootstrap.min.js"></script>
<link href="bootstrap/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学生信息列表</title>
</head>
<body>
<script>
    $(function(){
        $("a").addClass("btn btn-default btn-xs");
    });

</script>
<table   style="width:600px; margin:44px auto" align='center' border='1' cellspacing='0' class="table table-striped table-bordered table-hover  table-condensed">
<tr>
    <th>学生姓名</th>
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
</table>
<nav>
    <ul class="pager">
        <li><a href="?start=0">首  页</a></li>
        <li><a href="?start=${pre}">上一页</a></li>
        <li><a href="?start=${next}">下一页</a></li>
        <li><a href="?start=${last}">末  页</a></li>
    </ul>
</nav>
</body>
</html>
