package com.pel.mathias.flappy;

import java.util.Vector;

/**
 * Created by Mathias on 09/08/2015.
 */
public class Physics {
    private static double g = 9.8;
    private Bird bird;
    private Vector<Obstacle> obstacles;

    public Physics(Bird bird, Vector<Obstacle> obstacles) {
        this.bird = bird;
        this.obstacles = obstacles;
    }


    public boolean intersect() {
        for (Obstacle obstacle : obstacles) {
            if (bird.getX() < (obstacle.getX() + obstacle.getLargeur()) && (bird.getX() + bird.getWidth()) > obstacle.getX() && bird.getY() < (obstacle.get))
        }
    }

    ;
}
