package com.kuruvatech.election;

import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.kuruvatech.election.utils.Constants;
import com.kuruvatech.election.utils.ImageLoader;

public class SingleViewActivity extends AppCompatActivity {

    public ImageLoader imageLoader;
    Button btnBack;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_view);
        imageLoader = new ImageLoader(getApplicationContext(),500,500);
      //  btnBack = (Button) findViewById(R.id.back_button);
        // Get intent data
        Intent i = getIntent();

        // Selected image id
        String url = i.getExtras().getString("url");

        ImageView imageView = (ImageView) findViewById(R.id.SingleView);
        imageLoader.DisplayImage(url, imageView);
        //setToolBar("ImageView");

    }
//    private void setToolBar(String areaClicked) {
//        Toolbar tb = (Toolbar) findViewById(R.id.toolbar2);
//        setSupportActionBar(tb);
//
//        ActionBar ab = getSupportActionBar();
//        ab.setHomeAsUpIndicator(R.drawable.ic_action_back);
//        ab.setDisplayHomeAsUpEnabled(true);
//        ab.setTitle(areaClicked);
//        tb.setTitleTextColor(Color.rgb(Constants.TITLE_TEXT_COLOR_RED,
//                Constants.TITLE_TEXT_COLOR_GREEN, Constants.TITLE_TEXT_COLOR_BLUE));
//    }

    @Override
    public boolean onOptionsItemSelected(android.view.MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
