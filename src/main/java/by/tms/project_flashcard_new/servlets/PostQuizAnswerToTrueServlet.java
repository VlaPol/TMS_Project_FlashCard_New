package by.tms.project_flashcard_new.servlets;

import by.tms.project_flashcard_new.models.Quiz;
import by.tms.project_flashcard_new.service.CardService;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/passquizz")
public class PostQuizAnswerToTrueServlet extends HttpServlet {

    private CardService cardService;

    @Override
    public void init() {
        ServletContext context = getServletContext();
        cardService = (CardService) context.getAttribute("cardService");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        long quizId = Long.parseLong(request.getParameter("quizId"));
        long topicId = Long.parseLong(request.getParameter("topicId"));
        cardService.updateQuizToTrue(quizId);
        response.sendRedirect("/allquizzes?topicId="+ topicId);

    }
}

