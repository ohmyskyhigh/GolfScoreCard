package com.example.miaor.golfscorecard;


/**
 * created by the one and only, Runkun Miao!!!!!!!!!
 */
public class ScoreRecord {
    private int mScores;
    private String mHoles;


    public ScoreRecord(int Scores, String Holes){
        mHoles = Holes;
        mScores = Scores;
    }



    public int getScores() {
        return mScores;
    }


    public void setScores(int scores) {
        mScores = scores;
    }


    public String getHoles() {
        return mHoles;
    }


    public void setHoles(String holes) {
        mHoles = holes;
    }
}
