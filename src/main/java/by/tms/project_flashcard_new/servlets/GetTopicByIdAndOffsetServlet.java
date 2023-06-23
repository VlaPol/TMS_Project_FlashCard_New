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

@WebServlet("/training")
public class GetTopicByIdAndOffsetServlet extends HttpServlet {

    private CardService cardService;

    @Override
    public void init() {
        ServletContext context = getServletContext();
        cardService = (CardService) context.getAttribute("cardService");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long topicId = Long.valueOf(request.getParameter("topicId"));
        int offset = Integer.parseInt(request.getParameter("offset"));

        FullTopic topic = cardService.getTopicById(topicId);
        Quiz quiz = cardService.trainingTopic(topicId, offset);
        if (quiz.getQuizId() != null) {
            request.setAttribute("topic", topic);
            request.setAttribute("quiz", quiz);
            if (quiz.getIsRemembered()) {
                request.setAttribute("offset", offset);
            } else {
                request.setAttribute("offset", offset + 1);
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/templates/training.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() +"/allquizzes?topicId="+ topicId);
        }
    }
}

