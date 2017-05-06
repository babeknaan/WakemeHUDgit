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

    //Le nom des champs a recuperer des evenements des calendriers
    public static String[] CHAMPS =
            {
                    CalendarContract.Events._ID,
                    CalendarContract.Events.DTSTART,
                    CalendarContract.Events.DURATION
            };


    //un parser URI permettant de recuperer tout les calendriers synchronises avec l'appareil
    public static final Uri URI_parser = Uri.parse("content://com.android.calendar/calendars"); // Pour l'API 2.2 et plus


    //Creation d'un contentResolver, qui permet d'acceder aux valeurs des calendriers
    ContentResolver contentResolver;
    ArrayList<String> nomEvenement = new ArrayList<String>();
    ArrayList<String> dateDepartEvenement = new ArrayList<String>();
    ArrayList<String> dureeEvenement = new ArrayList<String>();



    //Constructeur de la classe
    public AgendaList(Context ctx) {
        contentResolver = ctx.getContentResolver();
    }

    public void majList() {
        // Recupere la liste de tout les evenements des agendas synchronises avec l'appareil
        Cursor cursor = contentResolver.query(URI_parser, CHAMPS, null, null, null);

        try {
            if (cursor.getCount() > 0) {
                //Pour chaque element du curseur (donc chaque agenda)
                while (cursor.moveToNext()) {
                    String idEvent = cursor.getString(0);
                    String date = cursor.getString(1);
                    String duree = cursor.getString(2);
                    nomEvenement.add(idEvent); // recuperation du nom de l'evenement
                    dateDepartEvenement.add(date); // recuperation de la date de depart
                    dureeEvenement.add(duree); // recuperation de la duree de l'evenement
                }
            }
        } catch (AssertionError ex) { /*TODO: creer un log d'erreur*/ }
    }
    public ArrayList<String > getNomEvenement()
    {
        return nomEvenement;
    }
    public ArrayList<String > getDateDepartEvenement()
    {
        return dateDepartEvenement;
    }
    public ArrayList<String > getDureeEvenement()
    {
        return dureeEvenement;
    }

}
