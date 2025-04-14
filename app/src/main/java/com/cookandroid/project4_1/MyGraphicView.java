package com.cookandroid.project4_1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class MyGraphicView extends View {
    int startX = -1, startY = -1, stopX = -1, stopY = -1;
    // 도형 객체들을 관리할 리스트
    List<Shape> shapeList = new ArrayList<>();
    Paint paint;

    public MyGraphicView(Context context) {
        super(context);
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.RED);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                // 터치 시작 좌표 저장
                startX = (int) event.getX();
                startY = (int) event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                // 터치 이동 시 현재 좌표 저장 및 미리 그리기 (옵션)
                stopX = (int) event.getX();
                stopY = (int) event.getY();
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                // 터치 종료 좌표 저장
                stopX = (int) event.getX();
                stopY = (int) event.getY();
                // 현재 선택한 도형 타입에 따라 객체 생성 후 리스트에 추가
                switch (MainActivity.curShape) {
                    case MainActivity.LINE:
                        shapeList.add(new Line(startX, startY, stopX, stopY));
                        break;
                    case MainActivity.CIRCLE:
                        int radius = (int) Math.sqrt(Math.pow(stopX - startX, 2) + Math.pow(stopY - startY, 2));
                        shapeList.add(new Circle(startX, startY, radius));
                        break;
                    case MainActivity.RECT:
                        shapeList.add(new RectShape(startX, startY, stopX, stopY));
                        break;
                }
                invalidate();
                break;
        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 리스트에 저장된 모든 도형 객체를 그리기
        for (Shape shape : shapeList) {
            shape.draw(canvas, paint);
        }
    }

    // 그림 지우기 기능 메소드: shapeList 초기화 후 화면 갱신
    public void clearShapes() {
        shapeList.clear();
        invalidate();
    }
}
