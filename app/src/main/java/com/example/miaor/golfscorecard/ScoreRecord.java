package com.example.miaor.golfscorecard;


import android.os.Parcel;
import android.os.Parcelable;

/**
 * created by the one and only, Runkun Miao!!!!!!!!!
 */
public class ScoreRecord{
    private int mScores;
    private String mHoles;


    public ScoreRecord(String Holes, int Scores){
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
