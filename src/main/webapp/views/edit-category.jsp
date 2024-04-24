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
<h1>Chỉnh sửa danh mục</h1>
<form action="/categoryController/update" method="post">

    <div>
        <label>Category ID</label>
        <input type="text" placeholder="nhap ten danh muc" name="catalogId" value="${category.catalogId}" readonly>
    </div>
    <div>
        <label>Category Name</label>
        <input type="text" placeholder="nhap ten danh muc" value="${category.catalogName}" name="catalogName">
    </div>
    <div>
        <label>Category Descriptions</label>
        <textarea cols="30" rows="10" placeholder="nhap mota" name="descriptions">
            ${category.descriptions}
        </textarea>
    </div>
    <div>
        <label>Category Status</label>
        <input type="radio" name="status" ${category.status?"Checked":""} value="true"><span>Hoạt động</span>
        <input type="radio" name="status" ${!category.status?"Checked":""}  value="false"><span>Bị ẩn</span>
    </div>
    <button type="submit">Update</button>
</form>
</body>
</html>
