package models;

public class FAQ {
    private String question;
    private String answer;

    public FAQ(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public FAQ(int id, String question, String answer) {
    }

    public String getQuestion() { return question; }
    public String getAnswer() { return answer; }
}
