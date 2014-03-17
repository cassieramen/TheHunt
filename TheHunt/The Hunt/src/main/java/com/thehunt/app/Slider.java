package com.thehunt.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;


import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

/**
 * Created by home on 3/3/14.
 */
public class Slider {
    SlidingMenu slidingMenu;

    public Slider(Activity activity) {

        slidingMenu = new SlidingMenu(activity);
        slidingMenu.setMode(SlidingMenu.LEFT);
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        slidingMenu.setShadowWidthRes(R.dimen.slidingmenu_shadow_width);
        slidingMenu.setShadowDrawable(R.drawable.slider_shadow);
        slidingMenu.setShadowWidth(30);
        slidingMenu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        slidingMenu.setFadeDegree(0.35f);
        slidingMenu.attachToActivity(activity, SlidingMenu.SLIDING_CONTENT);
        //Let's create the view so we can alter it
        Context context = activity.getBaseContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slidingmenu, null);
        modifyMenu(view, activity);
        slidingMenu.setMenu(view);

    }

    private void modifyMenu(View view, Context context) {
        ListView listView = (ListView) view.findViewById(R.id.listView);
        listView.setAdapter(new SideMenuAdapter(context));
    }

    private class SideMenuAdapter extends BaseAdapter {
        private String[] menuItems = {"profile", "News Feed", "Current Hunts", "Create A Hunt", "Settings", "Logout"};
        private Context context;

        SideMenuAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return menuItems.length;
        }

        @Override
        public Object getItem(int i) {
            return menuItems[i];
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public int getViewTypeCount() {
            return 2;
        }

        @Override
        public int getItemViewType(int position) {
            if (position == 0) {
                return 0;
            }
            return 1;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (i > 0) {
                view = configureBasicFeedItem(view, menuItems[i]);
            } else if (i == 0) {
                view = configureProfileView(view);
            }
            return view;
        }

        private View configureBasicFeedItem(View view, String menuItem) {
            if (view == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.sliding_menu_item, null);
            }
            TextView title = (TextView) view.findViewById(R.id.title);
            title.setText(menuItem);
            if (menuItem.equals("News Feed")) {
                view.setOnClickListener(new NewsFeedClickListener(context, slidingMenu));
            } else if (menuItem.equals("Current Hunts")) {
                view.setOnClickListener(new CurrentHuntsClickListener(context, slidingMenu));
            } else if (menuItem.equals("Create A Hunt")) {
                view.setOnClickListener(new CreateAHuntClickListener(context));
            } else if (menuItem.equals("Settings")) {
                view.setOnClickListener(new SettingsClickListener(context));
            } else if (menuItem.equals("Logout")) {
                view.setOnClickListener(new LogoutClickListener(context));
            }

            return view;
        }

        private View configureProfileView(View view) {
            if (view == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.sliding_menu_profile_item, null);
            }

            return view;
        }
    }


    //Newsfeed Click Listener
    class NewsFeedClickListener implements View.OnClickListener {
        Context context;
        SlidingMenu menu;

        NewsFeedClickListener(Context context, SlidingMenu menu) {
            this.context = context;
            this.menu = menu;
        }

        @Override
        public void onClick(View view) {
            Activity activity = (Activity) context;
            if (activity instanceof HomeFeed) {
                menu.toggle();
            } else {
                Intent intent = new Intent(context, HomeFeed.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        }

    }

    ;

    //Current hunt click
    class CurrentHuntsClickListener implements View.OnClickListener {
        Context context;
        SlidingMenu menu;

        CurrentHuntsClickListener(Context context, SlidingMenu menu) {
            this.context = context;
            this.menu = menu;
        }

        @Override
        public void onClick(View view) {
            Activity activity = (Activity) context;
            if (activity instanceof HomeFeed) {
                menu.toggle();
            } else {
                Intent intent = new Intent(context, HomeFeed.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        }

    }

    ;

    //create hunt click
    class CreateAHuntClickListener implements View.OnClickListener {
        Context context;

        CreateAHuntClickListener(Context context) {
            this.context = context;
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context, CreateAHunt.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }

    }

    ;

    //Settings click
    class SettingsClickListener implements View.OnClickListener {
        Context context;

        SettingsClickListener(Context context) {
            this.context = context;
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context, SettingsPage.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }

    }

    ;

    //Logout click
    class LogoutClickListener implements View.OnClickListener {
        Context context;

        LogoutClickListener(Context context) {
            this.context = context;
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context, SignIn.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }

    }

    ;

}