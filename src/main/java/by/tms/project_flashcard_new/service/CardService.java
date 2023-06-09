package by.tms.project_flashcard_new.service;

import by.tms.project_flashcard_new.models.FullTopic;
import by.tms.project_flashcard_new.models.Quiz;
import by.tms.project_flashcard_new.models.Topic;

import java.util.List;

public interface CardService {

    FullTopic getTopicById(Long topicId);

    List<Topic> getTopics();

    List<FullTopic> getTopicsWithCounts();

    List<Quiz> getAllQuiz(Long topicId);

    Quiz trainingTopic(Long topicId, int offset);
    Quiz trainingTopic(Long quizId);

    void addNewTopic(String topic);

    void addNewQuiz(Long topicId, String question, String answer, boolean isRemembered);

    void removeTopic(Long topicId);

    void removeQuiz(Long quizId);

    void updateQuizToTrue(Long quizId);

    Long getTopicIdByQuizId(Long quizId);
}
