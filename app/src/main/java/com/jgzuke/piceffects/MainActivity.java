package com.jgzuke.piceffects;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;

public class MainActivity extends FragmentActivity {

    private FragmentManager mFragmentManager;

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
        ChooseFragment choose = new ChooseFragment();
        openFragment(choose);
    }
}
