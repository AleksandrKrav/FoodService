<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8f">
    <link href="style.css" rel="stylesheet" type="text/css">
    <title>Профіль</title>

</head>
<body>
<nav class="nav-primary" role="navigation">
    <ul role="menubar">
        <li role="presentation"><a href="index.jsp" role="menuitem">Головна</a></li>
        <li role="presentation"><a href="ShopListServlet" role="menuitem">Список кафе</a></li>
        <li role="presentation"><a href="ProfileServlet" role="menuitem">Профіль</a></li>
    </ul>
</nav>
<div class="context">
    <div class="centralbar">
        <br>
        <c:if test='<%=session.getAttribute("isAuthenticated") != null && (Boolean)session.getAttribute("isAuthenticated")%>'>
            <a href="LogOutServlet" class="logOutButton" >Вийти</a>
            <form action="ProfileServlet" enctype="multipart/form-data" method="post">
                <%--<p class="edit_point"><input type="submit" name="logOut" value="Вийти"></p>--%>

                <h2><b>Профіль користувача: ${userLogin}</b></h2>

                <div id="userphotoView"><img src="image?photoId=${photoId}" width="100%" height="100%"></div>
                <div id="userNameView"><p style="margin-left: 20px"><b>ім'я:</b><i> ${name}</i></p>

                    <p style="margin-left: 20px"><b>email:</b><i> ${email}</i></p>
                </div>
                <br>
                <br>

                <p class="edit_point">
                </p>

                <h3>Список моїх кафе</h3>
                <c:forEach items="${shopList}" var="shop">
                    <div>
                        <%--<form action="AboutShopServlet?shopId=${shop.id}" method="post">--%>
                            Кафе:
                            <%--<input type="submit" id="submitInfo5" name="information" value="про кафе">--%>
                            <a href="AboutShopServlet?shopId=${shop.id}"> ${shop.name}</a>
                        <%--</form>--%>
                    </div>
                </c:forEach>
            </form>
            <div id="newCafeBot">
                <form action="RedirectToAddShopServlet?userLogin=${userLogin}" enctype="multipart/form-data"
                      method="post">
                    <input type="submit" id="submitInfo5" name="add" value="Додати кафе">
                </form>
                <br>
            </div>
        </c:if>
        <c:if test='<%= session.getAttribute("isAuthenticated") == null || !(Boolean)session.getAttribute("isAuthenticated")%>'>
            <div>
                <p> Ви ще не авторизувались?</p>
                <a href=authorisation.jsp class="autoButton"> Увійти</a>
            </div>
        </c:if>
        <br>
    </div>
</div>
</body>
</html>
