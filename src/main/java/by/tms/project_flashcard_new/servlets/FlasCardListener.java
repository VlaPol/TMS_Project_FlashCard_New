package by.tms.project_flashcard_new.servlets;

import by.tms.project_flashcard_new.repository.CardRepository;
import by.tms.project_flashcard_new.repository.CardRepositoryImpl;
import by.tms.project_flashcard_new.service.CardServiceImpl;
import com.zaxxer.hikari.HikariDataSource;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

import static by.tms.project_flashcard_new.utils.DBConnection.*;

public class FlasCardListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent event) {
        HikariDataSource dataSource = new HikariDataSource(getHikariConfig());

        CardRepository cardRepo = new CardRepositoryImpl(dataSource);
        CardServiceImpl cardService = new CardServiceImpl(cardRepo);

        ServletContext context = event.getServletContext();
        context.setAttribute("dataSource", dataSource);
        context.setAttribute("cardService", cardService);
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        ServletContext context = event.getServletContext();
        HikariDataSource dataSource = (HikariDataSource) context.getAttribute("dataSource");
        dataSource.close();
    }
}
