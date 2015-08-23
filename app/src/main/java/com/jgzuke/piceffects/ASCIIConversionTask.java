package com.jgzuke.piceffects;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.util.Log;

import java.io.IOException;

/**
 * Created by jgzuke on 15-08-22.
 */
public class ASCIIConversionTask extends AsyncTask<Uri[], Void, Void> {
    private static final char[][] SYMBOLS = new char[][] {
            new char[] {'#'},
            new char[] {'|'},
            new char[] {'-'},
            new char[] {' '}
    };

    private int charsX = 110;
    private int charsY;

    private LoadingFragment mLoading;
    private Context mContext;

    public ASCIIConversionTask(Context context, BaseFragment loading) {
        mContext = context;
        mLoading = (LoadingFragment) loading;
    }

    @Override
    protected Void doInBackground(Uri[]... params) {
        Uri[] uris = params[0];
        String[] results = new String[uris.length];
        for(int i = 0; i < uris.length; i++) {
            Bitmap image = getBitmapFromUri(uris[i]);
            if(image != null) {
                results[i] = convertPicture(image);
            }
            mLoading.updateProgress((i + 1) / uris.length);
        }
        mLoading.getASCIIResults(results);
        return null;
    }

    private Bitmap getBitmapFromUri(Uri uri) {
        Log.e("myid", "uri: " + uri.toString());
        Uri uri2 = Uri.parse("file://"+uri.toString());
        try {
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(mContext.getContentResolver(), uri2);
            int oldWidth = bitmap.getWidth();
            int newWidth = 5 * charsX;
            int newHeight = bitmap.getHeight() * newWidth / oldWidth;
            Bitmap scaled = Bitmap.createScaledBitmap(bitmap, newWidth, newHeight, false);
            return scaled;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String convertPicture(Bitmap image) {
        int imageWidth  = image.getWidth();
        int imageHeight = image.getHeight();
        charsY = charsX * imageHeight / 2 / imageWidth;
        StringBuilder result = new StringBuilder();
        for(int j = 0; j < charsY; j++) {
            for(int i = 0; i < charsX; i++) {
                int x1 = imageWidth  *   i   / charsX;
                int x2 = imageWidth  * (i+1) / charsX;
                int y1 = imageHeight *   j   / charsY;
                int y2 = imageHeight * (j+1) / charsY;
                result.append(getChar(x1, y1, x2, y2, image));
            }
            result.append("\n");
        }
        return result.toString();
    }

    private char getChar(int x1, int y1, int x2, int y2, Bitmap image) {
        int brightnessLevel = getBrightnessLevel(x1, y1, x2, y2, image);
        char[] chars = SYMBOLS[brightnessLevel];

        return chars[0];
    }

    private int getBrightnessLevel(int x1, int y1, int x2, int y2, Bitmap image) {
        int brightness = 0;
        for(int i = x1; i < x2; i++) {
            for(int j = y1; j < y2; j++) {
                int color = image.getPixel(i, j);
                float[] rgb = { Color.red(color), Color.green(color), Color.blue(color) };
                brightness += (int) ((rgb[0]*.241) + (rgb[1]*.691) + (rgb[2]*.068));
            }
        }
        brightness /= ((x2-x1) * (y2-y1));
        return brightness / 64; // 0,1,2,3
    }
}
