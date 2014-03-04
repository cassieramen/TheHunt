package com.thehunt.app;

import android.app.Activity;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

/**
 * Created by home on 3/3/14.
 */
public class Slider {
    SlidingMenu slidingMenu;
    public Slider(Activity activity){
        SlidingMenu slidingMenu = new SlidingMenu(activity);

        slidingMenu.setMode(SlidingMenu.LEFT);
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        slidingMenu.setShadowWidthRes(R.dimen.slidingmenu_shadow_width);
        slidingMenu.setShadowDrawable(R.drawable.shadow);
        slidingMenu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        slidingMenu.setFadeDegree(0.35f);
        slidingMenu.attachToActivity(activity, SlidingMenu.SLIDING_CONTENT);
        slidingMenu.setMenu(R.layout.slidingmenu);

    }


}
