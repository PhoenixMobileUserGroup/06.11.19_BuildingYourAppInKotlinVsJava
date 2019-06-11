package com.neudesic.catquiz.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.neudesic.catquiz.R
import com.neudesic.catquiz.common.Constants
import com.neudesic.catquiz.databinding.CatQuizPageBinding
import com.neudesic.catquiz.enums.ChoiceStage
import com.neudesic.catquiz.enums.QuizType
import com.neudesic.catquiz.helpers.CatQuizViewModelFactory
import com.neudesic.catquiz.models.CatQuizModelStore
import com.neudesic.catquiz.models.Choice
import com.neudesic.catquiz.models.Question
import com.neudesic.catquiz.viewmodels.CatQuizViewModel
import kotlinx.android.synthetic.main.cat_quiz_page.*

class CatQuizPageActivity : AppCompatActivity() {
    private lateinit var catQuizPageViewModel : CatQuizViewModel
    private lateinit var binding: CatQuizPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.cat_quiz_page)

        initializeViewModel()
        setBindings()

    }

    private fun initializeViewModel() {
        val quiz: QuizType = intent!!.getSerializableExtra(Constants.quizType) as QuizType
        val choices : Map<QuizType, List<Choice>> = intent.getSerializableExtra(Constants.choice) as Map<QuizType, List<Choice>>
        val stage : ChoiceStage = intent.getSerializableExtra(Constants.stage) as ChoiceStage
        val questions : Map<QuizType, List<Question>> = intent.getSerializableExtra(Constants.questions) as Map<QuizType, List<Question>>

        catQuizPageViewModel = ViewModelProviders.of(this, CatQuizViewModelFactory(quiz, choices, questions, stage, CatQuizModelStore.getQuizzes())).get(CatQuizViewModel::class.java)
        binding.viewmodel = catQuizPageViewModel
    }

    private fun setBindings() {
        firstChoiceButton.setOnClickListener {
            catQuizPageViewModel.onButtonClicked(firstChoiceButton.text.toString(), it.context)
        }

        secondChoiceButton.setOnClickListener {
            catQuizPageViewModel.onButtonClicked(secondChoiceButton.text.toString(), it.context)
        }

        thirdChoiceButton.setOnClickListener {
            catQuizPageViewModel.onButtonClicked(thirdChoiceButton.text.toString(), it.context)
        }
    }
}