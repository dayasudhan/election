package com.kuruvatech.election.model;

import java.util.ArrayList;

/**
 * Created by gagan on 10/24/2017.
 */
public class FeedItem {
    String description;
    String heading;
    ArrayList<String> feedimages;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String headinga) {
        heading = headinga;
    }

    public ArrayList<String> getFeedimages() {
        return feedimages;
    }

    public void setFeedimages(ArrayList<String> feedimages) {
        this.feedimages = feedimages;
    }
}
