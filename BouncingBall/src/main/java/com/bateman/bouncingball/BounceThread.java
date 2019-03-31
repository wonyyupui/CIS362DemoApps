package com.bateman.bouncingball;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class BounceThread extends Thread {

    private SurfaceHolder surfaceHolder;
    private AnimationArena animationArena;
    private boolean isRunning;

   public BounceThread (SurfaceHolder sh){
        isRunning = true;
        surfaceHolder = sh;
       animationArena = new AnimationArena();
    }

    public void run() {
        try {
            while (isRunning) {
                Canvas canvas = surfaceHolder.lockCanvas();
                animationArena.update(canvas.getWidth(),
                        canvas.getHeight());
                animationArena.draw(canvas);
                surfaceHolder.unlockCanvasAndPost(canvas);
            }
        }catch (NullPointerException e){
            e.printStackTrace();
        }
    }

    public void endBounce() {
        isRunning = false;
    }
}
