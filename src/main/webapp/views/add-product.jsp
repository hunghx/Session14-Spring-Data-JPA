<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 4/24/2024
  Time: 9:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Thêm mới sản phẩm</h1>

<form action="/ProductController/add" method="post" enctype="multipart/form-data">
    <div>
        <label>Name</label>
        <input type="text" placeholder="nhap ten sp" name="name">
    </div>
    <div>
        <label>Price</label>
        <input type="text"  name="price">
    </div>
    <div>
        <label>Stock</label>
        <input type="number"  name="stock">
    </div>
    <div>
        <label>Image</label>
        <input type="file"  name="file">
    </div>
    <div>
        <label>Catalog</label>
        <select name="categoryId" >
            <c:forEach items="${catagories}" var="cat">
                <option value="${cat.catalogId}">${cat.catalogName}</option>
            </c:forEach>

        </select>
    </div>

    <button type="submit">Add</button>

</form>
</body>
</html>
