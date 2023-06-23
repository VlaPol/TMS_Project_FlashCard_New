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
    </tr>
    <tr>
        <td>
            <h3 align="center">
                Тема: <c:out value="${topic.topicTitle}"/>
            </h3>
        </td>
    </tr>
</table>
<hr>
<table>
    <thead>
    <tr>
        <td align="center"><h3>Вопрос</h3></td>
        <td align="center"><h3>Ответ</h3></td>

    </tr>
    </thead>
    <tbody>
    <c:forEach var="quiz" items="${quizzes}">
        <tr>
            <td>
                <div class="card text-dark bg-info mb-3" style="max-width: 18rem;">
                    <div class="card-body">
                        <h5>
                            <c:out value="${quiz.question}"/>
                        </h5>
                    </div>
                </div>
            </td>
            <td>
                <div class="card text-dark bg-success mb-3" style="max-width: 18rem;">
                    <div class="card-body">
                        <h5>
                            <c:out value="${quiz.answer}"/>
                        </h5>
                    </div>
                </div>
            </td>
            <td align="right">
                <div class="card text-dark bg-light mb-3" style="max-width: 18rem;">
                    <div class="card-body">
                        <c:choose>
                            <c:when test="${quiz.isRemembered}">
                                <h5>
                                    <input class="form-check-input" type="checkbox" value="" aria-label="Знаю"
                                           checked>
                                    Знаю
                                </h5>
                            </c:when>

                            <c:otherwise>
                                <h5>
                                    <input class="form-check-input" type="checkbox" value="" aria-label="Знаю">
                                    Знаю
                                </h5>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </td>
            <td align="center">
                <form action="<c:url value="/delete-quiz"/>" method="post" enctype="application/x-www-form-urlencoded">
                    <button type="submit" class="btn btn-danger" name="quizId" value="${quiz.quizId}">Удалить
                    </button>
                </form>
            </td>
        </tr>
    </c:forEach>
    <form action="<c:url value="/add-quiz"/>" method="post" enctype="application/x-www-form-urlencoded">
        <tr>
            <td align="center">
                <h6>вопрос</h6>
                <label>
                    <input type="text" class="form-control" name="question" required>
                </label>
            </td>
            <td align="center">
                <h6>ответ</h6>
                <label>
                    <input type="text" class="form-control" name="answer" required>
                </label>
            </td>
            <td>
                <input type="hidden" id="topicId" name="topicId" value="${topic.topicId}">
            </td>
            <td>
                <p></p>
                <button type="submit" class="btn btn-success">Добавить</button>
            </td>
        </tr>
    </form>

    <form action="<c:url value="/back"/>" method="post" enctype="application/x-www-form-urlencoded">
        <tr>
            <td>
                <button type="submit" class="btn btn-outline-secondary">На главную</button>
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
