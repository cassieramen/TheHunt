package com.thehunt.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by nucsintern on 3/7/14.
 */
public class HuntPhotos extends Activity {

    @ Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo_slideshow);
        ImageView currentPhoto = (ImageView) findViewById(R.id.image_display);
        Context context = getBaseContext();
        RightArrowClickListener rightArrowClickListener = new RightArrowClickListener(context, currentPhoto);
        ImageView arrowRight = (ImageView) findViewById(R.id.arrow_right);
        arrowRight.setOnClickListener(rightArrowClickListener);
        LeftArrowClickListener leftArrowClickListener = new LeftArrowClickListener(context, currentPhoto);
        ImageView arrowLeft = (ImageView) findViewById(R.id.arrow_left);
        arrowLeft.setOnClickListener(leftArrowClickListener);



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

    class RightArrowClickListener implements View.OnClickListener {
        Context context;
        ImageView currentPhoto;
        int currentResourceID = R.drawable.mag_mile1;
        RightArrowClickListener(Context context, ImageView currentPhoto) {
            this.context = context;
            this.currentPhoto = currentPhoto;
        }

        @Override
        public void onClick(View view) {
            switch(currentResourceID) {
                case R.drawable.mag_mile1:
                    this.currentResourceID = R.drawable.mag_mile2;
                    break;
                case R.drawable.mag_mile2:
                    this.currentResourceID = R.drawable.mag_mile3;
                    break;
                case R.drawable.mag_mile3:
                    this.currentResourceID = R.drawable.mag_mile4;
                    break;
                case R.drawable.mag_mile4:
                    this.currentResourceID = R.drawable.mag_mile1;
            }
            currentPhoto.setImageResource(currentResourceID);
        }
    }

    class LeftArrowClickListener implements View.OnClickListener {
        Context context;
        ImageView currentPhoto;
        int currentResourceID = R.drawable.mag_mile1;
        LeftArrowClickListener(Context context, ImageView currentPhoto) {
            this.context = context;
            this.currentPhoto = currentPhoto;
        }

        @Override
        public void onClick(View view) {
            switch(currentResourceID) {
                case R.drawable.mag_mile1:
                    this.currentResourceID = R.drawable.mag_mile4;
                    break;
                case R.drawable.mag_mile2:
                    this.currentResourceID = R.drawable.mag_mile1;
                    break;
                case R.drawable.mag_mile3:
                    this.currentResourceID = R.drawable.mag_mile2;
                    break;
                case R.drawable.mag_mile4:
                    this.currentResourceID = R.drawable.mag_mile3;
            }
            currentPhoto.setImageResource(currentResourceID);
        }
    }
}
