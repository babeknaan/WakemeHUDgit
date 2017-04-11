package com.example.anthagonas.wakemehud;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Vincent on 30/03/17.
 */

public class Parametres extends AppCompatActivity {

    private ListView multi_parametres=null;
    private ListView simple_parametre=null;
    private Button valide=null;
    private String[] parametre_simple={"Premier choix","Second choix"};
    private String[] parametre_multiples={"item 1","item 2", "item 3","item 4", "item 5"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametres);

        simple_parametre=(ListView) findViewById(R.id.unique_liste);
        multi_parametres=(ListView) findViewById(R.id.multi_liste);
        valide=(Button) findViewById(R.id.valider);

        simple_parametre.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice,parametre_simple));
        simple_parametre.setItemChecked(0,true);

        multi_parametres.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice,parametre_multiples));
        multi_parametres.setItemChecked(1,true);

        valide.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(Parametres.this,"Données modifiées", Toast.LENGTH_LONG).show();
            }
        });
    }

}
