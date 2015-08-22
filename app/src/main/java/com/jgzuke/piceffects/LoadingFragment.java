package com.jgzuke.piceffects;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.jlmd.animatedcircleloadingview.AnimatedCircleLoadingView;

/**
 * Created by jgzuke on 15-08-22.
 */
public class LoadingFragment extends Fragment {

    private AnimatedCircleLoadingView mLoadingView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        View view = inflater.inflate(R.layout.fragment_loading, container, false);

        mLoadingView = (AnimatedCircleLoadingView) view.findViewById(R.id.loading_view);

        mLoadingView.startIndeterminate();

        return view;
    }

    public void updateProgress(int progress) {
        mLoadingView.setPercent(progress);

    }

    public void taskFailed() {
        mLoadingView.stopFailure();
    }
}
