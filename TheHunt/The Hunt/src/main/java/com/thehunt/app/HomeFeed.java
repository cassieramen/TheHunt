package com.thehunt.app;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class HomeFeed extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_feed);

        TextView txt = (TextView) findViewById(R.id.headerText);
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Thin.ttf");
        txt.setTypeface(font);

        ListView listView = (ListView) findViewById(R.id.home_feed_list);
        HomeFeedAdapter homeFeedAdapter = new HomeFeedAdapter(getBaseContext());
        listView.setAdapter(homeFeedAdapter);
        final Slider menu = new Slider(this);

        ImageView menubutton = (ImageView) findViewById(R.id.sideMenu);
        menubutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                menu.slidingMenu.showMenu(!menu.slidingMenu.isMenuShowing());
            }

        });


        //newsfeed click
        final TextView newsfeed = (TextView) findViewById(R.id.news_feed);
        newsfeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menu.slidingMenu.toggle();
            }

        });
        //Current hunt click
        final TextView currenthunts = (TextView) findViewById(R.id.current_hunts);
        currenthunts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currenthunts.setTextColor(0xEDCB62);
                Intent intent = new Intent(getApplicationContext(), HuntDescription.class);

                startActivity(intent);
            }

        });
        //create hunt click
        final TextView createhunt = (TextView) findViewById(R.id.create);
        createhunt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createhunt.setTextColor(0xEDCB62);
                Intent intent = new Intent(getApplicationContext(), HomeFeed.class);
                startActivity(intent);
            }

        });
        //Settings click
        final TextView settings = (TextView) findViewById(R.id.settings);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                settings.setTextColor(0xEDCB62);
                Intent intent = new Intent(getApplicationContext(), SettingsPage.class);
                startActivity(intent);
            }

        });
        //Logout click
        final TextView logout = (TextView) findViewById(R.id.log_out);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout.setTextColor(0xEDCB62);
                Intent intent = new Intent(getApplicationContext(), Logout.class);
                startActivity(intent);
            }

        });
    }

}
