<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
            <h1>Базы данных</h1>
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
    <div class="inner">
        <div class="thumbnails">
            <c:forEach items="${list}" var="item">
                <div class="box">
                    <div class="inner">
                        <h3>${item.name}</h3>
                        <a href="/tables?database=<c:out value="${item.name}"/>" class="button fit">Детали</a>
                    </div>
                </div>
            </c:forEach>
        </div>
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
