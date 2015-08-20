package com.pel.mathias.flappy;

import android.graphics.Bitmap;

/**
 * Created by Mathias on 09/08/2015.
 */
public class Obstacle {
    private Bitmap top;
    private Bitmap bottom;
    private int bas_trou, largeur_trou, x, largeur, hauteur, ordre;
    private double vx;

    public Obstacle(int largeur_trou, int bas_trou, int x, double vx, int ordre, Bitmap bottom, Bitmap top) {
        this.largeur_trou = largeur_trou;
        this.bas_trou = bas_trou;
        this.x = x;
        this.vx = vx;
        this.ordre = ordre;
        this.bottom = bottom;
        this.top = top;
        this.largeur = top.getWidth();
        this.hauteur = top.getHeight();
    }

    public void move(double dt) {
        x += vx * dt;
    }

    public int getBas_trou() {
        return bas_trou;
    }

    public int getLargeur_trou() {
        return largeur_trou;
    }

    public int getX() {
        return x;
    }

    public int getLargeur() {
        return largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public int getOrdre() {
        return ordre;
    }

    public double getVx() {
        return vx;
    }

    public Bitmap getTop() {
        return top;
    }

    public Bitmap getBottom() {
        return bottom;
    }


}
