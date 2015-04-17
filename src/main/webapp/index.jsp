<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8f">
    <link href="style.css" rel="stylesheet" type="text/css">
    <title> Головна сторінка</title>
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
        <h2 ><b>Вас вітає команда EatService.</b></h2>
        <img id="mainImage"  src="img/6.png" >
        <p style="color: #4682B4;font-size: 20px;">Тут ви зможете знайти кафе на будь-який смак,а також додати інформацію про власний заклад</p>
    </div>
</div>

</body>
</html>
