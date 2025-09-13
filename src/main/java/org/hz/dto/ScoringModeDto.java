package org.hz.dto;

import java.util.List;

public class ScoringModeDto {
    private String question;

    private List<String> answers;

    private List<TextSegmentDto> textSegments;

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

    public List<TextSegmentDto> getTextSegments() {
        return textSegments;
    }

    public void setTextSegments(List<TextSegmentDto> textSegments) {
        this.textSegments = textSegments;
    }

}
