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
        TextView inviteFriends = (TextView) findViewById(R.id.invite);
        MenuItemClickListener inviteListener  = new MenuItemClickListener(getBaseContext(), inviteFriends);
        inviteFriends.setOnClickListener(inviteListener);
        TextView addLocation = (TextView) findViewById(R.id.location);
        MenuItemClickListener locationListener  = new MenuItemClickListener(getBaseContext(), addLocation);
        addLocation.setOnClickListener(locationListener);
        


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
            }
            else if (this.textView.getId() == R.id.tasks) {
                Intent intent = new Intent(context, HuntDescription.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }

        }
    }



}
