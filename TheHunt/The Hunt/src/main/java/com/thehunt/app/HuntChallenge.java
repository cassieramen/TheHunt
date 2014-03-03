package com.thehunt.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Cassie on 3/3/14.
 */
public class HuntChallenge extends Activity {
    public static String TOTAL_POINTS = "total_points";
    public static String START_TIME = "start_time";
    private int totalPoints;

    TextView timerTextView;
    long startTime = 0;

    //runs without a timer by reposting this handler at the end of the runnable
    Handler timerHandler = new Handler();
    Runnable timerRunnable = new Runnable() {

        @Override
        public void run() {
            long millis = System.currentTimeMillis() - startTime;
            int seconds = (int) (millis / 1000);
            int minutes = seconds / 60;
            seconds = seconds % 60;
            
            timerTextView.setText(String.format("%d:%02d", minutes, seconds));

            timerHandler.postDelayed(this, 500);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.challenge);

        Bundle b = getIntent().getExtras();
        totalPoints = b.getInt(TOTAL_POINTS);
        startTime = b.getLong(START_TIME);

        TextView pointsTextView = (TextView) findViewById(R.id.totalPoints);
        pointsTextView.setText(Integer.toString(totalPoints));

        TextView nextTextView = (TextView) findViewById(R.id.nextButton);
        nextTextView.setOnClickListener(new NextClickListener(getBaseContext()));

        timerTextView = (TextView) findViewById(R.id.timerText);
        timerHandler.postDelayed(timerRunnable, 0);

    }

    class NextClickListener implements View.OnClickListener {
        Context context;
        NextClickListener(Context context) {
            this.context = context;
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context, HuntChallenge.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            Bundle b = new Bundle();
            b.putInt(HuntChallenge.TOTAL_POINTS, totalPoints + 5);
            b.putLong(HuntChallenge.START_TIME,startTime);
            intent.putExtras(b);
            context.startActivity(intent);
        }
    }
}
