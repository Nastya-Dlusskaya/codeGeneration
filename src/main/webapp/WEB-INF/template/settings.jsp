<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link rel="stylesheet" href="assets/css/main.css"/>
    <title>Generator</title>
</head>
<body id="top">

<section id="banner">
    <div class="inner">
        <header>
            <h1>Настройки</h1>
        </header>
    </div>
</section>
<nav class="menu">
    <ul>
        <li>Перейти к </li>
        <li><a href="/databases">Базы данных</a></li>
    </ul>
</nav>
<div id="main">
    <div class="thumbnails">
        <%--@elvariable id="settingFile" type="by.bntu.fitr.service.dto.SettingFile"--%>
        <form:form method="post" action="/generations" modelAttribute="settingFile">
            <table>
                <tr>
                    <td><form:label path="databaseName">Имя базы данных</form:label></td>
                    <td><form:input path="databaseName" readonly="true"/></td>
                </tr>
                <tr>
                    <td><form:label path="tableName">Имя таблицы</form:label></td>
                    <td><form:input path="tableName" readonly="true"/></td>
                </tr>
                <tr>
                    <td><form:label path="packageName">Имя пакета</form:label></td>
                    <td><form:input path="packageName"/></td>
                </tr>
                <tr>
                    <td><form:label path="location">Расположение</form:label></td>
                    <td><form:input path="location" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <div class="inner">
                            <input type="submit" value="Генерировать" class="button fit"/>
                        </div>
                    </td>
                </tr>
            </table>
        </form:form>
    </div>
</div>

<!-- Footer -->
<footer id="footer">
    <div class="inner">
        <p class="copyright">&copy; Untitled. Design: Dluskaya A.</p>
    </div>
</footer>

<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/jquery.scrolly.min.js"></script>
<script src="assets/js/jquery.poptrox.min.js"></script>
<script src="assets/js/skel.min.js"></script>
<script src="assets/js/util.js"></script>
<script src="assets/js/main.js"></script>

</body>
</html>