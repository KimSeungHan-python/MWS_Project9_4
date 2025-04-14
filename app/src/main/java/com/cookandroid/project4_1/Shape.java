package com.cookandroid.project4_1;

import android.graphics.Canvas;
import android.graphics.Paint;

public abstract class Shape {
    // 각 도형 클래스에서 캔버스에 그리기 위해 반드시 구현해야 하는 메소드
    public abstract void draw(Canvas canvas, Paint paint);
}
