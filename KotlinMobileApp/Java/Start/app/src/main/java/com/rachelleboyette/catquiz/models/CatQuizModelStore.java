package com.rachelleboyette.catquiz.models;

import com.rachelleboyette.catquiz.enums.ChoiceStage;
import com.rachelleboyette.catquiz.enums.QuizType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CatQuizModelStore {
    private static boolean hasInitialized = false;
    private static List<CatQuizModel> quizzes;
    private static HashMap<QuizType, List<Choice>> quizChoices;
    private static HashMap<QuizType, List<Question>> questions;

    public static void loadQuizzes() {
        if (!hasInitialized) {
            quizzes = new ArrayList<>();
            quizzes.add(new CatQuizModel(false, 0, QuizType.GENERAL, ""));
            quizzes.add(new CatQuizModel(false, 0, QuizType.FOOD, ""));


            quizChoices = new HashMap<>();
            List<Choice> generalChoices = new ArrayList<>();
            List<Choice> foodChoices = new ArrayList<>();

            generalChoices.add(new Choice("Brown", ChoiceStage.FIRST, QuizType.GENERAL, false));
            generalChoices.add(new Choice("Blonde", ChoiceStage.FIRST, QuizType.GENERAL, false));
            generalChoices.add(new Choice("Black", ChoiceStage.FIRST, QuizType.GENERAL, false));
            generalChoices.add(new Choice("Brown", ChoiceStage.SECOND, QuizType.GENERAL, false));
            generalChoices.add(new Choice("Green", ChoiceStage.SECOND, QuizType.GENERAL, false));
            generalChoices.add(new Choice("Blue", ChoiceStage.SECOND, QuizType.GENERAL, false));
            generalChoices.add(new Choice("Draw", ChoiceStage.THIRD, QuizType.GENERAL, false));
            generalChoices.add(new Choice("Play with Cats", ChoiceStage.THIRD, QuizType.GENERAL, false));
            generalChoices.add(new Choice("Hang out with friends", ChoiceStage.THIRD, QuizType.GENERAL, false));

            foodChoices.add(new Choice("Cereal", ChoiceStage.FIRST, QuizType.FOOD, false));
            foodChoices.add(new Choice("Eggs and Bacon", ChoiceStage.FIRST, QuizType.FOOD, false));
            foodChoices.add(new Choice("Something Fancy", ChoiceStage.SECOND, QuizType.FOOD, false));
            foodChoices.add(new Choice("Soup", ChoiceStage.SECOND, QuizType.FOOD, false));
            foodChoices.add(new Choice("Salad", ChoiceStage.SECOND, QuizType.FOOD, false));
            foodChoices.add(new Choice("Sandwich", ChoiceStage.SECOND, QuizType.FOOD, false));
            foodChoices.add(new Choice("Chicken", ChoiceStage.THIRD, QuizType.FOOD, false));
            foodChoices.add(new Choice("Mac n Cheese", ChoiceStage.THIRD, QuizType.FOOD, false));
            foodChoices.add(new Choice("Filet Mignon", ChoiceStage.THIRD, QuizType.FOOD, false));

            quizChoices.put(QuizType.GENERAL, generalChoices);
            quizChoices.put(QuizType.FOOD, foodChoices);

            questions = new HashMap<>();
            List<Question> generalQuestions = new ArrayList<>();
            generalQuestions.add(new Question("What color is your hair?", QuizType.GENERAL, ChoiceStage.FIRST));
            generalQuestions.add(new Question("What color are your eyes?", QuizType.GENERAL, ChoiceStage.SECOND));
            generalQuestions.add(new Question("What do you do in your free time?", QuizType.GENERAL, ChoiceStage.THIRD));

            List<Question> foodQuestions = new ArrayList<>();
            foodQuestions.add(new Question("What do you eat for breakfast?", QuizType.FOOD, ChoiceStage.FIRST));
            foodQuestions.add(new Question("What do you eat for lunch?", QuizType.FOOD, ChoiceStage.SECOND));
            foodQuestions.add(new Question("What's for dinner?", QuizType.FOOD, ChoiceStage.THIRD));

            questions.put(QuizType.GENERAL, generalQuestions);
            questions.put(QuizType.FOOD, foodQuestions);

            hasInitialized = true;
        }
    }

    public static List<CatQuizModel> getQuizzes() {
        return quizzes;
    }

    public static HashMap<QuizType, List<Choice>> getQuizChoices() {
        return quizChoices;
    }

    public static HashMap<QuizType, List<Question>> getQuestions() {
        return questions;
    }
}