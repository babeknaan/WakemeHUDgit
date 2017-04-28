package com.example.anthagonas.wakemehud;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * Created by anthagonas on 29/03/17.
 */

public class Rss extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view=inflater.inflate(R.layout.fragment_rss, container, false);
        super.onCreate(savedInstanceState);
        try
        {
            RssReader rssReader=new RssReader("http://www.itcuties.com/feed/");
            ListView listeItems = (ListView) getView().findViewById(R.id.listview);
            ArrayAdapter<RssItem> adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_list_item_1,rssReader.getItems());
            listeItems.setAdapter(adapter);
            listeItems.setOnItemClickListener(new RssListListener(rssReader.getItems(), this));
        }
        catch (Exception e)
        {
            Log.e("rssReader", e.getMessage());
        }
        return view;
    }
}
