package com.thehunt.app;

import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;

/**
 * Created by Cassie on 3/1/14.
 */
public class HuntDescription extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.description);

        String descriptionText = "Explore Lincoln Park through its many drinking " +
                "establishments. Featuring\nAtlas Brewing\nHalf Acre Brewing\nRevolution Brewing";

        TextView descriptionTextView = (TextView) findViewById(R.id.description);
        descriptionTextView.setText(descriptionText);
    }
}
