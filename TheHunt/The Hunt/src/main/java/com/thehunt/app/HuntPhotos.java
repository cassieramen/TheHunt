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
        ArrowClickListener arrowClickListener = new ArrowClickListener(getBaseContext(), findViewById(R.id.image_display));

    }

    class ArrowClickListener implements View.OnClickListener {
        Context context;
        ImageView currentPhoto;
        int nextResourceID;
        ArrowClickListener(Context context, ImageView currentPhoto) {
            this.context = context;
            this.currentPhoto = currentPhoto;
            this.nextResourceID = nextResourceID;
        }

        @Override
        public void onClick(View view) {
            currentPhoto.setImageResource(nextResourceID);
        }
    }
}
