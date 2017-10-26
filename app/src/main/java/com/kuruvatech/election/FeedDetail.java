package com.kuruvatech.election;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.kuruvatech.election.model.FeedItem;
import com.kuruvatech.election.utils.Constants;
import com.kuruvatech.election.utils.ImageLoader;

public class FeedDetail extends AppCompatActivity {

    FeedItem feedItem;
    TextView description;
    TextView feedheading;
    ImageView imageView;
    public ImageLoader imageLoader;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_detail);
        imageLoader = new ImageLoader(getApplicationContext(),500,500);
        Intent intent = getIntent();
        Gson gson = new Gson();
        feedItem = gson.fromJson(intent.getStringExtra("FeedItem"), FeedItem.class);
        description= (TextView) findViewById(R.id.detail_feed_description);
        imageView= (ImageView) findViewById(R.id.detail_vendor_image_view);
        feedheading= (TextView) findViewById(R.id.detail_feed_name);
        btnBack = (Button) findViewById(R.id.back_button);
        description.setText(feedItem.getDescription());
        feedheading.setText(feedItem.getHeading());
        imageLoader.DisplayImage(feedItem.getFeedimages(), imageView);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                onBackPressed();
            }
        });
        setToolBar("Register");
    }

    private void setToolBar(String areaClicked) {
        Toolbar tb = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(tb);

        ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_action_back);
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setTitle(areaClicked);
        tb.setTitleTextColor(Color.rgb(Constants.TITLE_TEXT_COLOR_RED,
                Constants.TITLE_TEXT_COLOR_GREEN, Constants.TITLE_TEXT_COLOR_BLUE));
    }

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
