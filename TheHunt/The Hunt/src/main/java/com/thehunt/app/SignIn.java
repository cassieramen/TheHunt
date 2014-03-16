package com.thehunt.app;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by home on 3/16/14.
 */
public class SignIn extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);

        TextView txt = (TextView) findViewById(R.id.headerText);
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Thin.ttf");
        txt.setTypeface(font);


        TextView login = (TextView) findViewById(R.id.btnLogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), HomeFeed.class);
                startActivity(intent);
            }
        });

    }


}