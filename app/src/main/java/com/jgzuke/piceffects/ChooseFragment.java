package com.jgzuke.piceffects;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

public class ChooseFragment extends Fragment {

    private static final String[] OPTIONS = new String[] {
            "ASCII", "test"
    };
    private static final int[] OPTION_SCREEN_IDS = new int[] {
            R.id.ascii, R.id.test
    };
    private static View[] OPTION_SCREENS;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        View view = inflater.inflate(R.layout.fragment_choose, container, false);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_dropdown_item_1line, OPTIONS);
        MaterialBetterSpinner textView = (MaterialBetterSpinner) view.findViewById(R.id.chooseEffect);
        textView.setAdapter(adapter);
        textView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                textChanged(s.toString());
            }
        });

        View convertPicture = view.findViewById(R.id.convertButton);
        convertPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertPictures();
            }
        });

        OPTION_SCREENS = new View[OPTIONS.length];
        for(int i = 0; i < OPTIONS.length; i++) {
            OPTION_SCREENS[i] = view.findViewById(OPTION_SCREEN_IDS[i]);
        }

        return view;
    }

    private void convertPictures() {

    }

    private void textChanged(String text) {
        for(int i = 0; i < OPTIONS.length; i++) {
            OPTION_SCREENS[i].setVisibility(text.equals(OPTIONS[i])? View.VISIBLE : View.GONE);
        }
    }
}
