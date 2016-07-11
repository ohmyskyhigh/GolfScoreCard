package com.example.miaor.golfscorecard;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;

/**
 * created by the one and only, Runkun Miao!!!!!!!!!
 */
public class Adapter extends BaseAdapter{
    private ScoreRecord[] mRecords;
    private Context mContext;

    public Adapter(ScoreRecord[] score, Context context){
        mContext = context;
        mRecords = score;
    }


    @Override
    public int getCount() {
        return mRecords.length;
    }


    @Override
    public Object getItem(int i) {
        return mRecords[i];
    }


    @Override
    public long getItemId(int i) {
        return 0;
    }



    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final Holder holder;

        if(view == null){
            view = LayoutInflater.from(mContext).inflate(R.layout.score_record_list, null);
            holder = new Holder();
            holder.mHole = (TextView) view.findViewById(R.id.HoleNoList);
            holder.mStrike = (TextView)view.findViewById(R.id.StrikeNumberList);
            holder.mPlus = (Button)view.findViewById(R.id.plus);
            holder.mMinis = (Button)view.findViewById(R.id.minis);
            view.setTag(holder);
        }
        else{
            holder = (Holder) view.getTag();
        }

        final ScoreRecord record = mRecords[i];
        holder.mHole.setText(record.getHoles());
        holder.mStrike.setText(record.getScores()+"");

        holder.mPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int strike = record.getScores();
                record.setScores(strike+1);
                holder.mStrike.setText(record.getScores()+"");
            }
        });
        holder.mMinis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int strike = record.getScores();
                if(strike>0) {
                    record.setScores(strike-1);
                    holder.mStrike.setText(record.getScores() + "");
                }
            }
        });

        return view;
    }


    private static class Holder {
        private Button mPlus;
        private Button mMinis;
        private TextView mHole;
        private TextView mStrike;
    }
}
