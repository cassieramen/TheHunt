package com.thehunt.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by Cassie on 3/3/14.
 */
public class HuntChallengeSummaryAdapter extends BaseAdapter {
    Context context;

    HuntChallengeSummaryAdapter (Context context) {
        this.context = context;
    }
    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.challenge_summary_tile, null);
        }
        return view;
    }
}
