<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Departments</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="css/bootstrap.css" />" rel="stylesheet">
    <link rel='stylesheet' href='css/bootstrap.css' type='text/css' media='screen'>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<div class="alert alert-success" role="alert">Вы успешно дочитали до этого места</div>
<div class="alert alert-info" role="alert">Это ещё не конец статьи</div>
<div class="alert alert-warning" role="alert">Читать мало, нужно всё применять на практике</div>
<div class="alert alert-danger" role="alert">Да, это не смешно</div>

<button type="button" class="btn btn-default">Кнопка</button>
<button type="button" class="btn btn-primary">Основная</button>
<button type="button" class="btn btn-success">Успех</button>
<button type="button" class="btn btn-info">Информация</button>
<button type="button" class="btn btn-warning">Внимание</button>
<button type="button" class="btn btn-danger">Ошибка</button>
<button type="button" class="btn btn-link">Ссылка</button>

<div class="container" style="width: 300px;">
    <form action="/department/add" method="post">
        <h1 class="">Please sign in</h1>
        <input type="text" class="form-control" name="j_username" placeholder="Email address" required autofocus
               value="colibri">
        <input type="password" class="form-control" name="j_password" placeholder="Password" required value="1234">
        <button class="btn-amazing" type="submit">Войти</button>
    </form>
</div>

</body>
</html>
