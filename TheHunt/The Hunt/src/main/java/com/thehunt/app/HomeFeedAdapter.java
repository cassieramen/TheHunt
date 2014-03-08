package com.thehunt.app;

import android.content.Context;
import android.net.Uri;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

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
        this.feedItems.add(new FeedItem(one_pic_two_text,
                                        "Cassie Rommel ",
                                        "is hosting",
                                        "Lincoln Park Brewery Tour",
                                        "Hitting up some of my favorite watering holes around Lincoln Park. Shenanigans expected! ...",
                                        "cassie"));
        this.feedItems.add(new FeedItem(two_text_four_pics,
                                        "Patrick Leonard",
                                        "went hunting",
                                        "other thing",
                                        "Magnificent Mile Marathon (12 pictures)",
                                        "mag_mile"));
        this.feedItems.add(new FeedItem(one_pic_two_text,
                                        "Alex Hollenbeck ",
                                        "is hosting",
                                        "Millennium Park Selfie Snatch",
                                        "Get selfies with strangers doing hilarious things in the background",
                                        "alex"));
        this.feedItems.add(new FeedItem(two_text_four_pics,
                                        "Shikhar Mohan",
                                        "doop",
                                        "doop",
                                        "Chicago Museum Hunt (8 pictures)",
                                        "museums"));
        this.feedItems.add(new FeedItem(two_text_four_pics,
                                        "Patrick Leonard",
                                        "doop",
                                        "doop",
                                        "Magnificent Mile Marathon (12 pictures)",
                                        "mag_mile"));
    }

    @Override
    public long getItemId(int position) {
        FeedItem item = (FeedItem) getItem(position);
        if (item.itemID.equals(one_pic_two_text)) {
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
    public int getViewTypeCount() {
     return 2;
    }

    @Override
    public int getItemViewType(int position) {
        return (int) getItemId(position);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        FeedItem item = (FeedItem) getItem(i);
        if (item.itemID.equals(one_pic_two_text)) {
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
        TextView nameText = (TextView) view.findViewById(R.id.name_text);
        nameText.setText(item.name);
        TextView action = (TextView) view.findViewById(R.id.action_text);
        action.setText(item.action);
        TextView titleText = (TextView) view.findViewById(R.id.hunt_name_text);
        titleText.setText(item.title);
        TextView subtitle = (TextView) view.findViewById(R.id.sub_text);
        subtitle.setText(item.subtitle);
        ImageView thumbnail = (ImageView) view.findViewById(R.id.thumbnail_image);
        if (item.image.equals("cassie")) {
            thumbnail.setImageResource(R.drawable.cassie);
        }
        else if (item.image.equals("alex")) {
            thumbnail.setImageResource((R.drawable.alex));
        }

        return view;
    }

    public View configureTTFP(View view, FeedItem item) {
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.two_text_four_pics, null);
        }
        TextView textView = (TextView) view.findViewById(R.id.title_text);
        textView.setText(item.title);
        TextView subtitle = (TextView) view.findViewById(R.id.sub_text);
        subtitle.setText(item.subtitle);
        ImageView image1 = (ImageView) view.findViewById(R.id.image_1);
        ImageView image2 = (ImageView) view.findViewById(R.id.image_2);
        ImageView image3 = (ImageView) view.findViewById(R.id.image_3);
        ImageView image4 = (ImageView) view.findViewById(R.id.image_4);
        if (item.image.equals("mag_mile")) {
            image1.setImageResource(R.drawable.mag_mile1);
            image2.setImageResource(R.drawable.mag_mile2);
            image3.setImageResource(R.drawable.mag_mile3);
            image4.setImageResource(R.drawable.mag_mile4);
        }
        else if (item.image.equals("museums")) {
            image1.setImageResource(R.drawable.museum_1);
            image2.setImageResource(R.drawable.museum_2);
            image3.setImageResource(R.drawable.museum_3);
            image4.setImageResource(R.drawable.museum_4);
        }

        return view;
    }

    class FeedItem {
        String itemID;
        String name;
        String action;
        String title;
        String subtitle;
        String image;

        public FeedItem(String itemID, String name, String action, String title, String subtitle, String image) {
            this.itemID = itemID;
            this.name = name;
            this.action = action;
            this.title = title;
            this.subtitle = subtitle;
            this.image = image;
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
