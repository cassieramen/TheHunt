package com.thehunt.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Cassie on 3/1/14.
 */
public class HuntDescription extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.description);

        String descriptionText = "Hitting up some of my favorite watering holes " +
                "around Lincoln Park. Shenanigans Expected! Featuring:\nAtlas " +
                "Brewing\nHalf Acre Brewing\nRevolution Brewing";

        TextView descriptionTextView = (TextView) findViewById(R.id.description);
        descriptionTextView.setText(descriptionText);

        TextView playButton = (TextView) findViewById(R.id.playButton);
        playButton.setOnClickListener(new PlayClickListener(getBaseContext()));
    }

    class PlayClickListener implements View.OnClickListener {
        Context context;
        PlayClickListener(Context context) {
            this.context = context;
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context, HuntChallenge.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            Bundle b = new Bundle();
            b.putInt(HuntChallenge.TOTAL_POINTS, 0);
            b.putLong(HuntChallenge.START_TIME,System.currentTimeMillis());
            intent.putExtras(b);
            context.startActivity(intent);
        }
    }
}
