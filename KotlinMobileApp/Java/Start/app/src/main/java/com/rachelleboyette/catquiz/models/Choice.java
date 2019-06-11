package com.rachelleboyette.catquiz.models;

import com.rachelleboyette.catquiz.enums.ChoiceStage;
import com.rachelleboyette.catquiz.enums.QuizType;

import java.io.Serializable;

public class Choice implements Serializable {
    private String text;
    private ChoiceStage choiceStage;
    private QuizType quizType;
    private boolean isSelected;

    public Choice(String text, ChoiceStage choiceStage, QuizType quizType, boolean isSelected) {
        this.text = text;
        this.choiceStage = choiceStage;
        this.quizType = quizType;
        this.isSelected = isSelected;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ChoiceStage getChoiceStage() {
        return choiceStage;
    }

    public void setChoiceStage(ChoiceStage choiceStage) {
        this.choiceStage = choiceStage;
    }

    public QuizType getQuizType() {
        return quizType;
    }

    public void setQuizType(QuizType quizType) {
        this.quizType = quizType;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
