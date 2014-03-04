package com.thehunt.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
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

    private TextView timerTextView;
    private TimeLeftCounter timeLeftCounter;
    private long startTime;

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
        timeLeftCounter = new TimeLeftCounter(startTime, 1000);
        timeLeftCounter.start();

        TextView description = (TextView) findViewById(R.id.description);
        if (totalPoints == 0) {
            description.setText("Grab and inhouse brew at Revolution Brewing Co! Worth 20 points");
        } else if (totalPoints == 20) {
            description.setText("Take a photo with the best old fashioned sign you can find on the wall of Atlas Brewing. Maybe have a beer too. Worth 20 points! ");
        } else if (totalPoints == 40) { //the last screen
            description.setText("Half Acre brewing is home to 19 fermentation stations. Take a photo with one. Worth 20 points.");
            nextTextView.setOnClickListener(new EndingClickListener(getBaseContext()));
            nextTextView.setText("Finish");
        }

    }

    public void goToEndingScreen() {
        //out of time or totally finished
        timeLeftCounter.cancel();

        Context context = getBaseContext();
        Intent intent = new Intent(context, HuntChallengeSummary.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    class NextClickListener implements View.OnClickListener {
        Context context;
        NextClickListener(Context context) {
            this.context = context;
        }

        @Override
        public void onClick(View view) {
            //turn off the timer
            timeLeftCounter.cancel();
            //go to the next activity
            Intent intent = new Intent(context, HuntChallenge.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            Bundle b = new Bundle();
            b.putInt(HuntChallenge.TOTAL_POINTS, totalPoints + 20);
            b.putLong(HuntChallenge.START_TIME,startTime);
            intent.putExtras(b);
            context.startActivity(intent);
        }
    }

    class EndingClickListener implements View.OnClickListener {

        Context context;
        EndingClickListener(Context context) {
            this.context = context;
        }

        @Override
        public void onClick(View view) {
            //turn off the timer
            timeLeftCounter.cancel();
            //go to the next activity
            Intent intent = new Intent(context, HuntChallengeSummary.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            Bundle b = new Bundle();
            b.putInt(HuntChallenge.TOTAL_POINTS, totalPoints);
            intent.putExtras(b);
            context.startActivity(intent);
        }

    }

    class TimeLeftCounter extends CountDownTimer {

        public TimeLeftCounter(long startTime, long interval) {
            super(startTime, interval);
        }

        public void onTick(long millisUntilFinished) {
            timerTextView.setText("0:" + millisUntilFinished / 1000);
            startTime = millisUntilFinished;
        }

        public void onFinish() {
            timerTextView.setText("0:00");
            goToEndingScreen();
        }
    }

}
