package by.tms.project_flashcard_new.servlets;

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

@WebServlet("/alltopics")
public class GetAllCardsServlet extends HttpServlet {

    private CardService cardService;

    @Override
    public void init() {
        ServletContext context = getServletContext();
        cardService = (CardService) context.getAttribute("cardService");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Topic> topics = cardService.getTopics();

        String responseBody = topics.stream()
                .map(topic -> "%3s %-20s".formatted(
                        topic.getTopicId(),
                        topic.getTopicTitle()
                ))
                .collect(Collectors.joining("\n"));
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println(responseBody);
    }
}

