package by.tms.project_flashcard_new.models;

public class Topic {

    private Long topicId;
    private String topicTitle;

    public Topic(Long topicId, String topicTitle){
        this.topicTitle = topicTitle;
        this.topicId = topicId;
    }
    public Topic(){}

    public Long getTopicId() {
        return topicId;
    }

    public String getTopicTitle() {
        return topicTitle;
    }

    @Override
    public String toString() {
        return
                "[" + topicId + "] " + topicTitle;
    }
}
