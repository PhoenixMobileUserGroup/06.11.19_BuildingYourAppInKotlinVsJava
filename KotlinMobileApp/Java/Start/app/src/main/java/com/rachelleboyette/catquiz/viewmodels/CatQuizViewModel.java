package com.rachelleboyette.catquiz.viewmodels;

import androidx.lifecycle.ViewModel;

import com.rachelleboyette.catquiz.enums.ChoiceStage;
import com.rachelleboyette.catquiz.enums.QuizType;
import com.rachelleboyette.catquiz.models.CatQuizModel;
import com.rachelleboyette.catquiz.models.Choice;
import com.rachelleboyette.catquiz.models.Question;

import java.util.List;
import java.util.Map;

public class CatQuizViewModel extends ViewModel {
    private QuizType quizType;
    private Map<QuizType, List<Choice>> quizChoices;
    private Map<QuizType, List<Question>> questions;
    private ChoiceStage stage;
    private List<CatQuizModel> quizzes;

    public CatQuizViewModel(QuizType quizType, Map<QuizType, List<Choice>> quizChoices, Map<QuizType, List<Question>> questions, ChoiceStage stage, List<CatQuizModel> quizzes) {
        this.quizType = quizType;
        this.quizChoices = quizChoices;
        this.questions = questions;
        this.stage = stage;
        this.quizzes = quizzes;
    }


}
