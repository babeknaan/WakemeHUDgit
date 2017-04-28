package com.example.anthagonas.wakemehud;


import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by vtrjd on 25/04/2017.
 */


public class RssReader {
    private String rssUrl;

    public RssReader(String rssUrl)
    {
        this.rssUrl=rssUrl;
    }
    public List<RssItem> getItems() throws Exception
    {
        SAXParserFactory factory=SAXParserFactory.newInstance();
        SAXParser saxParser=factory.newSAXParser();
        RssParser handler = new RssParser();
        saxParser.parse(rssUrl,handler);
        return handler.getItems();
    }
}
