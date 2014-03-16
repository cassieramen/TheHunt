package com.thehunt.app;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by home on 3/16/14.
 */
public class SettingsPage extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        TextView txt = (TextView) findViewById(R.id.headerText);
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Thin.ttf");
        txt.setTypeface(font);

        final Slider menu = new Slider(this);

        ImageView menubutton = (ImageView) findViewById(R.id.sideMenu);
        menubutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                menu.slidingMenu.showMenu(!menu.slidingMenu.isMenuShowing());
            }

        });

    }
}



