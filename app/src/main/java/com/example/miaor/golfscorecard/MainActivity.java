package com.example.miaor.golfscorecard;


import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private static final String PREFS = "prefs";
    private static final String STROKE = "Strike";
    private ScoreRecord[] mRecord;
    private SharedPreferences mSharedPref;
    private SharedPreferences.Editor mEditor;
    private Adapter adapter;

    @BindView(R.id.my_toolbar)
    Toolbar mToolbar;
    @BindView(android.R.id.empty)
    TextView mEmpty;
    @BindView(android.R.id.list)
    ListView mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSharedPref = getSharedPreferences(PREFS, Context.MODE_PRIVATE);
        mEditor = mSharedPref.edit();
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        mRecord = new ScoreRecord[18];
        setData();

        adapter = new Adapter(mRecord, this);
        mList.setAdapter(adapter);
        mList.setEmptyView(mEmpty);

    }


    private void setData() {
        int stroke = 0;
        for(int i=0; i<mRecord.length; i++){
            int hole = i+1;
            stroke = mSharedPref.getInt(STROKE+i, 0);
            mRecord[i] = new ScoreRecord("Hole " + hole, stroke);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_item, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.clear_record:
                mEditor.clear();
                mEditor.apply();
                setData();
                adapter.notifyDataSetChanged();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    protected void onPause() {
        super.onPause();

        for(int i = 0; i < mRecord.length; i++){
            mEditor.putInt(STROKE +i, mRecord[i].getScores());
        }
        mEditor.apply();
    }
}
