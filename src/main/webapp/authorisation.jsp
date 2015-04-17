<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta charset="utf-8f">
    <link href="style.css" rel="stylesheet" type="text/css">
    <title> Авторизаційна форма</title>
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
        <h2><b>Введіть ваші дані</b></h2>
        <form action="AuthorisationServlet" method="post" style="align-text: center">
            <p class="edit_point">Логін</p>
            <p class="edit_point"><input id="userLogin" name="userLogin"  type="text" placeholder="Введіть логін" required></p>
            <p class="edit_point">Пароль</p>
            <p class="edit_point"><input id="password" name="password" type="text" placeholder="Введіть пароль"></p>
            <%--<form action="RedirectToProfileServlet?userLogin=${userLogin}"--%>
                  <%--method="post">--%>
                <%--<input type="submit" id="submitInfo5" name="add" value="Авторизуватися">--%>
            <%--</form>--%>
            <button id="submitInfo3" type="submit" ><p>Авторизуватися</p></button>
            <a id="signUplink" href="registration.jsp" title="SignUp"><img src="img/signup_icon.png" width="40" height="40"/></a>
        </form>
        <br>


    </div>
</div>

</body>
</html>