package by.tms.project_flashcard_new.servlets;

import by.tms.project_flashcard_new.models.FullTopic;
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

@WebServlet("/alltopics")
public class GetAllCardsServlet extends HttpServlet {

    private CardService cardService;

    @Override
    public void init() {
        ServletContext context = getServletContext();
        cardService = (CardService) context.getAttribute("cardService");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<FullTopic> topics = cardService.getTopicsWithCounts();

        request.setAttribute("topics", topics);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/templates/alltopics.jsp");
        dispatcher.forward(request, response);
    }
}

