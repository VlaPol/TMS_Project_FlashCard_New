<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.time.Year" %>

<html>
<head>
    <meta charset="UTF-8">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="../static/css/formating.css">

    <title>Наборы по темам:</title>

</head>
<body>

<table>
    <tr>
        <td>
            <img src="${pageContext.request.contextPath}/static/images/logo.png" width="50px" height="50px" align="left"
                 alt="logo">
        </td>
        <td></td>
        <td>
            <h2 align="center">
                Наборы по темам:
            </h2>
        </td>
    </tr>
</table>

<table>
    <tbody>
    <c:forEach var="topic" items="${topics}">
        <tr>
            <td id="text-cell1">
                <h5>
                    Тема: <c:out value="${topic.topicTitle}"/>
                </h5>
            </td>
            <form action="<c:url value="/training"/>" method="get" enctype="application/x-www-form-urlencoded">
                <td align="center">
                    <button type="submit" class="btn btn-primary" name="topicId" value="${topic.topicId}">Тренеровка</button>
                </td>
                <input type="hidden" name="offset" value="0">
            </form>
            <form action="<c:url value="/allquizzes"/>" method="get" enctype="application/x-www-form-urlencoded">
                <td align="center">
                    <button type="submit" class="btn btn-info" name="topicId" value="${topic.topicId}">Редактировать</button>
                </td>
            </form>
            <form action="<c:url value="/delete-topic"/>" method="post" enctype="application/x-www-form-urlencoded">
                <td align="center">
                    <button type="submit" class="btn btn-danger" name="topicId" value="${topic.topicId}">Удалить
                    </button>
                </td>
            </form>
        </tr>
    </c:forEach>

    <form action="<c:url value="/add-topic"/>" method="post" enctype="application/x-www-form-urlencoded">
        <tr>
            <td id="text-cell4">
                <h5>Новая тема: </h5>
            </td>
            <td>
                <label>
                    <input type="text" class="form-control" name="title" required>
                </label>
            </td>
            <td>
                <button type="submit" class="btn btn-success">Добавить</button>
            </td>
        </tr>
    </form>

    </tbody>
</table>


<footer fragment="footer" class="text-center fixed-bottom text-lg-start text-muted bg-dark">
    <br>
    <h5>(c) ${Year.now()}</h5>
</footer>
</body>
</html>
