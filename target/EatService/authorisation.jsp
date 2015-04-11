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
        <li role = "presentation"><a href = "shopList.jsp" role = "menuitem">Список кафе</a></li>
        <li role = "presentation"><a href = "profile.jsp" role = "menuitem">Профіль</a></li>

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
            <button id="submitInfo" type="submit"><p>Авторизуватися</p></button>
        </form>
        <p  class="edit_point" style="font-size: 20px;">Зареєтруватися:  <a href="registration.jsp"><img src="img/signup_icon.png" width="32" height="32"  /></a></p>
    </div>
</div>

</body>
</html>