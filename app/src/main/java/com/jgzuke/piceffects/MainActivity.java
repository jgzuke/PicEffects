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
        openFragment(new StartFragment().setActivity(this));
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
        openFragment(new ChooseFragment().setActivity(this));
    }

    public void convertPictures(int action) {
        BaseFragment loading = new LoadingFragment().setActivity(this);
        openFragment(loading);
        switch(action) {
            case ChooseFragment.ASCII:
                new ASCIIConversionTask(this, loading).doInBackground(mUris);
                break;
            default:
                new ASCIIConversionTask(this, loading).doInBackground(mUris);
                break;
        }
    }

    public void getASCIIResults(String[] results) {
        openFragment(new ChooseFragment().setActivity(this));
    }
}
