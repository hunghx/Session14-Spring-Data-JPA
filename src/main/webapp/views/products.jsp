<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 4/24/2024
  Time: 9:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Danh sách sp</h1>
<a href="/ProductController/add">Thêm mới sản phẩm</a>
<table border="10" cellspacing="10" cellpadding="10">
    <thead>
    <tr>
        <th>STT</th>
        <th>Tên sp</th>
        <th>Giá</th>
        <th>Ảnh</th>
        <th colspan="2">Thao tác</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${products}" var="pro" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>${pro.name}</td>
            <td>${pro.price}</td>
            <td><img src="/uploads/${pro.imageUrl}" alt="" width="100" height="100" style="object-fit: cover"></td>
            <td><a href="">Edit</a></td>
            <td><a
                   onclick="return confirm('Bạn co chắc chắn muốn xóa ko?')"
            >Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
