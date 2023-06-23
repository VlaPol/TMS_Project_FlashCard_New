package by.tms.project_flashcard_new.servlets;

import by.tms.project_flashcard_new.models.Topic;
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

@WebServlet("/delete-topic")
public class DeletelCardServlet extends HttpServlet {

    private CardService cardService;

    @Override
    public void init() {
        ServletContext context = getServletContext();
        cardService = (CardService) context.getAttribute("cardService");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        long topicId = Long.parseLong(request.getParameter("topicId"));
        cardService.removeTopic(topicId);
        response.sendRedirect("/alltopics");

    }
}

