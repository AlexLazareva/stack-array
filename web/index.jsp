
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Курсовая работа</title>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/assets/libs/bootstrap/css/bootstrap-grid.min.css" />
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/assets/libs/bootstrap/css/bootstrap-utilities.min.css" />
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/assets/libs/bootstrap/css/bootstrap-reboot.min.css" />
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/assets/libs/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/assets/styles/index.css" />
</head>
<body>
    <div class="container container-fluid">
        <h1>Задача «Процессы и потоки»</h1>
        <ul>
            <li>Информационные объекты: потоки выполнения процессов в ОС (свойства: НомерПотока, СостояниеПотока)</li>
            <li>Потоки объединяются в рамках объекта Процесс (свойство: НомерПроцесса)</li>
            <li>Процессы объединяются в рамках объекта-контейнера ПодсистемаУправленияЗадачами (свойство – тип ОС)</li>
        </ul>
        <h2>Вариант реализации контейнера</h2>
        <p>Объектная реализация контейнера на основе комбинированной структуры «Стек-массив динамических списков»</p>
        <form action="${pageContext.request.contextPath}/subsystem-task-manager" method="post">
            <button class="btn btn-success" type="submit">Перейти на страницу</button>
        </form>
    </div>
</body>
</html>
