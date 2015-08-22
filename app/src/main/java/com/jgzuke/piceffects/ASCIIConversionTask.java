package com.jgzuke.piceffects;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.util.Log;

import java.io.IOException;

/**
 * Created by jgzuke on 15-08-22.
 */
public class ASCIIConversionTask extends AsyncTask<Uri[], Void, Void> {
    private LoadingFragment mLoading;
    private Context mContext;

    public ASCIIConversionTask(Context context, BaseFragment loading) {
        mContext = context;
        mLoading = (LoadingFragment) loading;
    }

    @Override
    protected Void doInBackground(Uri[]... params) {
        Uri[] uris = params[0];
        for(int i = 0; i < uris.length; i++) {
            try {
                convertPicture(MediaStore.Images.Media.getBitmap(mContext.getContentResolver(), uris[i]));
            } catch (IOException e) {
                e.printStackTrace();
            }
            mLoading.updateProgress((i+1)/uris.length);
        }
        Log.e("myid", "doInBackground");
        mLoading.getASCIIResults(new String[0]);
        return null;
    }

    private void convertPicture(Bitmap image) {

    }
}
