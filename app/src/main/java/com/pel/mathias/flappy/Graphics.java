package com.pel.mathias.flappy;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.Vector;

/**
 * Created by Mathias on 09/08/2015.
 */
public class Graphics extends SurfaceView implements SurfaceHolder.Callback {

    private Bird bird;
    private Vector<Obstacle> obstacles;
    private Background background;
    private SurfaceHolder holder;
    private int viewWidth, viewHeight;

    public Graphics(Context context, AttributeSet attrs, Bird bird, Vector<Obstacle> obstacles, Background background) {
        super(context, attrs);
        this.bird = bird;
        this.obstacles = obstacles;
        this.background = background;
        holder = getHolder();
        holder.addCallback(this);
        setFocusable(true);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        Canvas c = holder.lockCanvas(null);
        onDraw(c);
        holder.unlockCanvasAndPost(c);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    @Override
    protected void onSizeChanged(int xNew, int yNew, int xOld, int yOld) {
        super.onSizeChanged(xNew, yNew, xOld, yOld);
        viewWidth = xNew;
        viewHeight = yNew;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.BLACK);
        canvas.drawBitmap(background.getImage(), 0, 0, null);
        canvas.drawBitmap(bird.getImage(), bird.getX(), bird.getY(), null);
        for (Obstacle obstacle : obstacles) {
            canvas.drawBitmap(obstacle.getTop(), obstacle.getX(), obstacle.getBas_trou() - obstacle.getLargeur_trou() - obstacle.getHauteur(), null);
            canvas.drawBitmap(obstacle.getBottom(), obstacle.getX(), obstacle.getBas_trou() + obstacle.getHauteur(), null);
        }
    }

    public void refresh() {
        Canvas c = holder.lockCanvas(null);
        onDraw(c);
        holder.unlockCanvasAndPost(c);
    }

    public int getViewHeight() {
        return viewHeight;
    }

    public int getViewWidth() {
        return viewWidth;
    }
}
