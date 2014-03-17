package com.thehunt.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by nucsintern on 3/16/14.
 */
public class CreateAHunt extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_home);

        TextView txt = (TextView) findViewById(R.id.headerText);
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Thin.ttf");
        txt.setTypeface(font);


        final Slider menu = new Slider(this);
        TextView addLocation = (TextView) findViewById(R.id.location);
        MenuItemClickListener locationListener = new MenuItemClickListener(getBaseContext(), addLocation);
        addLocation.setOnClickListener(locationListener);

        ImageView menubutton = (ImageView) findViewById(R.id.sideMenu);
        menubutton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                menu.slidingMenu.showMenu(!menu.slidingMenu.isMenuShowing());
            }

        });

        TextView submitButton = (TextView) findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new SubmitClickListener(getBaseContext()));

    }

    class MenuItemClickListener implements View.OnClickListener {
        Context context;
        TextView textView;

        MenuItemClickListener(Context context, TextView textView) {
            this.context = context;
            this.textView = textView;
        }

        public void onClick(View view) {
            if (this.textView.getId() == R.id.invite) {
                Intent intent = new Intent(context, HuntDescription.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            } else if (this.textView.getId() == R.id.tasks) {
                Intent intent = new Intent(context, HuntDescription.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }

        }
    }

    class SubmitClickListener implements View.OnClickListener {
        Context context;

        SubmitClickListener(Context context) {
            this.context = context;
        }

        public void onClick(View view) {
            Intent intent = new Intent(context, HomeFeed.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }


}
