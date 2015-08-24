package com.jgzuke.piceffects;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.util.Log;

import java.io.IOException;

/**
 * Created by jgzuke on 15-08-22.
 */
public class ASCIIConversionTask extends AsyncTask<Uri[], String, Void> {
    private static final double WHRatio = 5.0/11.0; //46;
    private static final char[][] SYMBOLS = new char[][] {
            new char[] {'#', '%'},
            new char[] {'|', '[', ']', '/', '\\', '*'},
            new char[] {'-', '_', '^', '<', '>', '=', '+', ':'},
            new char[] {' ', '\'', '.'}
    };

    private int charsX = 110;
    private int charsY;

    private DisplayASCIIFragment mDisplay;
    private Context mContext;
    private StringBuilder mResults;

    public ASCIIConversionTask(Context context, BaseFragment loading, int chars) {
        mContext = context;
        mDisplay = (DisplayASCIIFragment) loading;
        charsX = chars;
    }

    @Override
    protected Void doInBackground(Uri[]... params) {
        Uri[] uris = params[0];
        mResults = new StringBuilder();
        for(int i = 0; i < uris.length; i++) {
            Bitmap image = getBitmapFromUri(uris[i]);
            if(image != null) {
                convertPicture(image);
            }
        }
        return null;
    }

    private void publishResults() {
        publishProgress(mResults.toString());
    }

    private Bitmap getBitmapFromUri(Uri uri) {
        Uri uri2 = Uri.parse("file://" + uri.toString());
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

    private void convertPicture(Bitmap image) {
        int imageWidth  = image.getWidth();
        int imageHeight = image.getHeight();
        charsY = (int)(WHRatio * charsX * imageHeight / imageWidth);
        for(int j = 0; j < charsY; j++) {
            for(int i = 0; i < charsX; i++) {
                int x1 = imageWidth  *   i   / charsX;
                int x2 = imageWidth  * (i+1) / charsX;
                int y1 = imageHeight *   j   / charsY;
                int y2 = imageHeight * (j+1) / charsY;
                mResults.append(getChar(x1, y1, x2, y2, image));
            }
            publishResults();
            mResults.append("\n");
        }
        mResults.append("\n\n");
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

    @Override
    protected void onProgressUpdate(String... progress) {
        mDisplay.updateProgress(progress[0]);
    }
}
