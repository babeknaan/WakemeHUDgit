package com.example.anthagonas.wakemehud;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract;

import java.util.ArrayList;

/**
 * Created by Anthagonas on 05/05/2017.
 */

public class AgendaList {
    //Le nom des champs a recuperer des calendriers
    public static String[] CHAMPS =
            {
                    CalendarContract.Calendars.NAME,
                    CalendarContract.Calendars.CALENDAR_DISPLAY_NAME,
                    CalendarContract.Calendars.CALENDAR_COLOR,
                    CalendarContract.Calendars.VISIBLE
            };

    //un parser URI permettant de recuperer tout les agendas synchronises avec l'appareil
    public static final Uri URI_parser = Uri.parse("content://com.android.calendar/calendars"); // Pour l'API 2.2 et plus

    //Creation d'un contentResolver, qui permet d'acceder aux valeurs du contentProvider des calendriers
    ContentResolver contentResolver;
    ArrayList<String> agendas = new ArrayList<String>();


    public AgendaList(Context ctx) {
        contentResolver = ctx.getContentResolver();
    }

    public ArrayList<String> getCalendars() {
        // Recupere la liste de tout les agendas synchronises aec l'appareil et leur noms
        Cursor cursor = contentResolver.query(URI_parser, CHAMPS, null, null, null);

        try {
            if (cursor.getCount() > 0) {
                //Pour chaque element du curseur (donc chaque agenda)
                while (cursor.moveToNext()) {
                    String displayName = cursor.getString(1);
                    agendas.add(displayName); // recuperation du nom de l'agenda
                }
            }
        } catch (AssertionError ex) { /*TODO: creer un log d'erreur*/ }
        return agendas;
    }

}
