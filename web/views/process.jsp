<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Поток</title>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/assets/libs/bootstrap/css/bootstrap-grid.min.css" />
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/assets/libs/bootstrap/css/bootstrap-utilities.min.css" />
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/assets/libs/bootstrap/css/bootstrap-reboot.min.css" />
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/assets/libs/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/assets/styles/index.css" />
</head>
<body>
<div class="container container-fluid">
    <form action="${pageContext.request.contextPath}/subsystem-task-manager" method="post">
        <button class="btn btn-outline-primary" type="submit">Вернуться назад</button>
    </form>
    <h1>Процесс</h1>
    <h2>Структура данных "Динамический список"</h2>
    <p>Имя процесса: <span id="processName"></span></p>
    <p>ID процесса: <span id="processId"></span></p>
    <div class="process-form">
        <form id="#subsystem-form" action="${pageContext.request.contextPath}/add-thread" method="post">
            <h3>Добавление нового потока</h3>
            <div class="process-form__add">
                <div class="form-check-inline">
                    <label for="addFirst" class="form-check-label">Добавить в начало</label>
                    <input type="radio" class="form-check-input" name="threadAddType" id="addFirst" value="addFirst">
                </div>
                <div class="form-check-inline">
                    <label for="addLast" class="form-check-label">Добавить в конец</label>
                    <input type="radio" class="form-check-input" name="threadAddType" id="addLast" value="addLast">
                </div>
            </div>
            <button id="add-process" class="btn btn-success">Добавить поток</button>
        </form>
    </div>
    <table class="table table-dark table-striped">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Поток</th>
            <th scope="col">Состояние потока</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody id="table-body">
        </tbody>
    </table>
    <div class="buttons-wrapper">
            <button class="btn btn-success" onclick="downloadThread('${pageContext.request.contextPath}')">Выгрузить в файл</button>
            <button class="btn btn-success" onclick="uploadThread('${pageContext.request.contextPath}')">Загрузить из файла</button>
    </div>
</div>
<script src="${pageContext.servletContext.contextPath}/assets/libs/jquery-3.6.0.min.js" type="text/javascript"></script>
<script src="${pageContext.servletContext.contextPath}/assets/js/process.js" type="text/javascript"></script>
</body>
</html>
