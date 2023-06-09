package by.tms.project_flashcard_new.service;

import by.tms.project_flashcard_new.models.FullTopic;
import by.tms.project_flashcard_new.models.Quiz;
import by.tms.project_flashcard_new.models.Topic;

import java.util.List;

public interface CardService {

    Topic getTopicById(Long topicId);

    List<Topic> getTopics();

    List<FullTopic> getTopicsWithCounts();

    List<Quiz> getAllQuiz(Long topicId);

    Quiz getCardByIdAndOffset(Long topicId, int offset);

    void addNewTopic(String topic);

    void addNewQuiz(Long topicId, String question, String answer, boolean isRemembered);

    void removeTopic(Long topicId);

    void removeQuiz(Long quizId);

    void updateQuizToTrue(Long quizId);

    Long getTopicIdByQuizId(Long quizId);
}
