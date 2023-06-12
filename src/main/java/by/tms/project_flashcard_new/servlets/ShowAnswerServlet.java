package by.tms.project_flashcard_new.servlets;

import by.tms.project_flashcard_new.models.FullTopic;
import by.tms.project_flashcard_new.models.Quiz;
import by.tms.project_flashcard_new.service.CardService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/show-answer")
public class ShowAnswerServlet extends HttpServlet {

    private CardService cardService;

    @Override
    public void init() {
        ServletContext context = getServletContext();
        cardService = (CardService) context.getAttribute("cardService");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        long quizId = Long.parseLong(request.getParameter("quizId"));
        long topicId = cardService.getTopicIdByQuizId(quizId);
        FullTopic topic = cardService.getTopicById(topicId);

        int offset = Integer.parseInt(request.getParameter("offset"));
        Quiz quiz = cardService.trainingTopic(quizId);

        if (quiz.getQuizId() != null) {
            request.setAttribute("topic", topic);
            request.setAttribute("quiz", quiz);
            request.setAttribute("offset", offset);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/templates/training_answ.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/allquizzes?topicId=" + topicId);
        }
    }
}

