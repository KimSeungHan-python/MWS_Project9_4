package com.cookandroid.project4_1;

import android.graphics.Canvas;
import android.graphics.Paint;

public class RectShape extends Shape {
    int left, top, right, bottom;

    public RectShape(int x1, int y1, int x2, int y2) {
        // 좌표를 정규화하여 left, top, right, bottom 계산
        this.left = Math.min(x1, x2);
        this.top = Math.min(y1, y2);
        this.right = Math.max(x1, x2);
        this.bottom = Math.max(y1, y2);
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        canvas.drawRect(left, top, right, bottom, paint);
    }
}
