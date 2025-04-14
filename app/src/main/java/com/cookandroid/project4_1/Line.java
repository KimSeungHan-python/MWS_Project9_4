package com.cookandroid.project4_1;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Line extends Shape {
    int startX, startY, stopX, stopY;

    public Line(int startX, int startY, int stopX, int stopY) {
        this.startX = startX;
        this.startY = startY;
        this.stopX = stopX;
        this.stopY = stopY;
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        canvas.drawLine(startX, startY, stopX, stopY, paint);
    }
}
