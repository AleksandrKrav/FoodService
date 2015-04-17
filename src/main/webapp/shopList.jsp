<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="utf-8f">
    <link href="style.css" rel="stylesheet" type="text/css">
    <title>Список кафе</title>
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
        <form action="ShopListServlet"  method="get">
            <h2 style="color:#009ACD;font-size: 32px;text-align:center"><b>Кафе на будь-який вибір</b></h2>
            <%--<p style="font-size: 20px">Додати кафе  <a href="AddShopServlet" ><img src="img/plus.png" width="32" height="32" /></a></p>--%>
            <%--hi--%>
            <%--${show}--%>
            <c:forEach items="${shopList}" var="shop">
                Кафе:
                <a href="AboutShopServlet?shopId=${shop.id}"> ${shop.name}</a>
                <br>
            </c:forEach>
        </form>
    </div>
</div>
</body>
</html>
