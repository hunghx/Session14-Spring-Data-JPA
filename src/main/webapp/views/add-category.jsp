<%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 4/24/2024
  Time: 7:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Thêm mới danh mục</h1>
<form action="/categoryController/add" method="post">
    <div>
        <label>Category Name</label>
        <input type="text" placeholder="nhap ten danh muc" name="catalogName">
    </div>
    <div>
        <label>Category Descriptions</label>
        <textarea cols="30" rows="10" placeholder="nhap mota" name="descriptions"></textarea>
    </div>
    <button type="submit">Add</button>
</form>
</body>
</html>
