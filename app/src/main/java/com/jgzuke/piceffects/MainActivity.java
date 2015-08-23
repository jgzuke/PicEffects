package com.jgzuke.piceffects;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;

import nl.changer.polypicker.Config;
import nl.changer.polypicker.ImagePickerActivity;

public class MainActivity extends FragmentActivity {
    private static final int INTENT_REQUEST_GET_IMAGES = 1;

    private FragmentManager mFragmentManager;
    private BaseFragment mFragment;
    private Uri[] mUris;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFragmentManager = getSupportFragmentManager();
        setContentView(R.layout.activity_main);
        openFragment(new StartFragment().setActivity(this));
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    private void openFragment(BaseFragment fragment) {
        mFragment = fragment;
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, mFragment);
        fragmentTransaction.commit();
    }

    public void getPictureUris(Uri[] uris) {
        mUris = uris;
        if(uris.length > 0) {
            openFragment(new ChooseFragment().setActivity(this));
        }
    }

    public void convertPicturesASCII(int charsX) {
        BaseFragment loading = new LoadingFragment().setActivity(this);
        openFragment(loading);
        new ASCIIConversionTask(this, loading, charsX).doInBackground(mUris);
    }

    public void getASCIIResults(String[] results, int charsX) {
        openFragment(new DisplayASCIIFragment().setActivity(this));
        ((DisplayASCIIFragment) mFragment).setText(results, charsX);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if (resultCode == Activity.RESULT_OK && requestCode == INTENT_REQUEST_GET_IMAGES) {
            Parcelable[] parcelableUris = intent.getParcelableArrayExtra(ImagePickerActivity.EXTRA_IMAGE_URIS);
            if (parcelableUris != null) {
                Uri[] uris = new Uri[parcelableUris.length];
                System.arraycopy(parcelableUris, 0, uris, 0, parcelableUris.length);
                getPictureUris(uris);
            }
        }
    }

    public void pickImages() {
        Intent intent = new Intent(this, ImagePickerActivity.class);
        Config config = new Config.Builder()
                .setTabBackgroundColor(R.color.white)
                .setTabSelectionIndicatorColor(R.color.blue)
                .setCameraButtonColor(R.color.green)
                .build();
        ImagePickerActivity.setConfig(config);
        startActivityForResult(intent, INTENT_REQUEST_GET_IMAGES);
    }
}
