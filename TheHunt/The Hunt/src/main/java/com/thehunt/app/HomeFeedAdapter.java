package com.thehunt.app;

import android.content.Context;
import android.net.Uri;
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
                                        "Cassie Rommel is hosting Lincoln Park Bar Tour",
                                        "Hitting up some of my favorite watering holes around Lincoln Park. Shenanigans expected!",
                                        "cassie"));
        this.feedItems.add(new FeedItem(two_text_four_pics,
                                        "Patrick Leonard",
                                        "Magnificent Mile Marathon (12 pictures)",
                                        "mag_mile"));
        this.feedItems.add(new FeedItem(one_pic_two_text,
                                        "Alex Hollenbeck is hosting Milennium Park Selfie Snatch",
                                        "Get selfies with strangers doing hilarious things in the background",
                                        "alex"));
        this.feedItems.add(new FeedItem(two_text_four_pics,
                                        "Shikhar Mohan",
                                        "Chicago Museum Hunt (8 pictures)",
                                        "museums"));
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
        return view;
    }

    public View configureOPTT(View view, FeedItem item) {
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.one_pic_two_text, null);
        }
        TextView title = (TextView) view.findViewById(R.id.title_text);
        title.setText(item.title);
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
        image1.setImageResource((R.drawable.alex));
        /*if (item.image.equals("mag_mile")) {
            image1.setImageResource(R.drawable.mag_mile1);
            image2.setImageResource(R.drawable.mag_mile2);
            image3.setImageResource(R.drawable.mag_mile3);
            image4.setImageResource(R.drawable.mag_mile4);
        }
        else if (item.image.equals("museum")) {
            image1.setImageResource(R.drawable.mag_mile1);
            image2.setImageResource(R.drawable.mag_mile2);
            image3.setImageResource(R.drawable.mag_mile3);
            image4.setImageResource(R.drawable.mag_mile4);
        }*/

        return view;
    }

    class FeedItem {
        String itemID;
        String title;
        String subtitle;
        String image;

        public FeedItem(String itemID, String title, String subtitle, String image) {
            this.itemID = itemID;
            this.title = title;
            this.subtitle = subtitle;
            this.image = image;
        }
    }
}
