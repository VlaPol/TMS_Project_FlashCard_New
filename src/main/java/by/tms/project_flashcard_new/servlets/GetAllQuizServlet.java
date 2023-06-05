package by.tms.project_flashcard_new.servlets;

import by.tms.project_flashcard_new.models.Quiz;
import by.tms.project_flashcard_new.models.Topic;
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

@WebServlet("/allquizzes")
public class GetAllQuizServlet extends HttpServlet {

    private CardService cardService;

    @Override
    public void init() {
        ServletContext context = getServletContext();
        cardService = (CardService) context.getAttribute("cardService");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long topicId = Long.valueOf(request.getParameter("topicId"));

        List<Quiz> quizzes = cardService.getAllQuiz(topicId);

        String responseBody = quizzes.stream()
                .map(quiz -> "%3s %-20s %-20s %-20s".formatted(
                        quiz.getQuizId(),
                        quiz.getQuestion(),
                        quiz.getAnswer(),
                        quiz.isRemembered()
                ))
                .collect(Collectors.joining("\n"));
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println(responseBody);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        long topicId = Long.parseLong(request.getParameter("topicId"));
        String question = request.getParameter("question");
        String answer = request.getParameter("answer");

        cardService.addNewQuiz(topicId, question, answer, false);
        response.sendRedirect("/allquizzes?topicId="+ topicId);

    }

    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        long quizId = Long.parseLong(request.getParameter("quizId"));
        long topicId = Long.parseLong(request.getParameter("topicId"));
        cardService.removeQuiz(quizId);
        response.sendRedirect("/allquizzes?topicId="+ topicId);

    }
}

