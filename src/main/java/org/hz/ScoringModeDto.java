package org.hz;

import java.util.List;

import dev.langchain4j.data.segment.TextSegment;

public class ScoringModeDto {
    private String question;

    private List<String> answers;

    private List<TextSegment> textSegments;

    private String answer;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public List<TextSegment> getTextSegments() {
        return textSegments;
    }

    public void setTextSegments(List<TextSegment> textSegments) {
        this.textSegments = textSegments;
    }

}
