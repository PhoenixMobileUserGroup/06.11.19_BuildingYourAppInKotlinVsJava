package com.neudesic.catquiz.models

import com.neudesic.catquiz.enums.ChoiceStage
import com.neudesic.catquiz.enums.QuizType
import java.io.Serializable

class Question(val text: String, val quizType: QuizType, val stage: ChoiceStage): Serializable {
}