package com.example.bignerdranch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mTrueButton;
    private Button mFalseButton;
    private ImageButton mNextButton;
    private ImageButton mPrevButton;
    private TextView mQuestionTextView;

    private QuizQuestion[] mQuestionList = new QuizQuestion[] {
            new QuizQuestion(R.string.question1, true),
            new QuizQuestion(R.string.question2,true),
            new QuizQuestion(R.string.question3,true),
            new QuizQuestion(R.string.question4,false),
            new QuizQuestion(R.string.question5,true)
    };

    private int mCurrentIndex = -1;

    private void updateQuestion() {
        mCurrentIndex = (mCurrentIndex + 1 ) % mQuestionList.length; //Using mod to set index 0 when maximum
        int question = mQuestionList[mCurrentIndex].getmQuestion();
        mQuestionTextView.setText(question);
    }

    private void previousQuestion() {

        if(mCurrentIndex <= 0 ) {
            Toast.makeText(this,R.string.no_previous_questions,Toast.LENGTH_LONG).show();
        }
        else {
            mCurrentIndex--;
            int question = mQuestionList[mCurrentIndex].getmQuestion();
            mQuestionTextView.setText(question);
        }

    }

    private void checkAnswer(boolean userPressedTrue) {
        boolean answerIsTrue = mQuestionList[mCurrentIndex].ismBoolQuestion();
        int messageRedId = 0;

        if(userPressedTrue == answerIsTrue) {
            messageRedId = R.string.correct_toast;
            
        }
        else {
            messageRedId = R.string.incorrect_toast;
        }

        Toast.makeText(this,messageRedId,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mQuestionTextView = (TextView)findViewById(R.id.question_text_view);
        updateQuestion();


        mTrueButton = (Button)findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });

        mFalseButton = (Button)findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });

        mNextButton = (ImageButton)findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateQuestion();
            }
        });

        mQuestionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateQuestion();
            }
        });

        mPrevButton = (ImageButton)findViewById(R.id.previous_button);
        mPrevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                previousQuestion();


            }
        });

    }
}