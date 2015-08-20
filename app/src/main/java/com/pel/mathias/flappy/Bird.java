package com.pel.mathias.flappy;

import android.graphics.Bitmap;

/**
 * Created by Mathias on 09/08/2015.
 */
public class Bird {

    private int x, y;//top/left corners of picture
    private double vx, vy;
    private double ax, ay;
    private Bitmap image;
    private int width, height;
    private int pos;
    private double m;
    private double vlim = 10;


    Bird(int x, int y, Bitmap image) {
        this.x = x;
        this.y = y;
        this.image = image;
        width = image.getWidth();
        height = image.getHeight();
        m = 1;
    }

    public void move(double dt) {
        vy += Math.abs(vy + ay * dt) < vlim ? ay * dt : 0;
        y += vy * dt;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public int getPos() {
        return pos;
    }

    public Bitmap getImage() {
        return image;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public void setAy(double ay) {
        this.ay = ay;
    }

    public void push() {
        vy += 1.2 * vlim < (-0.2 * vy) ? 1.2 * vlim : vlim;
    }
}
