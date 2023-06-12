<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.time.Year" %>

<html>
<head>
    <meta charset="UTF-8">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="../static/css/formating.css">

    <title>Тренеровка</title>

</head>
<body>

<table>
    <tr>
        <td>
            <img src="${pageContext.request.contextPath}/static/images/logo.png" width="50px" height="50px" align="left"
                 alt="logo">
        </td>
    </tr>
    <tr>
        <td>
            <h5>
                Тренеровка по теме: <c:out value="${topic.topicTitle}"/>
            </h5>
        </td>
    </tr>
    <tr>
        <td>
            <h5>
                Выучено слов: <c:out value="${topic.learned}"/> из <c:out value="${topic.total}"/>
            </h5>
        </td>
    </tr>
</table>

<table>
    <tbody>
    <tr>
        <td>
            <div class="card text-dark bg-info mb-1" style="width: 15rem; height: 10rem">
                <div class="card-body">
                    <h5 align="center">
                        <c:out value="${quiz.question}"/>
                    </h5>
                </div>
            </div>
        </td>
        <td></td>
        <td align="center">

            <div class="btn-group-vertical">

                <form action="<c:url value="/delete-quiz"/>" method="post" enctype="application/x-www-form-urlencoded">
                    <button type="submit" class="btn btn-info" name="quizId" value="${quiz.quizId}">
                        Повернуть
                    </button>
                </form>

                <form action="<c:url value="/pass-quiz"/>" method="post" enctype="application/x-www-form-urlencoded">
                    <button type="submit" class="btn btn-success custom-button" name="quizId" value="${quiz.quizId}">
                        Знаю
                    </button>
                    <input type="hidden" name="offset" value="0">
                </form>

                <form action="<c:url value="/pass-quiz"/>" method="post" enctype="application/x-www-form-urlencoded">
                    <button type="submit" class="btn btn-danger custom-button" name="quizId" value="${quiz.quizId}">
                        Незнаю
                    </button>
                    <input type="hidden" name="offset" value="${offset}">
                </form>
            </div>

        </td>
    </tr>
    </tbody>
</table>
<form action="<c:url value="/back"/>" method="post" enctype="application/x-www-form-urlencoded">
    <tr>
        <td>
            <button type="submit" class="btn btn-outline-secondary">На главную</button>
        </td>
    </tr>
</form>

<footer fragment="footer" class="text-center fixed-bottom text-lg-start text-muted bg-dark">
    <br>
    <h5>(c) ${Year.now()}</h5>
</footer>
</body>
</html>
