<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="utf-8f">
    <link href="style.css" rel="stylesheet" type="text/css">
    <a href="RegistrationServlet?userLogin=${userLogin}"></a>
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
        <form action="ProfileServlet"  enctype="multipart/form-data" method="post">
        <h2 ><b>Профіль користувача: ${userLogin}</b></h2>
        <p>фотка:<img src="image?photoId=${photoId}" width="32px" height="32px"></p>
        <p>ім'я: ${name}</p>
        <p>email: ${email}</p>
            <p class="edit_point">
            </p>
            <%--<p style="font-size: 20px">Додати кафе  <a href="AddShopServlet" ><img src="img/plus.png" width="32" height="32" /></a></p>--%>
        <c:forEach items="${shopList}" var="shop" >
            <div>
                Кафе: ${shop.name}
                <a href="AboutShopServlet?shopId=${shop.id}">Shop details</a>
            </div>
        </c:forEach>
    </form>

        <form action="RedirectToAddShopServlet?userLogin=${userLogin}" enctype="multipart/form-data" method="post">
            <input type = "submit" name = "add" value="Додати кафе">
            <%--<input type="hidden" name="userLogin" value="${userLogin}"/>--%>
        </form>

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
