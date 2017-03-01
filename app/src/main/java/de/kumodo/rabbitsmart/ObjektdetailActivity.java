package de.kumodo.rabbitsmart;

/**
 * Created by l.schmidt on 28.02.2017.
 */

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class ObjektdetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objektdetail);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_objektdetail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_settings) {

            startActivity(new Intent(this, EinstellungenActivity.class));
            return true;
        }

        if (id == R.id.action_starte_browser) {
            zeigeWebseiteImBrowser();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void zeigeWebseiteImBrowser(){

        String webseitenURL = "";

        // Die AktiendetailActivity wurde über einen Intent aufgerufen
        // Wir lesen aus dem empfangenen Intent die übermittelten Daten aus
        // und bauen daraus die URL der aufzurufenden Webseite
        Intent empfangenerIntent = this.getIntent();
        if (empfangenerIntent != null && empfangenerIntent.hasExtra(Intent.EXTRA_TEXT)) {
            String aktienInfo = empfangenerIntent.getStringExtra(Intent.EXTRA_TEXT);

            int pos = aktienInfo.indexOf(":");
            String symbol = aktienInfo.substring(0, pos);
            webseitenURL  = "http://finance.yahoo.com/q?s=" + symbol;
        }

        // Erzeugen des Data-URI Scheme für die anzuzeigende Webseite
        // Mehr Infos auf der "Common Intents" Seite des Android Developer Guides:
        // http://developer.android.com/guide/components/intents-common.html#Browser
        Uri webseitenUri = Uri.parse(webseitenURL);

        // Erzeugen eines impliziten View-Intents mit der Data URI-Information
        Intent intent = new Intent(Intent.ACTION_VIEW, webseitenUri);

        // Prüfen ob eine Web-App auf dem Android Gerät installiert ist
        // und Starten der App mit dem oben erzeugten impliziten View-Intent
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            String LOG_TAG = ObjektdetailActivity.class.getSimpleName();
            Log.d(LOG_TAG, "Keine passende App installiert!");
        }
    }
}
