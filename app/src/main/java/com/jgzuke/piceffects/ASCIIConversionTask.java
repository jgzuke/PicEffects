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
            new char[] {'|', '/', '\\', '*', '_', '^'},
            new char[] {'-', '_', '^', '<', '>', '=', ':'},
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
        int[][] darkness = new int[9][5];
        for(int j = 0; j < charsY; j++) {
            for(int i = 0; i < charsX; i++) {
                int x1 = imageWidth  *   i   / charsX;
                int y1 = imageHeight *   j   / charsY;
                for(int k = 0; k < 9; k++) {
                    image.getPixels(darkness[k], 0, imageWidth, x1, y1+1 + k, 5, 1);
                }
                mResults.append(getChar(darkness));
            }
            publishResults();
            mResults.append("\n");
        }
        mResults.append("\n\n");
    }

    private char getChar(int[][] darkness) {
        int brightness = 0;
        for(int x = 0; x < 5; x++) {
            for(int y = 0; y < 9; y++) {
                int color = darkness[y][x];
                float[] rgb = { Color.red(color), Color.green(color), Color.blue(color) };
                brightness += (int) ((rgb[0]*.241) + (rgb[1]*.691) + (rgb[2]*.068));
            }
        }
        brightness /= (5*9);
        int index = brightness / 64; // 0,1,2,3
        char[] chars = SYMBOLS[index];
        for(int x = 0; x < 5; x++) {
            for(int y = 0; y < 9; y++) {
                int color = darkness[y][x];
            }
        }

        return chars[0];
    }

    @Override
    protected void onProgressUpdate(String... progress) {
        mDisplay.updateProgress(progress[0]);
    }
}
