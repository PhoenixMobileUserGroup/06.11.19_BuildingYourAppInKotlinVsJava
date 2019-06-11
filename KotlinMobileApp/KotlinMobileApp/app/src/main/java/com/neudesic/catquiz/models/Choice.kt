package com.neudesic.catquiz.models

import com.neudesic.catquiz.enums.ChoiceStage
import com.neudesic.catquiz.enums.QuizType
import java.io.Serializable

class Choice( val text: String, val stage: ChoiceStage, val quizType: QuizType, var isSelected: Boolean = false): Serializable {
}