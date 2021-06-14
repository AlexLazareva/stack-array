<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Стек заполнен</title>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/assets/libs/bootstrap/css/bootstrap-grid.min.css" />
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/assets/libs/bootstrap/css/bootstrap-utilities.min.css" />
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/assets/libs/bootstrap/css/bootstrap-reboot.min.css" />
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/assets/libs/bootstrap/css/bootstrap.min.css" />
</head>
<body>
<div class="container container-fluid">
    <h1>Стек заполнен</h1>
    <form action="${pageContext.request.contextPath}/subsystem-task-manager" method="post">
        <button class="btn btn-success" type="submit">Вернуться на страницу</button>
    </form>
</div>
</body>
</html>
