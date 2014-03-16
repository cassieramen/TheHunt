package com.thehunt.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by nucsintern on 3/16/14.
 */
public class CreateAHunt extends Activity {

    @ Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_home);




        final Slider menu = new Slider(this);
        final TextView newsfeed = (TextView) findViewById(R.id.news_feed);
        newsfeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newsfeed.setTextColor(0xFFFFFF);
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
                Intent intent = new Intent(getApplicationContext(), LogOut.class);
                startActivity(intent);
            }

        });


    }



}
