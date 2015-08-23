package com.jgzuke.piceffects;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class StartFragment extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        View view = inflater.inflate(R.layout.fragment_start, container, false);
        View insertPicture = view.findViewById(R.id.insertPictureButton);
        insertPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mActivity.pickImages();
            }
        });
        return view;
    }
}
