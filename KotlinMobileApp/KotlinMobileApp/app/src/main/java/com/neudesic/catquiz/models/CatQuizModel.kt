package com.neudesic.catquiz.models

import com.neudesic.catquiz.enums.ChoiceStage
import com.neudesic.catquiz.enums.QuizType
import java.io.Serializable

class CatQuizModel(var completed: Boolean, var completionRate: Int, val quizType: QuizType, val quizText: String = ""): Serializable

object CatQuizModelStore {
    private lateinit var quizzes : List<CatQuizModel>
    private lateinit var quizChoices : HashMap<QuizType, List<Choice>>
    private lateinit var questions : HashMap<QuizType, List<Question>>

    fun loadQuizzes() {
        if (!(this::quizzes.isInitialized) && !(this::quizChoices.isInitialized) && !(this::questions.isInitialized)) {
            quizzes = listOf(
                CatQuizModel(false, 0, QuizType.GENERAL),
                CatQuizModel(false, 0, QuizType.FOOD)
            )
            quizChoices = hashMapOf(
                Pair(
                    QuizType.GENERAL, listOf<Choice>(
                        Choice("Brown", ChoiceStage.FIRST, QuizType.GENERAL),
                        Choice("Blonde", ChoiceStage.FIRST, QuizType.GENERAL),
                        Choice("Black", ChoiceStage.FIRST, QuizType.GENERAL),
                        Choice("Brown", ChoiceStage.SECOND, QuizType.GENERAL),
                        Choice("Green", ChoiceStage.SECOND, QuizType.GENERAL),
                        Choice("Blue", ChoiceStage.SECOND, QuizType.GENERAL),
                        Choice("Draw", ChoiceStage.THIRD, QuizType.GENERAL),
                        Choice("Play with Cats", ChoiceStage.THIRD, QuizType.GENERAL),
                        Choice("Hang out with friends", ChoiceStage.THIRD, QuizType.GENERAL)
                    )
                ),
                Pair(
                    QuizType.FOOD, listOf<Choice>(
                        Choice("Cereal", ChoiceStage.FIRST, QuizType.FOOD),
                        Choice("Eggs and Bacon", ChoiceStage.FIRST, QuizType.FOOD),
                        Choice("Something Fancy", ChoiceStage.FIRST, QuizType.FOOD),
                        Choice("Soup", ChoiceStage.SECOND, QuizType.FOOD),
                        Choice("Salad", ChoiceStage.SECOND, QuizType.FOOD),
                        Choice("Sandwich", ChoiceStage.SECOND, QuizType.FOOD),
                        Choice("Chicken", ChoiceStage.THIRD, QuizType.FOOD),
                        Choice("Mac n Cheese", ChoiceStage.THIRD, QuizType.FOOD),
                        Choice("Filet Mignon", ChoiceStage.THIRD, QuizType.FOOD)
                    )
                )
            )

            questions = hashMapOf(
                Pair(
                    QuizType.GENERAL, listOf<Question>(
                        Question("What color is your hair?", QuizType.GENERAL, ChoiceStage.FIRST),
                        Question("What color are your eyes?", QuizType.GENERAL, ChoiceStage.SECOND),
                        Question("What do you do in your free time?", QuizType.GENERAL, ChoiceStage.THIRD)
                    )
                ),
                Pair(
                    QuizType.FOOD, listOf<Question>(
                        Question("What do you eat for breakfast?", QuizType.FOOD, ChoiceStage.FIRST),
                        Question("What do you eat for lunch?", QuizType.FOOD, ChoiceStage.SECOND),
                        Question("What's for dinner?", QuizType.FOOD, ChoiceStage.THIRD)
                    )
                )
            )
        }
    }

    fun getQuizzes() = quizzes
    fun getQuizChoices () = quizChoices
    fun getQuestions() = questions
}