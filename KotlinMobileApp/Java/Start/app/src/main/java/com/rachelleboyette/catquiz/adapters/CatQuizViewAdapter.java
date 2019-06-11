package com.rachelleboyette.catquiz.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rachelleboyette.catquiz.R;
import com.rachelleboyette.catquiz.common.Constants;
import com.rachelleboyette.catquiz.customviews.CatQuizCompletionView;
import com.rachelleboyette.catquiz.enums.ChoiceStage;
import com.rachelleboyette.catquiz.models.CatQuizModel;
import com.rachelleboyette.catquiz.models.CatQuizModelStore;
import com.rachelleboyette.catquiz.views.CatQuizPageActivity;

import java.util.List;

public class CatQuizViewAdapter extends RecyclerView.Adapter<CatQuizViewAdapter.ViewHolder> {

    private List<CatQuizModel> catQuizModels;
    public CatQuizViewAdapter(List<CatQuizModel> catQuizModelList) {
        this.catQuizModels = catQuizModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cat_quiz_listview_adapter, parent));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(catQuizModels.get(position));
    }

    @Override
    public int getItemCount() {
        return catQuizModels.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private CatQuizModel catQuizModel;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        @Override
        public void onClick(View view) {
            Context context = view.getContext();

            Intent intent = new Intent(context, CatQuizPageActivity.class);
            intent.putExtra(Constants.questions, CatQuizModelStore.getQuestions())
                    .putExtra(Constants.choice, CatQuizModelStore.getQuizChoices())
                    .putExtra(Constants.quizType, catQuizModel.getQuizType())
                    .putExtra(Constants.stage, ChoiceStage.FIRST);
            context.startActivity(intent);
        }

        public void bind(CatQuizModel catQuizModel) {
            this.catQuizModel = catQuizModel;

            bindCompletionRate(this.catQuizModel, itemView);
            bindQuizType(this.catQuizModel, itemView);
        }

        private void bindQuizType(CatQuizModel catQuizModel, View itemView) {
            Button button = itemView.findViewById(R.id.quizButton);
            switch(catQuizModel.getQuizType()) {
                case GENERAL:
                    button.setText(R.string.general_quiz);
                    break;
                case FOOD:
                    button.setText(R.string.food_quiz);
                    break;
                default:
                    break;
            }
        }

        private void bindCompletionRate(CatQuizModel catQuizModel, View itemView) {
            CatQuizCompletionView completionView = itemView.findViewById(R.id.catImageView);
            completionView.setCompletionRate(catQuizModel.getCompletionRate());
        }
    }
}
