package com.kuruvatech.election.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.google.gson.Gson;
import com.kuruvatech.election.FeedDetail;
import com.kuruvatech.election.MainActivity;
import com.kuruvatech.election.R;
import com.kuruvatech.election.adapter.FeedAdapter;
import com.kuruvatech.election.model.FeedItem;

import java.util.ArrayList;


public class MainFragment extends Fragment {
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

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                if(true) {
//                    Intent i = new Intent(getActivity(), FeedDetail.class);
//                    Gson gson = new Gson();
//                    String strFeed = gson.toJson(feedList.get(position));
//                    i.putExtra("FeedItem", strFeed);
//                    startActivity(i);
//                }
//            }
//        });
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
        feedItem.setFeedimages(strList);
        feedList.add(feedItem);

        FeedItem feedItem2 = new FeedItem();
        feedItem2.setDescription("ದೇಶದ ಅಭಿವೃದ್ಧಿ ನಾಗಾಲೋಟದಲ್ಲಿ ಪ್ರಧಾನಿ #ನರೇಂದ್ರ ಮೋದಿ #ಯವರ ಹೆಮ್ಮೆಯ ಸಾಧನೆ#");
        feedItem2.setHeading( "#ನರೇಂದ್ರ ಮೋದಿ");
        ArrayList<String> strList2 = new ArrayList<String>();
        strList2.add("http://www.prajavani.net/sites/default/files/article_images/2017/10/24/p-of-ind-cm.jpg");
        feedItem2.setFeedimages(strList2);
        feedList.add(feedItem2);

        FeedItem feedItem3 = new FeedItem();
        feedItem3.setDescription("24.10.2017 ಮಂಗಳವಾರ ಇಂದು ಅನ್ಯಕಾರ್ಯ ನಿಮಿತ್ತ \n" +
                "ಚಿತ್ರದುರ್ಗ ಜಿಲ್ಲೆಯ ಹೊಸದುರ್ಗ ಪಟ್ಟಣಕ್ಕೆ ತೆರಳುವ ಮಾರ್ಗ ಮದ್ಯೆ ಬೆಲಗೂರು ಶ್ರೀ ಕ್ಷೇತ್ರ ಪಂಚಮುಖಿ ಆಂಜನೇಯ#ಸ್ವಾಮಿ ದೇವಾಲಯಕ್ಕೆ ಭೇಟಿ ನೀಡಿ ಪೂಜೆ ಸಲ್ಲಿಸಿ ಸನ್ನಿಧಿಯಲ್ಲಿ ಪೂಜ್ಯ ಶ್ರೀ ಬಿಂದು ಮಾಧವಶರ್ಮಾ ಸ್ವಾಮೀಜಿಯವರನ್ನು ಭೇಟಿ ಮಾಡಿ ಕೃಪಾಶೀರ್ವಾದ ಪಡೆದರು#");
        feedItem3.setHeading( "ಪಂಚಮುಖಿ ಆಂಜನೇ");
        ArrayList<String> strList3 = new ArrayList<String>();
        strList3.add("http://www.prajavani.net/sites/default/files/images/457588.jpg");
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
        feedItem4.setFeedimages(strList4);
        feedList.add(feedItem4);


    }
}
