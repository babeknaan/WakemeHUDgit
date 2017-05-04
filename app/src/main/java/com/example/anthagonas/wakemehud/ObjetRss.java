package com.example.anthagonas.wakemehud;

/**
 * Created by vtrjd on 04/05/2017.
 */

public class ObjetRss {

    private final String title;
    private final String link;

    public ObjetRss(String title, String link) {
        this.title = title;
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }
}
