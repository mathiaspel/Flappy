package com.pel.mathias.flappy;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;

import java.util.Random;
import java.util.Vector;

/**
 * Created by Mathias on 09/08/2015.
 */
public class GameLoop extends Thread {
    private boolean finish;
    private Context context;
    private Graphics graphics;
    private Physics physics;
    private Bird bird;
    private Vector<Obstacle> obstacles;
    private Point screen_size;
    private double vx, dt;
    private boolean isRunning;

    public GameLoop(Context context, Graphics graphics) {
        finish = false;
        this.context = context;
        this.graphics = graphics;
        screen_size.set(graphics.getViewWidth(), graphics.getViewHeight());
        vx = -10;
        dt = 10;
    }

    @Override
    public void run() {
        super.run();
        Bitmap imageBird = new BitmapFactory().decodeResource(context.getResources(), R.raw.bird);
        imageBird = Bitmap.createScaledBitmap(imageBird, (int) ((double) (0.05 * 210) / 150 * 0.05 * screen_size.y), (int) 0.05 * screen_size.y, false);
        bird = new Bird(100, screen_size.y / 2, imageBird);

        Random rand = new Random();
        int largeur_trou = graphics.getViewHeight() / 15 + rand.nextInt(graphics.getViewHeight() / 4);
        int bas_trou = largeur_trou + rand.nextInt(graphics.getViewHeight() - largeur_trou);
        Bitmap imageObstacleTop = new BitmapFactory().decodeResource(context.getResources(), R.raw.top);
        Bitmap imageObstacleBottom = new BitmapFactory().decodeResource(context.getResources(), R.raw.bottom);
        imageObstacleTop = Bitmap.createScaledBitmap(imageObstacleTop, (int) (0.05 * 210 / 150 * 0.05 * screen_size.y), (int) 0.05 * screen_size.y, false);
        imageObstacleBottom = Bitmap.createScaledBitmap(imageObstacleBottom, (int) (0.05 * 210 / 150 * 0.05 * screen_size.y), (int) 0.05 * screen_size.y, false);
        Obstacle obstacle = new Obstacle(largeur_trou, bas_trou, graphics.getWidth() + imageObstacleTop.getWidth() + 50, vx, 0, imageObstacleBottom, imageObstacleTop);
        obstacles.add(obstacle);

        isRunning = true;
        while (!finish) {


        }

    }

    public void finish() {
        finish = true;
        isRunning = false;
    }

    public void touch() {
        if (isRunning)
            bird.push();
    }
}
