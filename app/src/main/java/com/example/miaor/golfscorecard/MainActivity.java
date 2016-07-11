package com.example.miaor.golfscorecard;


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

    private ScoreRecord[] mRecord;

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
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);

        setData();

        Adapter adapter = new Adapter(mRecord, this);
        mList.setAdapter(adapter);
        mList.setEmptyView(mEmpty);
    }


    private void setData() {
        mRecord = new ScoreRecord[18];
        int strike = 0;
        for(int i=0; i<mRecord.length; i++){
            int hole = i+1;
            mRecord[i] = new ScoreRecord("Hole " + hole, strike);
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
        int id = item.getItemId();
        if(id == R.id.clear_record){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
