package com.neudesic.catquiz.viewmodels

import android.content.Context
import android.content.Intent
import android.provider.SyncStateContract
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.neudesic.catquiz.common.Constants
import com.neudesic.catquiz.enums.ChoiceStage
import com.neudesic.catquiz.enums.QuizType
import com.neudesic.catquiz.models.CatQuizModel
import com.neudesic.catquiz.models.CatQuizModelStore
import com.neudesic.catquiz.models.Choice
import com.neudesic.catquiz.models.Question
import com.neudesic.catquiz.views.CatQuizPageActivity
import com.neudesic.catquiz.views.CatResultPageActivity

class CatQuizViewModel(val quizType: QuizType,
                       val quizChoices : Map<QuizType, List<Choice>>,
                       val quizQuestions : Map<QuizType, List<Question>>,
                       val stage: ChoiceStage,
                       val quizzes: List<CatQuizModel>): ViewModel() {

    var isFirstDotViewActive : MutableLiveData<Boolean> = MutableLiveData()
    var isSecondDotViewActive : MutableLiveData<Boolean> = MutableLiveData()
    var isThirdDotViewActive : MutableLiveData<Boolean> = MutableLiveData()
    var questionText : MutableLiveData<String> = MutableLiveData()
    var firstChoiceText : MutableLiveData<String> = MutableLiveData()
    var secondChoiceText : MutableLiveData<String> = MutableLiveData()
    var thirdChoiceText : MutableLiveData<String> = MutableLiveData()

    init {
        setUpDotView()
        setUpQuestion()
        setUpChoices()
    }

    private fun setUpQuestion() {
        val question = quizQuestions[quizType]?.first { it -> it.stage == stage }

        if (question != null) {
            questionText.value = question.text
        }
    }

    private fun setUpChoices() {
        val choices = quizChoices[quizType]
        val choicesByStage = choices!!.filter { it.stage == stage}

        // This really should be a repeater view
        firstChoiceText.value = choicesByStage[0].text
        secondChoiceText.value = choicesByStage[1].text
        thirdChoiceText.value = choicesByStage[2].text

    }

    private fun setUpDotView() {
        when (stage) {
            ChoiceStage.FIRST -> {
                isFirstDotViewActive.value = true
                isSecondDotViewActive.value = false
                isThirdDotViewActive.value = false
            }
            ChoiceStage.SECOND -> {
                isFirstDotViewActive.value = false
                isSecondDotViewActive.value = true
                isThirdDotViewActive.value = false
            }

            ChoiceStage.THIRD -> {
                isFirstDotViewActive.value = false
                isSecondDotViewActive.value = false
                isThirdDotViewActive.value = true
            }
        }
    }

    fun onButtonClicked(text: String, context: Context) {
        setChoiceSelection(text)
        val questionStage: ChoiceStage?

        when (stage) {
            ChoiceStage.FIRST -> {
                questionStage = ChoiceStage.SECOND
            }
            ChoiceStage.SECOND -> {
                questionStage = ChoiceStage.THIRD
            }
            ChoiceStage.THIRD -> {
                questionStage = null
                navigateToResultPage(context)
            }
        }

        setCompletionRate(questionStage, quizType)

        if (questionStage != null) {
            val intent = Intent(context, CatQuizPageActivity::class.java)
            intent.putExtra(Constants.questions, CatQuizModelStore.getQuestions())
                .putExtra(Constants.choice, CatQuizModelStore.getQuizChoices())
                .putExtra(Constants.quizType, quizType)
                .putExtra(Constants.stage, questionStage)
            context.startActivity(intent)
        }
    }

    private fun setCompletionRate(questionStage: ChoiceStage?, quizType: QuizType) {
        when(questionStage) {
            ChoiceStage.FIRST -> {
                quizzes.first { it.quizType == quizType }.completionRate = 25
            }
            ChoiceStage.SECOND -> {
                quizzes.first{ it.quizType == quizType}.completionRate = 50
            }
            //this logic is wrong. todo feel free to fix it!
            ChoiceStage.THIRD -> {
                quizzes.first{ it.quizType == quizType}.completionRate = 100
                quizzes.first{ it.quizType == quizType}.completed = true
            }
        }
    }

    private fun setChoiceSelection(text: String) {
        val choices = quizChoices[quizType]
        val choicesByStage = choices!!.filter { it.stage == stage}

        val toggledChoice = choicesByStage.first { it.text == text }
        toggledChoice.isSelected = !toggledChoice.isSelected
    }

    private fun navigateToResultPage(context: Context) {
        val intent = Intent(context, CatResultPageActivity::class.java)
        context.startActivity(intent)
    }
}