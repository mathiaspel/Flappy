package com.pel.mathias.flappy;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    Button start, stop;
    GameLoop gameloop;
    Graphics graphics;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = (Button) findViewById(R.id.start);
        stop = (Button) findViewById(R.id.stop);
        graphics = (Graphics) findViewById(R.id.graphics);

        start.setOnClickListener(startListener);
        stop.setOnClickListener(stopListener);
        graphics.setOnTouchListener(touchListener);
    }

    View.OnClickListener startListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            graphics.setVisibility(View.VISIBLE);
            gameloop = new GameLoop(graphics);
            gameloop.start();
        }
    };

    View.OnClickListener stopListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (gameloop != null)
                gameloop.finish();
        }
    };

    View.OnTouchListener touchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            gameloop.touch();
            return false;
        }
    };

}
