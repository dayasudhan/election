package com.kuruvatech.election.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.kuruvatech.election.FeedDetail;
import com.kuruvatech.election.MainActivity;
import com.kuruvatech.election.R;
import com.kuruvatech.election.adapter.FeedAdapter;
import com.kuruvatech.election.model.FeedItem;
import com.kuruvatech.election.utils.Constants;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;


public class MainFragment extends Fragment {
    private static final String TAG_FEEDS = "feeds";
    private static final String TAG_ID = "id";
    private static final String TAG_HEADING = "heading";
    private static final String TAG_DESCRIPTION = "description";
    private static final String TAG_FEEDIMAGES = "feedimages";
    private static final String TAG_LENGTH = "length";
    Button btnshareApp;
    ArrayList<FeedItem> feedList;
    FeedAdapter adapter;
    View rootview;
    ListView listView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_main, container, false);
        listView = (ListView) rootview.findViewById(R.id.listView_feedlist);
        ((MainActivity) getActivity())
                .setActionBarTitle("ಕನ್ನಡ");

        initfeeds();
        adapter = new FeedAdapter(getActivity(),R.layout.feeditem,feedList);
        listView.setAdapter(adapter);

        return rootview;
    }
    @Override
    public void onResume() {
        super.onResume();
    }

    private void initfeeds()
    {
        feedList = new ArrayList<FeedItem>();
        FeedItem feedItem = new FeedItem();
        feedItem.setDescription("24.10.2017 ಮಂಗಳವಾರ ಇಂದು ಚಿತ್ರದುರ್ಗ ಜಿಲ್ಲೆಯ ಹೊಸದುರ್ಗ ಪಟ್ಟಣದಲ್ಲಿ ಕುಂಚಗಿರಿಗೆ ಭೇಟಿ ನೀಡಿ ಕುಂಚಟಿಗ ಮಹಾಸಂಸ್ಥಾನ ಜಗಧ್ಗುರು ಶ್ರೀಶ್ರೀಶ್ರೀ ಶಾಂತವೀರ ಮಹಾಸ್ವಾಮೀಜಿಯವರನ್ನು ಭೇಟಿ ಮಾಡಿ ಪೂಜ್ಯರ ಕೃಪಾಶೀರ್ವಾದ ಪಡೆದರು");
        feedItem.setHeading( "ಕುಂಚಗಿರಿಗೆ ಭೇಟ");
        ArrayList<String> strList = new ArrayList<String>();
        strList.add("http://www.prajavani.net/sites/default/files/article_images/2017/10/24/kbec27rain.jpg");
        strList.add("http://www.prajavani.net/sites/default/files/article_images/2017/10/24/p-of-ind-cm.jpg");
        strList.add("http://www.prajavani.net/sites/default/files/images/457588.jpg");
        strList.add("http://www.prajavani.net/sites/default/files/article_images/2017/10/24/kbec27rain.jpg");
        strList.add("http://www.prajavani.net/sites/default/files/images/457588.jpg");
        feedItem.setFeedimages(strList);
        feedList.add(feedItem);

        FeedItem feedItem2 = new FeedItem();
        feedItem2.setDescription("ದೇಶದ ಅಭಿವೃದ್ಧಿ ನಾಗಾಲೋಟದಲ್ಲಿ ಪ್ರಧಾನಿ #ನರೇಂದ್ರ ಮೋದಿ #ಯವರ ಹೆಮ್ಮೆಯ ಸಾಧನೆ#");
        feedItem2.setHeading( "#ನರೇಂದ್ರ ಮೋದಿ");
        ArrayList<String> strList2 = new ArrayList<String>();
        strList2.add("http://www.prajavani.net/sites/default/files/article_images/2017/10/24/p-of-ind-cm.jpg");
        strList2.add("http://www.prajavani.net/sites/default/files/article_images/2017/10/24/p-of-ind-cm.jpg");
        feedItem2.setFeedimages(strList2);
        feedList.add(feedItem2);

        FeedItem feedItem3 = new FeedItem();
        feedItem3.setDescription("24.10.2017 ಮಂಗಳವಾರ ಇಂದು ಅನ್ಯಕಾರ್ಯ ನಿಮಿತ್ತ \n" +
                "ಚಿತ್ರದುರ್ಗ ಜಿಲ್ಲೆಯ ಹೊಸದುರ್ಗ ಪಟ್ಟಣಕ್ಕೆ ತೆರಳುವ ಮಾರ್ಗ ಮದ್ಯೆ ಬೆಲಗೂರು ಶ್ರೀ ಕ್ಷೇತ್ರ ಪಂಚಮುಖಿ ಆಂಜನೇಯ#ಸ್ವಾಮಿ ದೇವಾಲಯಕ್ಕೆ ಭೇಟಿ ನೀಡಿ ಪೂಜೆ ಸಲ್ಲಿಸಿ ಸನ್ನಿಧಿಯಲ್ಲಿ ಪೂಜ್ಯ ಶ್ರೀ ಬಿಂದು ಮಾಧವಶರ್ಮಾ ಸ್ವಾಮೀಜಿಯವರನ್ನು ಭೇಟಿ ಮಾಡಿ ಕೃಪಾಶೀರ್ವಾದ ಪಡೆದರು#");
        feedItem3.setHeading( "ಪಂಚಮುಖಿ ಆಂಜನೇ");
        ArrayList<String> strList3 = new ArrayList<String>();
        strList3.add("http://www.prajavani.net/sites/default/files/images/457588.jpg");
        strList3.add("http://www.prajavani.net/sites/default/files/article_images/2017/10/24/p-of-ind-cm.jpg");
        feedItem3.setFeedimages(strList3);
        feedList.add(feedItem3);

        FeedItem feedItem4 = new FeedItem();
        feedItem4.setDescription("ಬೆಂಗಳೂರು: ಕಾಂಗ್ರೆಸ್ ಉಪಾಧ್ಯಕ್ಷ ರಾಹುಲ್ ಗಾಂಧಿ ಅವರು 2019ರ ಲೋಕಸಭೆ ಚುನಾವಣೆಯ ಪ್ರಧಾನಿ ಅಭ್ಯರ್ಥಿ ಎಂದು ಹಿರಿಯ ಕಾಂಗ್ರೆಸ್ ನಾಯಕ, ಸಂಸದ ಎಂ.ವೀರಪ್ಪ ಮೊಯಿಲಿ ಮಂಗಳವಾರ ತಿಳಿಸಿದ್ದಾರೆ.\n" +
                "\n" +
                "‘ಪ್ರಧಾನಿ ನರೇಂದ್ರ ಮೋದಿ ಅವರ ವಿರುದ್ಧ ಈಚಿನ ಎಂಟು ತಿಂಗಳಿಂದ ವಿರೋಧಿ ಅಲೆಯಿದೆ. 2019ರಲ್ಲಿ ರಾಹುಲ್ ಗಾಂಧಿ ಅವರು ಪ್ರಧಾನಿಯಾಗಲು ವೇದಿಕೆ ಸಿದ್ಧವಾಗಿದೆ’ ಎಂದು ಮೊಯ್ಲಿ ಪತ್ರಿಕಾಗೋಷ್ಠಿಯಲ್ಲಿ ತಿಳಿಸಿದ್ದಾರೆ. ಈ ಮೂಲಕ ಪ್ರಸಕ್ತ ತಿಂಗಳು ಎರಡನೇ ಬಾರಿಗೆ ರಾಹುಲ್ ಅವರನ್ನು ಪಕ್ಷದ ಪ್ರಧಾನಿ ಅಭ್ಯರ್ಥಿ ಎಂದು ಮೋಯಿಲಿ ಬಿಂಬಿಸಿದ್ದಾರೆ.\n" +
                "\n" +
                "ಕಳೆದ ತಿಂಗಳು ಕ್ಯಾಲಿಫೋರ್ನಿಯಾ ವಿಶ್ವವಿದ್ಯಾಲಯದಲ್ಲಿ ರಾಹುಲ್ ಗಾಂಧಿ ಅವರು ಸ್ವತಃ ಉನ್ನತ ಕೆಲಸಕ್ಕಾಗಿ ‘ಸಂಪೂರ್ಣವಾಗಿ ಸಿದ್ಧ’ ಎಂದು ಹೇಳಿದ್ದರು.\n" +
                "\n" +
                "ಬಿಜೆಪಿ ನೇತೃತ್ವದ ಎನ್\u200Cಡಿಎ ಸರಕಾರ ಆರ್ಥಿಕ ವಿಷಯದಲ್ಲಿ ‘ಅನನುಭವಿ ಮತ್ತು ದುರ್ಬಳಕೆ’ಯಿಂದ ಕೂಡಿದೆ ಎಂದು ಆಪಾದಿಸಿದ ವೀರಪ್ಪ ಮೊಯಿಲಿ ಅವರು, ನೋಟು ರದ್ದತಿ ಮತ್ತು ಜಿಎಸ್\u200Cಟಿ ಇದಕ್ಕೆ ಸೂಕ್ತ ಉದಾಹರಣೆ ಎಂದರು.\n" +
                "\n" +
                "2013ರಲ್ಲಿ ಕರ್ನಾಟಕ ಕೈಗಾರಿಕೆ ಕ್ಷೇತ್ರದಲ್ಲಿ 11ನೇ ಸ್ಥಾನದಲ್ಲಿತ್ತು. ಈಗ ಪ್ರಥಮ ಸ್ಥಾನದಲ್ಲಿದೆ. ₹1,44,131 ಕೋಟಿ ಹೂಡಿಕೆ ಆಗಿದೆ. 114.19 ಲಕ್ಷ ಉದ್ಯೋಗ ಸೃಷ್ಟಿಯಾಗಿದೆ. ಎಲ್ಲ ಸಂಕಷ್ಟಗಳ ನಡುವೆ ಕೈಗಾರಿಕೆಯಲ್ಲಿ ರಾಜ್ಯ ಪ್ರಥಮ ಸ್ಥಾನದಲ್ಲಿ ಪಡೆದಿದೆ ಎಂದು ರಾಜ್ಯ ಸರ್ಕಾರದ ಸಾಧನೆಯನ್ನು ಮೊಯಿಲಿ ಶ್ಲಾಘಿಸಿದರು.\n" +
                "\n" +
                "6,40,925 ಎಕರೆಗೆ ನೀರಾವರಿ ವ್ಯವಸ್ಥೆ ಮಾಡಲಾಗಿದೆ. ನಾಲ್ಕು ವರ್ಷಗಳಲ್ಲಿ ರಾಜ್ಯ ಸರ್ಕಾರ ನೀರಾವರಿಯಲ್ಲಿ ಉತ್ತಮ ಕೆಲಸ ಮಾಡಿದೆ. ಕಳೆದ ನಾಲ್ಕು ವರ್ಷಗಳಲ್ಲಿ ಪ್ರತಿ ಬಜೆಟ್\u200Cನಲ್ಲಿ ರಾಜಸ್ವ ಹೆಚ್ಚುವರಿ ಆಗುವಂತೆ ಮಾಡಿದ್ದಾರೆ. ಆರ್ಥಿಕ ಶಿಸ್ತನ್ನು ಸಿಎಂ ಸಿದ್ದರಾಮಯ್ಯ ಅವರು ಕಾಪಾಡಿದ್ದಾರೆ. ತೆರಿಗೆ ವಸೂಲಿಯಲ್ಲೂ ರಾಜ್ಯ ಉತ್ತಮ ಸಾಧನೆ ಮಾಡಿದೆ ಎಂದು ವೀರಪ್ಪ ಮೊಯಿಲಿ ಅವರು ರಾಜ್ಯ ಸರ್ಕಾರವನ್ನು ಸಮರ್ಥಿಸಿಕೊಂಡರು.");
        feedItem4.setHeading( "2019ರಲ್ಲಿ ರಾಹುಲ್ ಗಾಂಧಿ ಪ್ರಧಾನಿ: ವೀರಪ್ಪ ಮೊಯಿಲಿ");
        ArrayList<String> strList4 = new ArrayList<String>();
        strList4.add("http://www.prajavani.net/sites/default/files/article_images/2017/10/24/m-vm-rg.jpg");
        strList4.add("http://www.prajavani.net/sites/default/files/article_images/2017/10/24/p-of-ind-cm.jpg");
        feedItem4.setFeedimages(strList4);
        feedList.add(feedItem4);

        FeedItem feedItem5 = new FeedItem();
        feedItem5.setDescription("ಬೆಂಗಳೂರು: ಕಾಂಗ್ರೆಸ್ ಉಪಾಧ್ಯಕ್ಷ ರಾಹುಲ್ ಗಾಂಧಿ ಅವರು 2019ರ ಲೋಕಸಭೆ ಚುನಾವಣೆಯ ಪ್ರಧಾನಿ ಅಭ್ಯರ್ಥಿ ಎಂದು ಹಿರಿಯ ಕಾಂಗ್ರೆಸ್ ನಾಯಕ, ಸಂಸದ ಎಂ.ವೀರಪ್ಪ ಮೊಯಿಲಿ ಮಂಗಳವಾರ ತಿಳಿಸಿದ್ದಾರೆ.\n" +
                "\n" +
                "‘ಪ್ರಧಾನಿ ನರೇಂದ್ರ ಮೋದಿ ಅವರ ವಿರುದ್ಧ ಈಚಿನ ಎಂಟು ತಿಂಗಳಿಂದ ವಿರೋಧಿ ಅಲೆಯಿದೆ. 2019ರಲ್ಲಿ ರಾಹುಲ್ ಗಾಂಧಿ ಅವರು ಪ್ರಧಾನಿಯಾಗಲು ವೇದಿಕೆ ಸಿದ್ಧವಾಗಿದೆ’ ಎಂದು ಮೊಯ್ಲಿ ಪತ್ರಿಕಾಗೋಷ್ಠಿಯಲ್ಲಿ ತಿಳಿಸಿದ್ದಾರೆ. ಈ ಮೂಲಕ ಪ್ರಸಕ್ತ ತಿಂಗಳು ಎರಡನೇ ಬಾರಿಗೆ ರಾಹುಲ್ ಅವರನ್ನು ಪಕ್ಷದ ಪ್ರಧಾನಿ ಅಭ್ಯರ್ಥಿ ಎಂದು ಮೋಯಿಲಿ ಬಿಂಬಿಸಿದ್ದಾರೆ.\n" +
                "\n" +
                "ಕಳೆದ ತಿಂಗಳು ಕ್ಯಾಲಿಫೋರ್ನಿಯಾ ವಿಶ್ವವಿದ್ಯಾಲಯದಲ್ಲಿ ರಾಹುಲ್ ಗಾಂಧಿ ಅವರು ಸ್ವತಃ ಉನ್ನತ ಕೆಲಸಕ್ಕಾಗಿ ‘ಸಂಪೂರ್ಣವಾಗಿ ಸಿದ್ಧ’ ಎಂದು ಹೇಳಿದ್ದರು.\n" +
                "\n" +
                "ಬಿಜೆಪಿ ನೇತೃತ್ವದ ಎನ್\u200Cಡಿಎ ಸರಕಾರ ಆರ್ಥಿಕ ವಿಷಯದಲ್ಲಿ ‘ಅನನುಭವಿ ಮತ್ತು ದುರ್ಬಳಕೆ’ಯಿಂದ ಕೂಡಿದೆ ಎಂದು ಆಪಾದಿಸಿದ ವೀರಪ್ಪ ಮೊಯಿಲಿ ಅವರು, ನೋಟು ರದ್ದತಿ ಮತ್ತು ಜಿಎಸ್\u200Cಟಿ ಇದಕ್ಕೆ ಸೂಕ್ತ ಉದಾಹರಣೆ ಎಂದರು.\n" +
                "\n" +
                "2013ರಲ್ಲಿ ಕರ್ನಾಟಕ ಕೈಗಾರಿಕೆ ಕ್ಷೇತ್ರದಲ್ಲಿ 11ನೇ ಸ್ಥಾನದಲ್ಲಿತ್ತು. ಈಗ ಪ್ರಥಮ ಸ್ಥಾನದಲ್ಲಿದೆ. ₹1,44,131 ಕೋಟಿ ಹೂಡಿಕೆ ಆಗಿದೆ. 114.19 ಲಕ್ಷ ಉದ್ಯೋಗ ಸೃಷ್ಟಿಯಾಗಿದೆ. ಎಲ್ಲ ಸಂಕಷ್ಟಗಳ ನಡುವೆ ಕೈಗಾರಿಕೆಯಲ್ಲಿ ರಾಜ್ಯ ಪ್ರಥಮ ಸ್ಥಾನದಲ್ಲಿ ಪಡೆದಿದೆ ಎಂದು ರಾಜ್ಯ ಸರ್ಕಾರದ ಸಾಧನೆಯನ್ನು ಮೊಯಿಲಿ ಶ್ಲಾಘಿಸಿದರು.\n" +
                "\n" +
                "6,40,925 ಎಕರೆಗೆ ನೀರಾವರಿ ವ್ಯವಸ್ಥೆ ಮಾಡಲಾಗಿದೆ. ನಾಲ್ಕು ವರ್ಷಗಳಲ್ಲಿ ರಾಜ್ಯ ಸರ್ಕಾರ ನೀರಾವರಿಯಲ್ಲಿ ಉತ್ತಮ ಕೆಲಸ ಮಾಡಿದೆ. ಕಳೆದ ನಾಲ್ಕು ವರ್ಷಗಳಲ್ಲಿ ಪ್ರತಿ ಬಜೆಟ್\u200Cನಲ್ಲಿ ರಾಜಸ್ವ ಹೆಚ್ಚುವರಿ ಆಗುವಂತೆ ಮಾಡಿದ್ದಾರೆ. ಆರ್ಥಿಕ ಶಿಸ್ತನ್ನು ಸಿಎಂ ಸಿದ್ದರಾಮಯ್ಯ ಅವರು ಕಾಪಾಡಿದ್ದಾರೆ. ತೆರಿಗೆ ವಸೂಲಿಯಲ್ಲೂ ರಾಜ್ಯ ಉತ್ತಮ ಸಾಧನೆ ಮಾಡಿದೆ ಎಂದು ವೀರಪ್ಪ ಮೊಯಿಲಿ ಅವರು ರಾಜ್ಯ ಸರ್ಕಾರವನ್ನು ಸಮರ್ಥಿಸಿಕೊಂಡರು.");
        feedItem5.setHeading( "2019ರಲ್ಲಿ ರಾಹುಲ್ ಗಾಂಧಿ ಪ್ರಧಾನಿ: ವೀರಪ್ಪ ಮೊಯಿಲಿ");

       // feedItem5.setFeedimages(nu);
        feedList.add(feedItem5);


    }
    public void getFeeds()
    {

        feedList.clear();

        String order_url = Constants.GET_HOTEL_BY_DELIVERY_AREAS;

        String area = areaClicked.replace(" ", "%20");
        order_url = order_url + area;
        if(isBulk)
        {
            order_url = order_url + "&isbulkrequest=1";
        }
        else
        {
            order_url = order_url + "&isbulkrequest=0";
        }
        new JSONAsyncTask().execute(order_url);
    }
    public  class JSONAsyncTask extends AsyncTask<String, Void, Boolean> {
        Dialog dialog;
        public JSONAsyncTask() {

        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();


        }

        @Override
        protected Boolean doInBackground(String... urls) {
            try {

                //------------------>>
                HttpGet request = new HttpGet(urls[0]);
//                request.addHeader(Constants.SECUREKEY_KEY, Constants.SECUREKEY_VALUE);
//                request.addHeader(Constants.VERSION_KEY, Constants.VERSION_VALUE);
//                request.addHeader(Constants.CLIENT_KEY, Constants.CLIENT_VALUE);
                HttpClient httpclient = new DefaultHttpClient();
                HttpResponse response = httpclient.execute(request);

                // StatusLine stat = response.getStatusLine();
                int status = response.getStatusLine().getStatusCode();

                if (status == 200) {
                    HttpEntity entity = response.getEntity();
                    String data = EntityUtils.toString(entity);
//                    Toast.makeText(getActivity().getApplicationContext(), data, Toast.LENGTH_LONG).show();

                    JSONArray jarray = new JSONArray(data);
                    for (int i = 0; i < jarray.length(); i++) {
                        JSONObject object = jarray.getJSONObject(i);
                        HotelDetail hotelDetail = new HotelDetail();
                        if (object.has(TAG_MENU)) {
                            JSONArray menuArray = object.getJSONArray(TAG_MENU);
                            hotelDetail.getMenu().clear();
                            for (int j = 0; j < menuArray.length(); j++) {
                                JSONObject menu_object = menuArray.getJSONObject(j);
                                MenuItem menuItem = new MenuItem();
//                                if(menu_object.has(TAG_ID))
//                                    menuItem.set_id(menu_object.getString(TAG_ID));
                                if(menu_object.has(TAG_NAME))
                                    menuItem.setName(menu_object.getString(TAG_NAME));
                                if(menu_object.has("description"))
                                    menuItem.setItemDescription(menu_object.getString("description"));
                                if(menu_object.has("logo"))
                                    menuItem.setLogo(menu_object.getString("logo"));
                                String dd =menu_object.getString(TAG_PRICE);
                                if(menu_object.has(TAG_PRICE) ) {
                                    try {
                                        menuItem.setPrice(menu_object.getInt(TAG_PRICE));
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                                if(menu_object.has(TAG_AVAILIBILITY)) {

                                    try {
                                        if(menu_object.getInt(TAG_AVAILIBILITY) == 1)
                                            menuItem.setAvailable(1);
                                        else
                                            menuItem.setAvailable(0);
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                                hotelDetail.getMenu().add(menuItem);
                            }
                        }
                        if(object.has(TAG_ID))
                            hotelDetail.set_id(object.getString(TAG_ID));

                        if(object.has(TAG_SPECIALITY))
                            hotelDetail.setSpeciality(object.getString(TAG_SPECIALITY));

                        if(object.has(TAG_HOTEL))
                        {
                            JSONObject hotelObj = object.getJSONObject(TAG_HOTEL);
                            if (hotelObj.has(TAG_NAME)) {
                                hotelDetail.getHotel().setName(hotelObj.getString(TAG_NAME));
                            }
                            if (hotelObj.has(TAG_EMAIL)) {
                                hotelDetail.getHotel().setEmail(hotelObj.getString(TAG_EMAIL));
                            }
                            if (hotelObj.has(TAG_ID2)) {
                                hotelDetail.getHotel().setId(hotelObj.getString(TAG_ID2));
                            }
                            if (hotelObj.has(TAG_LOGO)) {
                                hotelDetail.getHotel().setLogo(hotelObj.getString(TAG_LOGO));
                            }
                        }
                        if (object.has(TAG_PHONE)) {
                            hotelDetail.setPhone(object.getString(TAG_PHONE));
                            hotelDetail.getHotel().setPhone(hotelDetail.getPhone());
                        }
                        if (object.has(TAG_ADDRESS)) {
                            JSONObject addrObj = object.getJSONObject(TAG_ADDRESS);
                            if(addrObj.has("addressLine1"))
                                hotelDetail.getAddress().setAddressLine1(addrObj.getString("addressLine1"));
                            if(addrObj.has("addressLine2"))
                                hotelDetail.getAddress().setAddressLine2(addrObj.getString("addressLine2"));
                            if(addrObj.has("areaName"))
                                hotelDetail.getAddress().setAreaName(addrObj.getString("areaName"));
                            if(addrObj.has("city"))
                                hotelDetail.getAddress().setCity(addrObj.getString("city"));
                            if(addrObj.has("LandMark"))
                                hotelDetail.getAddress().setLandMark(addrObj.getString("LandMark"));
                            if(addrObj.has("street"))
                                hotelDetail.getAddress().setStreet(addrObj.getString("street"));
                            if(addrObj.has("street"))
                                hotelDetail.getAddress().setZip(addrObj.getString("street"));
                        }

                        if(object.has(TAG_DELIVERY_AREAS))
                        {
                            JSONArray delieveryArray = object.getJSONArray(TAG_DELIVERY_AREAS);
                            hotelDetail.getDeliverAreas().clear();
                            for (int j = 0; j < delieveryArray.length(); j++) {
                                JSONObject da_object = delieveryArray.getJSONObject(j);
                                if (da_object.has(TAG_NAME))
                                    hotelDetail.getDeliverAreas().add(da_object.getString(TAG_NAME));
                            }
                        }
                        if(object.has(TAG_ISOPEN))
                        {
                            int var=0 ;
                            try {
                                var = object.getInt(TAG_ISOPEN);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            hotelDetail.setIsOpen(var);
                        }
                        if(object.has(TAG_RATING))
                        {
                            int rating=0 ;
                            try {
                                rating = object.getInt(TAG_RATING);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            hotelDetail.setRating(rating);
                        }

                        if(object.has(TAG_ORDER_ACCEPT_TIMINGS))
                        {
                            JSONObject ordAcctime = object.getJSONObject(TAG_ORDER_ACCEPT_TIMINGS);
                            Gson gson = new Gson();
                            OrderAcceptTimings ordacctimeobj =  gson.fromJson(ordAcctime.toString(),OrderAcceptTimings.class);
                            hotelDetail.setOrderAcceptTimings(ordacctimeobj);

                        }
                        if(isBulk)
                        {
                            if (object.has(TAG_BULK_DELIVERY_RANGE)) {
                                int range = 0;
                                try {
                                    range = object.getInt(TAG_BULK_DELIVERY_RANGE);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                hotelDetail.setDeliverRange(range);
                            }

                            if (object.has(TAG_BULK_DELIVERY_CHARGE)) {
                                int charge = 0;
                                try {
                                    charge = object.getInt(TAG_BULK_DELIVERY_CHARGE);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                hotelDetail.setDeliverCharge(charge);
                            }

                            if (object.has(TAG_BULK_MINIMUM_ORDER)) {
                                int rating = 0;
                                try {
                                    rating = object.getInt(TAG_BULK_MINIMUM_ORDER);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                hotelDetail.setMinimumOrder(rating);
                            }

                            if (object.has(TAG_BULK_DELIVERY_TIME)) {
                                int delieveryTime = 0;
                                try {
                                    delieveryTime = object.getInt(TAG_BULK_DELIVERY_TIME);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                hotelDetail.setDeliveryTime(delieveryTime);
                            }
                        }
                        else {

                            if (object.has(TAG_DELIVERY_RANGE)) {
                                int range = 0;
                                try {
                                    range = object.getInt(TAG_DELIVERY_RANGE);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                hotelDetail.setDeliverRange(range);
                            }

                            if (object.has(TAG_DELIVERY_CHARGE)) {
                                int charge = 0;
                                try {
                                    charge = object.getInt(TAG_DELIVERY_CHARGE);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                hotelDetail.setDeliverCharge(charge);
                            }

                            if (object.has(TAG_MINIMUM_ORDER)) {
                                int rating = 0;
                                try {
                                    rating = object.getInt(TAG_MINIMUM_ORDER);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                hotelDetail.setMinimumOrder(rating);
                            }

                            if (object.has(TAG_DELIVERY_TIME)) {
                                int delieveryTime = 0;
                                try {
                                    delieveryTime = object.getInt(TAG_DELIVERY_TIME);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                hotelDetail.setDeliveryTime(delieveryTime);
                            }
                        }
                        hotellist.add(hotelDetail);

                    }
                    return true;
                }
            } catch (IOException e) {
                e.printStackTrace();

            } catch (Exception e) {
                e.printStackTrace();
            }

            return false;

        }
        protected void onPostExecute(Boolean result) {

            if(getActivity() != null) {
                if (result == false) {

                    Toast.makeText(getActivity().getApplicationContext(), "Unable to fetch data from server", Toast.LENGTH_LONG).show();
                    //alertMessage("Unable to fetch data from server");
                } else {
                    initHotelList();

                    swipeRefreshLayout.setRefreshing(false);
                }
            }

        }
    }
}
