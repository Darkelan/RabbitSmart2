package de.kumodo.rabbitsmart;

/**
 * Created by l.schmidt on 20.02.2017.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class ObjektlisteFragment extends Fragment{

    public ObjektlisteFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Menü bekannt geben, dadurch kann unser Fragment Menü-Events verarbeiten
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_objektlistefragment, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Wir prüfen, ob Menü-Element mit der ID "action_daten_aktualisieren"
        // ausgewählt wurde und geben eine Meldung aus
        int id = item.getItemId();
        if (id == R.id.action_daten_aktualisieren) {
            Toast.makeText(getActivity(), "Aktualisieren gedrückt!", Toast.LENGTH_LONG).show();

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String LOG_TAG = ObjektlisteFragment.class.getSimpleName();

        Log.v(LOG_TAG, "verbose     - Meldung");
        Log.d(LOG_TAG, "debug       - Meldung");
        Log.i(LOG_TAG, "information - Meldung");
        Log.w(LOG_TAG, "warning     - Meldung");
        Log.e(LOG_TAG, "error       - Meldung");

        String [] objektlisteArray = {
                "PC_1: 73,45 €",
                "PC_2: 145,12 €",
                "Drucker: 84,27 €",
                "MFC: 128,60 €",
                "Bildschirm_1: 80,55 €",
                "Bildschirm_2: 104,11 €",
                "Bildschirm_3: 12,47 €",
                "Software_1: 209,94 €",
                "Software_2: 84,33 €",
                "PC_1: 73,45 €",
                "PC_2: 145,12 €",
                "Drucker: 84,27 €",
                "MFC: 128,60 €",
                "Bildschirm_1: 80,55 €",
                "Bildschirm_2: 104,11 €",
                "Bildschirm_3: 12,47 €",
                "Software_1: 209,94 €",
                "Software_2: 84,33 €"
        };

        List<String> objektListe = new ArrayList<>(Arrays.asList(objektlisteArray));

        ArrayAdapter <String> objektlisteAdapter =
                new ArrayAdapter<>(
                        getActivity(), // Die aktuelle Umgebung (diese Activity)
                        R.layout.list_item_objektliste, // ID der XML-Layout Datei
                        R.id.list_item_objektliste_textview, // ID des TextViews
                        objektListe); // Beispieldaten in einer ArrayList

        View rootView = inflater.inflate(R.layout.fragment_objektliste, container, false);

        ListView objektlisteListView = (ListView) rootView.findViewById(R.id.listview_objektliste);
        objektlisteListView.setAdapter(objektlisteAdapter);

        return rootView;
    }

}
