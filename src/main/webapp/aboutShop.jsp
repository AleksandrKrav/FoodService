<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8f">
    <link href="style.css" rel="stylesheet" type="text/css">
    <%--<a href="ProfileServlet?shopId=${shopId}"></a>--%>
    <title> Інформація про кафе</title>
</head>
<body>
<nav class="nav-primary" role="navigation">
    <ul role="menubar">
        <li role="presentation"><a href="index.jsp" role="menuitem">Головна</a></li>
        <li role="presentation"><a href="ShopListServlet" role="menuitem">Список кафе</a></li>
        <li role="presentation"><a href="ProfileServlet?userLogin" role="menuitem">Профіль</a></li>

    </ul>
</nav>

<div class="context">
    <div class="centralbar">
        <form action="AboutShopServlet" enctype="multipart/form-data" method="post">
            <h2><b>Детальна інформація про кафе</b></h2>

            <div id="userphotoView"><img src="image?photoId=${photoId}" width="100%" height="100%"></div>

            <p>Назва : ${shop.name}</p>

            <p>Опис : ${shop.description}</p>

            <a href="RedirectToAddDishServlet?shopId=${shop.id}">Додати страву</a>


        <%--<form action="RedirectToAddDishServlet?shopId=${shopId}"--%>
                  <%--method="post">--%>
                <%--<input type="submit" id="submitInfo5" name="addDish" value="Додати страву">--%>
            <%--</form>--%>

            <c:forEach items="${dishList}" var="dish">
                <div>
                    <p>Страва : ${dish.name} Ціна : ${dish.price}</p>
                </div>
            </c:forEach>

        </form>
    </div>
</div>
</body>
</html>