<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8f">
    <link href="style.css" rel="stylesheet" type="text/css">
    <a href="ProfileServlet?shopId=${shopId}"></a>
    <title> Інформація про кафе</title>
</head>
<body>
<nav class="nav-primary" role="navigation">
    <ul role="menubar">
        <li role="presentation"><a href="index.jsp" role="menuitem">Головна</a></li>
        <li role="presentation"><a href="shopList.jsp" role="menuitem">Список кафе</a></li>
        <li role="presentation"><a href="profile.jsp" role="menuitem">Профіль</a></li>

    </ul>
</nav>

<div class="context">
    <div class="centralbar">
        <%--<form action="AboutShopServlet" method="get">--%>
            <h2><b>Детальна інформація про кафе</b></h2>

            <p>Назва : ${shop.name}</p>

            <p>Опис : ${shop.description}</p>

            <p>Страви : </p>
        <%--</form>--%>
    </div>
</div>
</body>
</html>