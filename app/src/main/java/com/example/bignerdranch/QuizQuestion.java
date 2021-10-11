package com.example.bignerdranch;

public class QuizQuestion {
    private int mQuestion;
    private boolean mBoolQuestion;

    public QuizQuestion(int question, boolean boolQuestion) {
        mQuestion = question;
        mBoolQuestion = boolQuestion;
    }

    public int getmQuestion() {
        return mQuestion;
    }

    public void setmQuestion(int mQuestion) {
        this.mQuestion = mQuestion;
    }

    public boolean ismBoolQuestion() {
        return mBoolQuestion;
    }

    public void setmBoolQuestion(boolean mBoolQuestion) {
        this.mBoolQuestion = mBoolQuestion;
    }
}
