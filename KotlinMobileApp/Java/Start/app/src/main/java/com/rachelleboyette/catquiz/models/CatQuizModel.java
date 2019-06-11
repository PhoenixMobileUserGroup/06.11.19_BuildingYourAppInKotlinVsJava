package com.rachelleboyette.catquiz.models;

import com.rachelleboyette.catquiz.enums.QuizType;

import java.io.Serializable;

public class CatQuizModel implements Serializable {
    private boolean completed;
    private int completionRate;
    private QuizType quizType;
    private String quizText;

    public CatQuizModel(boolean completed, int completionRate, QuizType quizType, String quizText) {
        this.completed = completed;
        this.completionRate = completionRate;
        this.quizType = quizType;
        this.quizText = quizText;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public int getCompletionRate() {
        return completionRate;
    }

    public void setCompletionRate(int completionRate) {
        this.completionRate = completionRate;
    }

    public QuizType getQuizType() {
        return quizType;
    }

    public void setQuizType(QuizType quizType) {
        this.quizType = quizType;
    }

    public String getQuizText() {
        return quizText;
    }

    public void setQuizText(String quizText) {
        this.quizText = quizText;
    }
}