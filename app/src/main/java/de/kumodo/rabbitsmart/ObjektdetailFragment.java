package de.kumodo.rabbitsmart;

/**
 * Created by l.schmidt on 28.02.2017.
 */

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class ObjektdetailFragment extends Fragment {

    public ObjektdetailFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_objektdetail, container, false);

        // Die AktiendetailActivity wurde über einen Intent aufgerufen
        // Wir lesen aus dem empfangenen Intent die übermittelten Daten aus
        Intent empfangenerIntent = getActivity().getIntent();
        if (empfangenerIntent != null && empfangenerIntent.hasExtra(Intent.EXTRA_TEXT)) {
            String objektInfo = empfangenerIntent.getStringExtra(Intent.EXTRA_TEXT);
            ((TextView) rootView.findViewById(R.id.objektdetail_text))
                    .setText(objektInfo);
        }

        return rootView;
    }
}

