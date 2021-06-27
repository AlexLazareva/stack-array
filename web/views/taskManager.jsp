<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Подсистема Управления Задачами</title>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/assets/libs/bootstrap/css/bootstrap-grid.min.css" />
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/assets/libs/bootstrap/css/bootstrap-utilities.min.css" />
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/assets/libs/bootstrap/css/bootstrap-reboot.min.css" />
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/assets/libs/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/assets/styles/index.css" />
</head>
<body>
    <div class="container container-fluid">
        <h1>Контейнер "Подсистема Управления Задачами"</h1>
        <h2>Структура данных "Стек-массив"</h2>
        <p>Тип ОС: <span id="systemType"></span></p>
        <div class="buttons">
            <form id="#subsystem-form" action="${pageContext.request.contextPath}/add-process" method="post">
                <label for="processName">
                    Название процесса
                </label>
                <input type="text" name="processName" id="processName" placeholder="Введите название нового процесса" class="form-control">
                <button id="add-process" class="btn btn-success">Добавить процесс</button>
            </form>
        </div>
        <table class="table table-dark table-striped">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Process</th>
                <th scope="col">Количество потоков</th>
            </tr>
            </thead>
            <tbody id="table-body">
            </tbody>
        </table>
        <p id="empty-message">
            Элементы в стеке отсутствуют
        </p>
        <div class="buttons-wrapper hide">
            <form id="peek-form" action="${pageContext.request.contextPath}/process-page" method="post">
                <button id="edit" class="btn btn-success edit-btn">Редактировать вершину стека</button>
            </form>
            <form id="pop-form" action="${pageContext.request.contextPath}/pop-process" method="post">
                <button id="remove" class="btn btn-danger">
                    <svg xmlns="http://www.w3.org/2000/svg" width="26" height="26" fill="currentColor" class="bi bi-x-lg" viewBox="0 0 16 16">
                        <path d="M1.293 1.293a1 1 0 0 1 1.414 0L8 6.586l5.293-5.293a1 1 0 1 1 1.414 1.414L9.414 8l5.293 5.293a1 1 0 0 1-1.414 1.414L8 9.414l-5.293 5.293a1 1 0 0 1-1.414-1.414L6.586 8 1.293 2.707a1 1 0 0 1 0-1.414z"/>
                    </svg>
                </button>
            </form>
        </div>
    </div>
    <div id="loader" class="loader show">
        <img src="${pageContext.servletContext.contextPath}/assets/img/load.gif" height="300" width="300" alt="loader">
    </div>
    <script src="${pageContext.servletContext.contextPath}/assets/libs/jquery-3.6.0.min.js" type="text/javascript"></script>
    <script src="${pageContext.servletContext.contextPath}/assets/js/main.js" type="text/javascript"></script>
</body>
</html>
