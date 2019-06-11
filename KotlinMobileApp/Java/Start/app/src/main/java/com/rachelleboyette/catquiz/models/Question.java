package com.rachelleboyette.catquiz.models;

import com.rachelleboyette.catquiz.enums.ChoiceStage;
import com.rachelleboyette.catquiz.enums.QuizType;

import java.io.Serializable;

public class Question implements Serializable {
    private String text;
    private QuizType quizType;
    private ChoiceStage choiceStage;

    public Question(String text, QuizType quizType, ChoiceStage choiceStage) {
        this.text = text;
        this.quizType = quizType;
        this.choiceStage = choiceStage;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public QuizType getQuizType() {
        return quizType;
    }

    public void setQuizType(QuizType quizType) {
        this.quizType = quizType;
    }

    public ChoiceStage getChoiceStage() {
        return choiceStage;
    }

    public void setChoiceStage(ChoiceStage choiceStage) {
        this.choiceStage = choiceStage;
    }
}
