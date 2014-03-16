package com.thehunt.app;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
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

        TextView txt = (TextView) findViewById(R.id.headerText);
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Thin.ttf");
        txt.setTypeface(font);

        ListView resultsList = (ListView) findViewById(R.id.resultsList);
        resultsList.setAdapter(new HuntChallengeSummaryAdapter(getBaseContext()));
        final Slider menu = new Slider(this);

        ImageView menubutton = (ImageView) findViewById(R.id.sideMenu);
        menubutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                menu.slidingMenu.showMenu(!menu.slidingMenu.isMenuShowing());
            }

        });

        TextView newsfeed = (TextView) findViewById(R.id.news_feed);
        newsfeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HomeFeed.class);
                startActivity(intent);
            }

        });
        //Current hunt click
        final TextView currenthunts = (TextView) findViewById(R.id.current_hunts);
        currenthunts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currenthunts.setTextColor(0xEDCB62);
                Intent intent = new Intent(getApplicationContext(), HuntChallenge.class);
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
