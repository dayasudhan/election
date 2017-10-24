package com.kuruvatech.election.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.kuruvatech.election.MainActivity;
import com.kuruvatech.election.R;
import com.kuruvatech.election.adapter.feedAdapter;
import com.kuruvatech.election.utils.Constants;

import java.util.ArrayList;


public class MainFragment extends Fragment {
    Button btnshareApp;
    ArrayList<String> feedList;
    feedAdapter adapter;
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

        feedList = new ArrayList<String>();
        feedList.add("Feed 1");
        feedList.add("24.10.2017 ಮಂಗಳವಾರ ಇಂದು ಚಿತ್ರದುರ್ಗ ಜಿಲ್ಲೆಯ ಹೊಸದುರ್ಗ ಪಟ್ಟಣದಲ್ಲಿ ಕುಂಚಗಿರಿಗೆ ಭೇಟಿ ನೀಡಿ ಕುಂಚಟಿಗ ಮಹಾಸಂಸ್ಥಾನ ಜಗಧ್ಗುರು ಶ್ರೀಶ್ರೀಶ್ರೀ ಶಾಂತವೀರ ಮಹಾಸ್ವಾಮೀಜಿಯವರನ್ನು ಭೇಟಿ ಮಾಡಿ ಪೂಜ್ಯರ ಕೃಪಾಶೀರ್ವಾದ ಪಡೆದರು");
        feedList.add("24.10.2017 ಮಂಗಳವಾರ ಇಂದು ಅನ್ಯಕಾರ್ಯ ನಿಮಿತ್ತ \n" +
                "ಚಿತ್ರದುರ್ಗ ಜಿಲ್ಲೆಯ ಹೊಸದುರ್ಗ ಪಟ್ಟಣಕ್ಕೆ ತೆರಳುವ ಮಾರ್ಗ ಮದ್ಯೆ ಬೆಲಗೂರು ಶ್ರೀ ಕ್ಷೇತ್ರ ಪಂಚಮುಖಿ ಆಂಜನೇಯ#ಸ್ವಾಮಿ ದೇವಾಲಯಕ್ಕೆ ಭೇಟಿ ನೀಡಿ ಪೂಜೆ ಸಲ್ಲಿಸಿ ಸನ್ನಿಧಿಯಲ್ಲಿ ಪೂಜ್ಯ ಶ್ರೀ ಬಿಂದು ಮಾಧವಶರ್ಮಾ ಸ್ವಾಮೀಜಿಯವರನ್ನು ಭೇಟಿ ಮಾಡಿ ಕೃಪಾಶೀರ್ವಾದ ಪಡೆದರು#");
        feedList.add("ದೇಶದ ಅಭಿವೃದ್ಧಿ ನಾಗಾಲೋಟದಲ್ಲಿ ಪ್ರಧಾನಿ #ನರೇಂದ್ರ ಮೋದಿ #ಯವರ ಹೆಮ್ಮೆಯ ಸಾಧನೆ#");
        feedList.add("Feed 5");
        feedList.add("Feed 6");
        feedList.add("Feed 7");
        feedList.add("Feed 8");
        feedList.add("Feed 9");
        feedList.add("Feed 10");
        adapter = new feedAdapter(getActivity(),R.layout.feeditem,feedList);
        listView.setAdapter(adapter);
        return rootview;
    }
    @Override
    public void onResume() {
        super.onResume();
    }
}
