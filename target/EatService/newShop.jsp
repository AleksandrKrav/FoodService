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
        <li role = "presentation"><a href = "shopList.jsp" role = "menuitem">Список кафе</a></li>
        <li role = "presentation"><a href = "profile.jsp" role = "menuitem">Профіль</a></li>

    </ul>
</nav>
<div class="context">
    <div class="centralbar">
        <h2>Введіть інформацію про кафе</h2>
        <br>
        <form action="" style="align-text: center">
            <p class="edit_point">Назва</p>
            <p class="edit_point"><input id="shopName"  type="text" placeholder="Введіть назву кафе" required></p>
            <p class="edit_point">Фото</p>
            <p class="edit_point"><input class="photo" id="photoShop" type="file" accept="image/*" /></p>
            <p class="edit_point">Опис</p>
            <p class="edit_point"><input id="description"  type="text" placeholder="Додайте опис(місто,кухня,особливості)"></p>
            <p class="edit_point"> <button id="submitAddShop" type="submit"><p>Send</p></button></p>
        </form>
    </div>
</div>


</body>
</html>