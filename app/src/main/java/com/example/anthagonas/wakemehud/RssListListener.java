package com.example.anthagonas.wakemehud;



import android.content.Intent;
import android.support.v4.app.Fragment;
import android.widget.AdapterView.OnItemClickListener;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.net.Uri;

import java.util.List;

/**
 * Created by vtrjd on 25/04/2017.
 */

public class RssListListener implements OnItemClickListener
{
    List<RssItem>listItems;
    Fragment activity;

    public RssListListener(List<RssItem>itemList,Fragment activity)
    {
        this.listItems=itemList;
        this.activity=activity;
    }
    public void onItemClick(AdapterView<?> parent, View view, int pos, long id)
    {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(listItems.get(pos).getLink()));
        activity.startActivity(i);
    }
}
