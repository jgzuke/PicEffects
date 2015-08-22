package com.jgzuke.piceffects;

import android.support.v4.app.Fragment;

/**
 * Created by jgzuke on 15-08-22.
 */
public class BaseFragment extends Fragment {
    protected MainActivity mActivity;
    public BaseFragment setActivity(MainActivity activity) {
        mActivity = activity;
        return this;
    }
}
