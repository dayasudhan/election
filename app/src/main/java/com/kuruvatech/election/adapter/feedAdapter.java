package com.kuruvatech.election.adapter;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Typeface;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kuruvatech.election.R;
import com.kuruvatech.election.utils.Constants;
import com.kuruvatech.election.utils.ImageLoader;

import java.util.ArrayList;

/**
 * Created by gagan on 10/23/2017.
 */
public class feedAdapter  extends BaseAdapter {

    Activity con;
    Typeface cr;
    int layoutResID;
    private ArrayList<String> mFeedList;

    public ImageLoader imageLoader;
    public feedAdapter(Activity context, int layoutResourceID,
                            ArrayList<String> itemList) {
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
        //  mpref= PreferenceManager.instance(con);
        //  LocationListNameModel city = getItem(position);

        itemHolder = new ItemHolder();
        if(view==null){
            LayoutInflater inflater = ((Activity)con).getLayoutInflater();
            view = inflater.inflate(layoutResID, parent, false);


            itemHolder = new ItemHolder();
            itemHolder.description= (TextView) view.findViewById(R.id.feed_description);
            itemHolder.imageView= (ImageView) view.findViewById(R.id.vendor_image_view);
//            itemHolder.hotelRating= (TextView) view.findViewById(R.id.vendor_rating);
//            itemHolder.hotelSpeciality= (TextView) view.findViewById(R.id.vendor_speciality);
//            itemHolder.hotellogo = (ImageView)view.findViewById(R.id.vendor_image_view);
//            itemHolder.hotelIsClosed = (TextView) view.findViewById(R.id.textViewIsopen);
//            ratingbar1=(RatingBar)view.findViewById(R.id.ratingBar1);
//            ratingbar1.setNumStars(5);
//            ratingbar1.setRating(3);
            itemHolder.description.setText(mFeedList.get(position));
            view.setTag(itemHolder);
        }else{
            itemHolder = (ItemHolder) view.getTag();
        }

        //   itemHolder.city.setTypeface(cr);
      //  itemHolder.description.setText("Hello Bengalore");
//        itemHolder.hotelDeliveryTime.setText(String.valueOf(mhotelList.get(position).getDeliveryTime()).concat(" mins"));
//        itemHolder.hotelRating.setText(String.valueOf(mhotelList.get(position).getRating()).concat("/5*"));
//        itemHolder.hotelSpeciality.setText(mhotelList.get(position).getSpeciality());
//        if(mhotelList.get(position).getIsOpen() == 0)
//        {
//            itemHolder.hotelIsClosed.setText("Closed now");
//        }
//        else
//        {
//            itemHolder.hotelIsClosed.setText("");
//        }

       // String image_url = Constants.MAIN_URL + '/' + mhotelList.get(position).getHotel().getLogo();
        if(position%2 == 0) {
            String image_url = "http://www.prajavani.net/sites/default/files/article_images/2017/10/24/kbec27rain.jpg";
            imageLoader.DisplayImage(image_url, itemHolder.imageView);
        }
        return view;

    }
    private static class ItemHolder {
        TextView description;
//        TextView hotelSpeciality;
//        TextView hotelRating;
//        TextView hotelDeliveryTime;
//        TextView hotelIsClosed;
        ImageView imageView;

    }
}
