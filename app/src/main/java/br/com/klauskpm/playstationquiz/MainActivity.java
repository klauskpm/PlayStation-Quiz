package br.com.klauskpm.playstationquiz;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button submitButton = (Button) findViewById(R.id.submit__button);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double points = checkAnswers();

                sendMessage(points);
            }
        });
    }

    /**
     * Check the questions's answers and sum their score
     *
     * @return the total of points from the correct answers
     */
    private double checkAnswers() {
        double points = 0.0;

        points += checkQuestion1();
        points += checkQuestion2();
        points += checkQuestion3();
        points += checkQuestion4();

        return points;
    }

    /**
     * Send a toast message based on the points
     *
     * @param points scored by correct answers
     */
    private void sendMessage(double points) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        String message;

        if (points == 4)
            message = "You made a perfect score!!!";
        else if (points < 4 && points >= 3)
            message = "Almost perfect!!";
        else if (points >= 2 && points < 3)
            message = "Good, but it can be better!";
        else
            message = "Don't give up!";

        message += "\nYou've done " + points + " out of 4";
        Toast toast = Toast.makeText(context, message, duration);
        toast.show();
    }

    /**
     * Checks the first question and score if correct
     *
     * @return the score
     */
    private double checkQuestion1() {
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.question_1__radio_group);
        int checkedId = radioGroup.getCheckedRadioButtonId();
        if (checkedId < 0)
            return 0;

        RadioButton checkedRadioButton = (RadioButton) findViewById(checkedId);

        if (checkedRadioButton.getText().toString().equals(getString(R.string.day_s_gone))) {
            return 1;
        }

        return 0;
    }

    /**
     * Checks the second question and score if correct
     *
     * @return the score
     */
    private double checkQuestion2() {
        EditText editText = (EditText) findViewById(R.id.answer_question_2__edit_text);
        String text = editText.getText().toString();

        if (text != null && (text.equalsIgnoreCase("PlayStation Network") || text.equalsIgnoreCase("PSN"))) {
            return 1;
        }

        return 0;
    }

    /**
     * Checks the third question and score if correct
     *
     * @return the score
     */
    private double checkQuestion3() {
        double points = 0.0;
        double pointPerChoice = 0.5;

        CheckBox PS4EliteCheckBox = (CheckBox) findViewById(R.id.answer_1_question_3__check_box);
        CheckBox PS4SlimCheckBox = (CheckBox) findViewById(R.id.answer_2_question_3__check_box);
        CheckBox PS4ProCheckBox = (CheckBox) findViewById(R.id.answer_3_question_3__check_box);
        CheckBox PS4SCheckBox = (CheckBox) findViewById(R.id.answer_4_question_3__check_box);

        if (PS4SlimCheckBox.isChecked())
            points += pointPerChoice;

        if (PS4ProCheckBox.isChecked())
            points += pointPerChoice;

        if (PS4SCheckBox.isChecked() && points >= pointPerChoice)
            points -= pointPerChoice;

        if (PS4EliteCheckBox.isChecked() && points >= pointPerChoice)
            points -= pointPerChoice;

        return points;
    }

    /**
     * Checks the fourth question and score if correct
     *
     * @return the score
     */
    private double checkQuestion4() {
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.questio_4__radio_group);
        int checkedId = radioGroup.getCheckedRadioButtonId();
        if (checkedId < 0)
            return 0;

        RadioButton checkedRadioButton = (RadioButton) findViewById(checkedId);

        if (checkedRadioButton.getText().toString().equals(getString(R.string.lords_and_journey))) {
            return 1;
        }

        return 0;
    }
}
