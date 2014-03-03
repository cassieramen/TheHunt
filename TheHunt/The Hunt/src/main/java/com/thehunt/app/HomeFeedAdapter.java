package com.thehunt.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by nucsintern on 3/1/14.
 */
public class HomeFeedAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<FeedItem> feedItems;
    private static String one_pic_two_text = "one_pic_two_text";
    private static String two_text_four_pics = "two_text_four_pics";

    public HomeFeedAdapter (Context context) {
        this.context = context;
        this.feedItems = new ArrayList<FeedItem>();
        this.feedItems.add(new FeedItem(one_pic_two_text));
        this.feedItems.add(new FeedItem(two_text_four_pics));
    }

    @Override
    public long getItemId(int position) {
        FeedItem item = (FeedItem) getItem(position);
        if (item.itemID == one_pic_two_text) {
            return 0;
        }
        else {
            return 1;
        }
    }

    @Override
    public int getCount() {
        return feedItems.size();
    }

    @Override
    public Object getItem(int i) {
        return feedItems.get(i);
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        FeedItem item = (FeedItem) getItem(i);
        if (item.itemID == one_pic_two_text) {
            view = configureOPTT(view, item);
        }
        else {
            view = configureTTFP(view, item);
        }

        view.setOnClickListener(new FeedItemClickListener(context));
        return view;
    }

    public View configureOPTT(View view, FeedItem item) {
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.one_pic_two_text, null);
        }

        return view;
    }

    public View configureTTFP(View view, FeedItem item) {
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.two_text_four_pics, null);
        }

        return view;
    }

    class FeedItem {
        String itemID;

        public FeedItem(String itemID) {
            this.itemID = itemID;
        }
    }

    class FeedItemClickListener implements View.OnClickListener {
        Context context;
        FeedItemClickListener(Context context) {
            this.context = context;
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context, HuntDescription.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }
}
