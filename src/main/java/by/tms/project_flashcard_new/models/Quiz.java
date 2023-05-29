package by.tms.project_flashcard_new.models;

public class Quiz {

    private Long quizId;
    private String question;
    private String answer;
    private boolean isRemembered;

    public Quiz(Long quizId, String question, String answer, boolean isRemembered) {
        this.quizId = quizId;
        this.question = question;
        this.answer = answer;
        this.isRemembered = isRemembered;
    }

    public Quiz() {
    }

    public Long getQuizId() {
        return quizId;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public boolean isRemembered() {
        return isRemembered;
    }

    @Override
    public String toString() {
        return "quizId=" + quizId +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", isRemembered=" + isRemembered;
    }
}
