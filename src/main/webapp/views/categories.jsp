<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 4/24/2024
  Time: 7:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách danh mục</title>
</head>
<body>
<h1>Danh sách sp</h1>
<a href="/categoryController/add">Thêm mới danh mục</a>
<table border="10" cellspacing="10" cellpadding="10">
    <thead>
    <tr>
        <th>STT</th>
        <th>Tên Danh muc</th>
        <th>Mô tả</th>
        <th>Trạng thái</th>
        <th colspan="2">Thao tác</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listCategories}" var="cat" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>${cat.catalogName}</td>
            <td>${cat.descriptions}</td>
            <td>${cat.status?"Đang hoạt động":"Bị ẩn"}</td>
            <td><a href="/categoryController/edit?id=${cat.catalogId}">Edit</a></td>
            <td><a href="/categoryController/delete?id=${cat.catalogId}"
            onclick="return confirm('Bạn co chắc chắn muốn xóa ko?')"
            >Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
