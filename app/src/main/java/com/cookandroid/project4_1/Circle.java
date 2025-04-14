package com.cookandroid.project4_1;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Circle extends Shape {
    int centerX, centerY, radius;

    public Circle(int centerX, int centerY, int radius) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        canvas.drawCircle(centerX, centerY, radius, paint);
    }
}
