package com.jgzuke.piceffects;

import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;

/**
 * Created by jgzuke on 15-08-22.
 */
public class DisplayASCIIFragment extends BaseFragment {
    private TextView mASCIIDisplay;
    private View mASCIIDisplayContainer;

    private String[] mResults;
    private int mCharsX;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        final View view = inflater.inflate(R.layout.fragment_display_ascii, container, false);

        mASCIIDisplayContainer = view.findViewById(R.id.ascii_display_container);

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

        ViewTreeObserver vto = view.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                view.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                resizeText();

            }
        });

        return view;
    }

    public void setText(String[] results, int charsX) {
        mResults = results;
        mCharsX = charsX;
    }

    private void restartFromBeginning() {
        mActivity.pickImages();
    }

    private void resizeText() {
        /*Rect bounds = new Rect();
        Paint textPaint = new Paint();
        textPaint.setTextSize(2);
        textPaint.setTypeface(Typeface.MONOSPACE);
        textPaint.getTextBounds(mResults[0],0,110,bounds);*/
        float textWidth = mASCIIDisplay.getMeasuredWidth();

        float containerWidth = mASCIIDisplayContainer.getMeasuredWidth();
        float textSize = containerWidth / textWidth;
        mASCIIDisplay.setTextSize(textSize);
    }
}
