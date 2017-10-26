package com.kuruvatech.election.adapter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Typeface;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.kuruvatech.election.FeedDetail;
import com.kuruvatech.election.R;
import com.kuruvatech.election.model.FeedItem;
import com.kuruvatech.election.utils.ImageLoader;

import java.util.ArrayList;

/**
 * Created by gagan on 10/23/2017.
 */
public class FeedAdapter extends BaseAdapter {

    Activity con;
    Typeface cr;
    int layoutResID;
    private ArrayList<FeedItem> mFeedList;

    public ImageLoader imageLoader;
    public FeedAdapter(Activity context, int layoutResourceID,
                       ArrayList<FeedItem> itemList) {
        con = context;
        mFeedList = itemList;
        layoutResID = layoutResourceID;
        Display display = context.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        imageLoader = new ImageLoader(con.getApplicationContext(),width,height);
    }
    @Override
    public int getCount() {
        return mFeedList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
       ItemHolder itemHolder;
        View view = convertView;


        itemHolder = new ItemHolder();
        if(view==null){
            LayoutInflater inflater = ((Activity)con).getLayoutInflater();
            view = inflater.inflate(layoutResID, parent, false);


            itemHolder = new ItemHolder();
            itemHolder.description= (TextView) view.findViewById(R.id.feed_description);
            itemHolder.imageView= (ImageView) view.findViewById(R.id.vendor_image_view);
            itemHolder.feedheading= (TextView) view.findViewById(R.id.feed_name);
            itemHolder.btShowmore=(Button)view.findViewById(R.id.btShowmore);
            view.setTag(itemHolder);
        }else{
            itemHolder = (ItemHolder) view.getTag();
        }
        itemHolder.btShowmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  Toast.makeText(con,"hi hwllow",Toast.LENGTH_LONG).show();
                Intent i = new Intent(con, FeedDetail.class);
                Gson gson = new Gson();
                String strFeed = gson.toJson(mFeedList.get(position));
                i.putExtra("FeedItem", strFeed);
                con.startActivity(i);
            }
        });

        itemHolder.description.setText(mFeedList.get(position).getDescription());

        itemHolder.feedheading.setText(mFeedList.get(position).getHeading());
//        itemHolder.description.post(new Runnable() {
//            @Override
//            public void run() {
//               // int lineCount = itemHolder.description.getLineCount();
//                // Use lineCount here
//            }
//        });
        if(mFeedList.get(position).getDescription().length() > 500 )
        {
            itemHolder.description.setMaxLines(5);
            itemHolder.btShowmore.setVisibility(View.VISIBLE);
        }
        else
        {
            itemHolder.btShowmore.setVisibility(View.GONE);
        }
        //makeTextViewResizable(itemHolder.description, 3, "View More", true);
        //String image_url = "http://www.prajavani.net/sites/default/files/article_images/2017/10/24/kbec27rain.jpg";
        imageLoader.DisplayImage(mFeedList.get(position).getFeedimages(), itemHolder.imageView);

        return view;

    }
    private static class ItemHolder {
        TextView description;
        TextView feedheading;
        ImageView imageView;
        Button btShowmore;
    }


}
