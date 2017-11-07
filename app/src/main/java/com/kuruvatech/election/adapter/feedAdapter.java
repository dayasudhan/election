package com.kuruvatech.election.adapter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.google.gson.Gson;
import com.kuruvatech.election.FeedDetail;
import com.kuruvatech.election.R;
import com.kuruvatech.election.RecyclerItemClickListener;
import com.kuruvatech.election.SingleViewActivity;
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
       // gridLayoutManager = new GridLayoutManager(con, 2);
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

//    public ArrayList<String> getFilePaths()
//    {
//        ArrayList<String> paths = new ArrayList<String>();
//        for(int i = 0 ; i< urls.size();i++)
//        {
//            paths.add(imageLoader.getFilePath(urls.get(i)));
//        }
//        return paths;
//    }

    private static class CustomSpanSizeLookup extends GridLayoutManager.SpanSizeLookup {
        private int totalcount;
        public CustomSpanSizeLookup(int total)
        {
            totalcount = total;
        }
        @Override
        public int getSpanSize(int i) {

            if(i == 0 ) {
                // grid items on positions 0 and 1 will occupy 2 spans of the grid
                return 2;
            } else if(totalcount%2 == 0 && i == 1){
                // the rest of the items will behave normally and occupy only 1 span

                return 2;
            }
            else
            {
                return 1;
            }
        }
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
//            itemHolder.imageView= (ImageView) view.findViewById(R.id.vendor_image_view);
            itemHolder.recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
            itemHolder.feedheading= (TextView) view.findViewById(R.id.feed_name);
            itemHolder.btShowmore=(Button)view.findViewById(R.id.btShowmore);
            itemHolder.imageshareButton= (ImageView)view.findViewById(R.id.shareit);
            // specify that grid will consist of 2 columns





            view.setTag(itemHolder);
        }else{
            itemHolder = (ItemHolder) view.getTag();
        }
        GridLayoutManager gridLayoutManager = new GridLayoutManager(con, 2);
        // provide our CustomSpanSizeLookup which determines how many spans each item in grid will occupy
        gridLayoutManager.setSpanSizeLookup(new CustomSpanSizeLookup(mFeedList.get(position).getFeedimages().size()));
        // provide our GridLayoutManager to the view
        itemHolder.recyclerView.setLayoutManager(gridLayoutManager);
        // this is fake list of images

        itemHolder.imageshareButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                ArrayList<Uri> imageUris = new ArrayList<Uri>();


                Intent shareIntent = new Intent();
                // shareIntent.setType("text/html");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT,  mFeedList.get(position).getHeading());
                shareIntent.putExtra(Intent.EXTRA_TEXT,  mFeedList.get(position).getDescription());
                if(mFeedList.get(position).getFeedimages().size()> 0) {
                    shareIntent.setType("image/*");

                    if (mFeedList.get(position).getFeedimages().size() > 0) {
                        imageUris.add(Uri.parse(imageLoader.getFilePath(mFeedList.get(position).getFeedimages().get(0))));
                        shareIntent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, imageUris);
                    }

                }
                else
                {
                    shareIntent.setType("text/plain");
                }
                shareIntent.setAction(Intent.ACTION_SEND);
                con.startActivity(Intent.createChooser(shareIntent, "Share it ...."));
                //startActivity(Intent.createChooser(sendIntent, "Share link!"));
            }
        });
        if(mFeedList.get(position).getFeedimages().size()> 0) {
            Adapter adapter = new Adapter(con, mFeedList.get(position).getFeedimages());
            itemHolder.recyclerView.setAdapter(adapter);
            itemHolder.recyclerView.addOnItemTouchListener(
                    new RecyclerItemClickListener(con, position,itemHolder.recyclerView ,
                            new RecyclerItemClickListener.OnItemClickListener() {
                                @Override public void onItemClick(View view, int position2, int myposition) {
                                    Intent i = new Intent(con, SingleViewActivity.class);

                                    i.putExtra("url", mFeedList.get(myposition).getFeedimages().get(position2));

                                    con.startActivity(i);
                            // do whatever
                            //mFeedList.get(position).getFeedimages().get(position2);
                            //    Toast.makeText(con,"hi click"+position2+mFeedList.get(position).getFeedimages().get(position2), Toast.LENGTH_LONG).show();
                        }

                        @Override public void onLongItemClick(View view, int position2) {


                        }
                    })
            );
        }
        else
        {
            itemHolder.recyclerView.setVisibility(View.GONE);
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

        if(mFeedList.get(position).getDescription().length() > 500 )
        {
            itemHolder.description.setMaxLines(5);
            itemHolder.btShowmore.setVisibility(View.VISIBLE);
        }
        else
        {
            itemHolder.btShowmore.setVisibility(View.GONE);
        }
        return view;

    }
    private static class ItemHolder {
        TextView description;
        TextView feedheading;
        ImageView imageView;
        Button btShowmore;
        RecyclerView recyclerView;
        ImageView imageshareButton;
    }


}
