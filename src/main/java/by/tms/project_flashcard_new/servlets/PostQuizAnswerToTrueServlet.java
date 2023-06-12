package by.tms.project_flashcard_new.servlets;

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
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/pass-quiz")
public class PostQuizAnswerToTrueServlet extends HttpServlet {

    private CardService cardService;

    @Override
    public void init() {
        ServletContext context = getServletContext();
        cardService = (CardService) context.getAttribute("cardService");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        long quizId = Long.parseLong(request.getParameter("quizId"));
        int offset = Integer.parseInt(request.getParameter("offset"));
        long topicId = cardService.getTopicIdByQuizId(quizId);

        if (offset != 0) {
            cardService.trainingTopic(topicId, offset);
        } else {
            cardService.updateQuizToTrue(quizId);
            cardService.trainingTopic(topicId, offset);
        }

        //       response.sendRedirect("/training?topicId=" + topicId);
        response.sendRedirect("/training?topicId=" + topicId + "&offset=" + offset);
    }
}

