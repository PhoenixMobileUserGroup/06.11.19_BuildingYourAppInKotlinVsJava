package com.rachelleboyette.catquiz.customviews;

import android.content.Context;
import android.util.AttributeSet;

import com.rachelleboyette.catquiz.R;

public class CatQuizCompletionView extends androidx.appcompat.widget.AppCompatImageView {
    private int completionRate;

    public CatQuizCompletionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        completionRate = 0;
    }


    public void setCompletionRate(int completionRate) {
        this.completionRate = completionRate;
        switch (completionRate) {
            case 0:
                setImageResource(R.drawable.ic_catcardicons_01);
                break;
            case 25:
                setImageResource(R.drawable.ic_catcardicons_02);
                break;
            case 50:
                setImageResource(R.drawable.ic_catcardicons_03);
                break;
            case 75:
                setImageResource(R.drawable.ic_catcardicons_04);
                break;
            case 100:
                setImageResource(R.drawable.ic_catcardicon_05);
                break;
            default:
                setImageResource(R.drawable.ic_catcardicons_01);
                break;
        }
    }
}
