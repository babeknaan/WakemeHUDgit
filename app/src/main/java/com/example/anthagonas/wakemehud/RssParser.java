package com.example.anthagonas.wakemehud;



import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler; // Parser cree pour trier les elements xml via sax2

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vtrjd on 25/04/2017.
 */

public class RssParser extends DefaultHandler {

    private List<RssItem>rssItems;

    //item de reference pour le parsing
    private RssItem currentItem;

    //indicateur pour le titre
    private boolean parsingTitle;

    //indicateur pour le lien
    private boolean parsingLink;

    //constructeur
    public RssParser()
    {
        rssItems=new ArrayList<RssItem>();
    }

    //retourne la liste du parser
    public List<RssItem> getItems()
    {
        return rssItems;
    }

    //est execute quand le parser lit un opening tag
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        //cree un item rss vide quand le parser voit un opening tag
        if("item".equals(qName))
        {
            currentItem=new RssItem();
        }
        //set quand l'opening tag "title" est lu par le parser (pour ouvrir)
        else if("title".equals(qName))
        {
            parsingTitle=true;
        }
        //set quand l'opening tag "link" est lu par le parser (pour ouvrir)
        else if("link".equals(qName))
        {
            parsingLink=true;
        }
    }

    //est execute quand le parser lit un closing tag
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        //ajoute l'item a la liste lorsqu'un closing tag est lu
        if("item".equals(qName))
        {
            rssItems.add(currentItem);
            currentItem=null;
        }
        //set quand le closing tag "title" est lu par le parser (pour refermer)
        else if("title".equals(qName))
        {
            parsingTitle=false;
        }
        //set quand le closing tag "link" est lu par le parser (pour refermer)
        else if("link".equals(qName))
        {
            parsingLink = false;
        }
    }

    //execute lorsque le parser lit le contenu du tag
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        //donne les donnees a l'objet item entre les balises
        if(parsingTitle)
        {
            if (currentItem != null) {
                currentItem.setTitle(new String(ch, start, length));
            }
        }
        else if (parsingLink)
        {
            if(currentItem!=null)
            {
                currentItem.setLink(new String(ch,start,length));
                parsingLink=false;
            }
        }
    }
}
