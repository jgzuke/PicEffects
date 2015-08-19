package com.jgzuke.piceffects;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gc.materialdesign.views.ButtonFloat;

import nl.changer.polypicker.Config;
import nl.changer.polypicker.ImagePickerActivity;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    private static final int INTENT_REQUEST_GET_IMAGES = 1;

    private ButtonFloat mInsertPictureButton;

    private Uri[] mUris;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        mInsertPictureButton = (ButtonFloat) view.findViewById(R.id.insertPictureButton);
        mInsertPictureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickImages();
            }
        });
        return view;
    }

    private void pickImages() {
        Intent intent = new Intent(getActivity(), ImagePickerActivity.class);
        Config config = new Config.Builder()
                .setTabBackgroundColor(R.color.white)
                .setTabSelectionIndicatorColor(R.color.blue)
                .setCameraButtonColor(R.color.green)
                .build();
        ImagePickerActivity.setConfig(config);
        startActivityForResult(intent, INTENT_REQUEST_GET_IMAGES);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if (resultCode == Activity.RESULT_OK && requestCode == INTENT_REQUEST_GET_IMAGES) {
            Parcelable[] parcelableUris = intent.getParcelableArrayExtra(ImagePickerActivity.EXTRA_IMAGE_URIS);
            if (parcelableUris != null) {
                mUris = new Uri[parcelableUris.length];
                System.arraycopy(parcelableUris, 0, mUris, 0, parcelableUris.length);
            }
        }
    }
}
