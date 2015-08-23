package com.jgzuke.piceffects;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by jgzuke on 15-08-22.
 */
public class DisplayASCIIFragment extends BaseFragment {
    private TextView mASCIIDisplay;

    private String[] mResults;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        View view = inflater.inflate(R.layout.fragment_display_ascii, container, false);

        mASCIIDisplay = (TextView) view.findViewById(R.id.ascii_display);
        mASCIIDisplay.setText(mResults[0]);
        mASCIIDisplay.setTypeface(Typeface.MONOSPACE);

        View retryButton = view.findViewById(R.id.retry_button);
        retryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restartFromBeginning();
            }
        });
        return view;
    }

    public void setText(String[] results) {
        mResults = results;
    }

    private void restartFromBeginning() {
        mActivity.pickImages();
    }
}
