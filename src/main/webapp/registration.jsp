<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="utf-8f">
    <link href="style.css" rel="stylesheet" type="text/css">
    <title> Реєстрація нового клієнта</title>
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

        <h2><b>Реєстрація</b></h2>
        <br>
        <form enctype="multipart/form-data" action="RegistrationServlet"  method="post" style="align-text: center">
            <p class="edit_point">Логін</p>
            <p class="edit_point"><input id="userLogin" name="userLogin" type="text" placeholder="Введіть бажаний логін" ></p>
            <p class="edit_point">Пароль</p>
            <p class="edit_point"><input id="password" name="password" type="text" placeholder="Введіть свій пароль"></p>
            <p class="edit_point">Емейл</p>
            <p class="edit_point"><input id="email" name="email" type="text" placeholder="Введіть свій email"></p>
            <p class="edit_point">Справжнє ім'я</p>
            <p class="edit_point"><input id="name" name="name" type="text" placeholder="Введіть своє ім'я"></p>
            <p class="edit_point">Фото</p>
            <p class="edit_point"><input class="photo" name="userPhoto"  id="photoUser" type="file" accept="image/*" size = "50px" /></p>
            <p class="edit_point"><input type = "submit" name = "register" value="Зареєструватись"></p>
            <p class="edit_point"><input type = "submit" name = "cancel" value="Скасувати"></p>

            <%--<button type="button" onclick="history.back()"><a href=""><img src="img/cancel.png"  /></a></button>--%>
                <%--<button  id="submitAddUser" type="submit"><p >Зареєструватись</p></button></p>--%>
        </form>
    </div>
</div>
</body>
</html>
