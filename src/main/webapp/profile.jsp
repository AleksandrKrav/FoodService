<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8f">
    <link href="style.css" rel="stylesheet" type="text/css">
    <title>Профіль</title>
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
        <h2 ><b>Профіль користувача: getLogin</b></h2>
        <p>фотка</p>
        <p>ім'я</p>
        <p>email</p>
        <p style="font-size: 20px">Додати власне кафе  <a href="newShop.jsp"><img src="img/plus.png" width="32" height="32" /></a></p>
    </div>
</div>
<div class = rightbar style="padding-top: 100px">
    <div >
        <p > Ви ще не авторизувались?</p>
        <a href =authorisation.jsp> Увійти</a>
    </div>


</div>
</body>
</html>
