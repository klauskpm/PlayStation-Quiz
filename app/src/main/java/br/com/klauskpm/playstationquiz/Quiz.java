package br.com.klauskpm.playstationquiz;

import android.app.Activity;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by klaus.machado on 12/09/2016.
 */
public class Quiz {

    private int mQuestionsQuantity = 0;
    private List<Question> mQuestions = new ArrayList<Question>();
    private float mPoints = 0;
    private Activity mActivity;

    public LinearLayout template;

    public Quiz (Activity activity, int templateId) {
        mActivity = activity;

        template = (LinearLayout) activity.findViewById(templateId);
    }

    public Question addQuestion (String text) {
        mQuestionsQuantity++;
        Question question = new Question(mActivity, text);

        mQuestions.add(question);
        template.addView(question.template);

        return question;
    }


}
