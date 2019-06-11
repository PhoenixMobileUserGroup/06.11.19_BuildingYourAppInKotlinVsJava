package com.neudesic.catquiz.adapters

import android.content.Intent
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.neudesic.catquiz.R
import com.neudesic.catquiz.common.Constants
import com.neudesic.catquiz.enums.ChoiceStage
import com.neudesic.catquiz.enums.QuizType
import com.neudesic.catquiz.helpers.inflate
import com.neudesic.catquiz.models.CatQuizModel
import com.neudesic.catquiz.models.CatQuizModelStore
import com.neudesic.catquiz.views.CatQuizPageActivity
import kotlinx.android.synthetic.main.cat_quiz_listview_adapter.view.*

class CatQuizViewAdapter(private val catQuizzes: List<CatQuizModel>) : RecyclerView.Adapter<CatQuizViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.cat_quiz_listview_adapter))
    }

    override fun getItemCount() = catQuizzes.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(catQuizzes[position])
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener
    {
        private lateinit var catQuiz: CatQuizModel

        //TODO change this to the catQuiz stage vs setting manual stage
        override fun onClick(view: View?) {
            val context = view?.context
            val intent = Intent(context, CatQuizPageActivity::class.java)

            intent.putExtra(Constants.questions, CatQuizModelStore.getQuestions())
                    .putExtra(Constants.choice, CatQuizModelStore.getQuizChoices())
                    .putExtra(Constants.quizType, catQuiz.quizType)
                    .putExtra(Constants.stage, ChoiceStage.FIRST)

            context?.startActivity(intent)
        }

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(catQuiz: CatQuizModel) {
            this.catQuiz = catQuiz

            bindCompletionRate(this.catQuiz, itemView)
            bindQuizTypeText(this.catQuiz, itemView)
        }

        private fun bindQuizTypeText(catQuiz: CatQuizModel, itemView: View) {
            when(this.catQuiz.quizType) {
                QuizType.GENERAL -> itemView.quizButton.setText(R.string.general_quiz)
                QuizType.FOOD -> itemView.quizButton.setText(R.string.food_quiz)
            }
        }

        private fun bindCompletionRate(catQuiz: CatQuizModel, itemView: View) {
            itemView.catImageView.completionRate = catQuiz.completionRate
        }
    }
}