package com.neudesic.catquiz.helpers

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.neudesic.catquiz.enums.ChoiceStage
import com.neudesic.catquiz.enums.QuizType
import com.neudesic.catquiz.interfaces.CatDeterminator
import com.neudesic.catquiz.models.CatQuizModel
import com.neudesic.catquiz.models.Choice
import com.neudesic.catquiz.models.Question
import com.neudesic.catquiz.viewmodels.CatQuizViewModel
import com.neudesic.catquiz.viewmodels.CatResultViewModel

//TODO find a way to make this more generic
class CatQuizViewModelFactory(private val quiz: QuizType,
                              private val quizChoices: Map<QuizType, List<Choice>>,
                              private val quizQuestions : Map<QuizType, List<Question>>,
                              private val stage: ChoiceStage,
                              private val quizzes: List<CatQuizModel>) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CatQuizViewModel(quiz, quizChoices, quizQuestions, stage, quizzes) as T
    }
}

class CatResultViewModelFactory(private val catDeterminator : CatDeterminator) : ViewModelProvider.NewInstanceFactory () {
    override  fun  <T: ViewModel?> create(modelClass: Class<T>) : T {
        return CatResultViewModel(catDeterminator) as T
    }
}