package com.thehunt.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

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

        TextView number = (TextView) view.findViewById(R.id.place);
        int place = i + 1;
        number.setText(place + ". ");

        TextView name = (TextView) view.findViewById(R.id.name);
        ImageView picture = (ImageView) view.findViewById(R.id.picture);
        if (i == 0) {
            name.setText("Cassie Rommel");
            picture.setImageDrawable(context.getResources().getDrawable(R.drawable.cassie));
        } else if (i == 1) {
            name.setText("Shikhar Mohan");
            picture.setImageDrawable(context.getResources().getDrawable(R.drawable.mag_mile2));
        } else if (i == 2) {
            name.setText("Alex Hollenbeck");
            picture.setImageDrawable(context.getResources().getDrawable(R.drawable.alex));
        } else if (i == 3) {
            name.setText("Patrick Leonard");
            picture.setImageDrawable(context.getResources().getDrawable(R.drawable.mag_mile1));
        } else {
            name.setTextColor(context.getResources().getColor(R.color.red));
            name.setText("You!");
            picture.setImageDrawable(context.getResources().getDrawable(R.drawable.mag_mile4));
        }

        return view;
    }
}
