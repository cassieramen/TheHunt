package com.thehunt.app;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Cassie on 3/3/14.
 */
public class HuntChallengeSummary extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.challenge_summary);

        ListView resultsList = (ListView) findViewById(R.id.resultsList);
        resultsList.setAdapter(new HuntChallengeSummaryAdapter(getBaseContext()));
        Slider menu = new Slider(this);

    }
}
