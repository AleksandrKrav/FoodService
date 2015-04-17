<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8f">
    <link href="style.css" rel="stylesheet" type="text/css">
    <title> Створення нового кафе</title>
</head>
<body>
<nav class = "nav-primary" role = "navigation">
    <ul role = "menubar">
        <li role = "presentation"><a href = "index.jsp" role = "menuitem">Головна</a></li>
        <li role = "presentation"><a href = "ShopListServlet" role = "menuitem">Список кафе</a></li>
        <li role = "presentation"><a href = "ProfileServlet" role = "menuitem">Профіль</a></li>

    </ul>
</nav>
<div class="context">
    <div class="centralbar">

        <form action="AddShopServlet?userLogin=${userLogin}" method="post" enctype="multipart/form-data" style="align-text: center">
        <h2>Введіть інформацію про кафе</h2>
        <br>
            <p class="edit_point">Назва</p>
            <p class="edit_point"><input id="shopName" name="shopName"  type="text" placeholder="Введіть назву кафе" ></p>
            <p class="edit_point">Фото</p>
            <p class="edit_point"><input class="photo" name="photoShop" id="photoShop" type="file" accept="image/*" /></p>
            <p class="edit_point">Опис</p>
            <p class="edit_point"><input id="description" name="description" type="text" placeholder="Додайте опис(місто,кухня,особливості)"></p>
            <p class="edit_point"><input type = "submit" id="submitInfo"  name = "add" value="Додати"></p>
        </form>
    </div>
</div>
</body>
</html>