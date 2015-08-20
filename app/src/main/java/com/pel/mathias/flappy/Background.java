package com.pel.mathias.flappy;

import android.graphics.Bitmap;

/**
 * Created by Mathias on 09/08/2015.
 */
public class Background {
    private Bitmap image;

    public Background(Bitmap image) {
        this.image = image;
    }

    public Bitmap getImage() {
        return image;
    }
}
