package com.jgzuke.piceffects;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;

public class MainActivity extends FragmentActivity {

    private FragmentManager mFragmentManager;
    private Uri[] mUris;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFragmentManager = getSupportFragmentManager();
        setContentView(R.layout.activity_main);
        openFragment(new StartFragment());
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    private void openFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }

    public void getPictureUris(Uri[] uris) {
        mUris = uris;
        openFragment(new ChooseFragment());
    }

    public void convertPictures(int action) {
        LoadingFragment loading = new LoadingFragment();
        openFragment(loading);
        switch(action) {
            case ChooseFragment.ASCII:
                //openFragment(choose);
                break;
            default:
                //ChooseFragment choose = new ChooseFragment();
                //openFragment(choose);
                break;
        }
    }
}
