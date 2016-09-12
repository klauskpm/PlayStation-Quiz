package br.com.klauskpm.playstationquiz;

import android.app.Activity;
import android.content.res.Resources;
import android.support.v4.content.res.ResourcesCompat;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by klaus.machado on 12/09/2016.
 */
public class Question {

    private int mQuestionTextViewId;
    private AnswerEditText mAnswerEditText;

    public String correctAnswer;
    public QuestionBoxRelativeLayout template;

    public Question (Activity activity, String questionText) {
        template = new QuestionBoxRelativeLayout(activity);
        mAnswerEditText = new AnswerEditText(activity);

        mQuestionTextViewId = View.generateViewId();
        QuestionTextView questionTextView = new QuestionTextView(activity);
        questionTextView.setId(mQuestionTextViewId);
        questionTextView.setText(questionText);

        template.addView(questionTextView);
    }

    public void addAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;

        RelativeLayout.LayoutParams paramsRules = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        paramsRules.addRule(RelativeLayout.BELOW, mQuestionTextViewId);
        template.addView(mAnswerEditText, paramsRules);
    }

    public boolean checkAnswer() {
        return correctAnswer.equalsIgnoreCase("oi");
    }
}
