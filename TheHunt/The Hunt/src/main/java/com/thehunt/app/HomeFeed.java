package com.thehunt.app;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class HomeFeed extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_feed);
        ListView listView = (ListView) findViewById(R.id.home_feed_list);
        HomeFeedAdapter homeFeedAdapter = new HomeFeedAdapter(getBaseContext());
        listView.setAdapter(homeFeedAdapter);
        final Slider menu = new Slider(this);
    }

}
