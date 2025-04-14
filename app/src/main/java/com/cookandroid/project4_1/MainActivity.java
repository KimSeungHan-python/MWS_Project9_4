package com.cookandroid.project4_1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    // 도형 타입 상수 (1: 선, 2: 원, 3: 사각형)
    public static final int LINE = 1;
    public static final int CIRCLE = 2;
    public static final int RECT = 3;
    // 현재 선택된 도형 타입 (초기값은 선)
    public static int curShape = LINE;
    // MyGraphicView의 참조를 저장 (그림 지우기 기능 사용을 위해)
    private MyGraphicView graphicView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        graphicView = new MyGraphicView(this);
        setContentView(graphicView);
        setTitle("간단 그림판");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 옵션 메뉴에 도형 추가 및 그림 지우기 항목 추가
        menu.add(0, 1, 0, "선 추가");
        menu.add(0, 2, 0, "원 추가");
        menu.add(0, 3, 0, "사각형 추가");
        menu.add(0, 4, 0, "그림 지우기");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                curShape = LINE;
                break;
            case 2:
                curShape = CIRCLE;
                break;
            case 3:
                curShape = RECT;
                break;
            case 4:
                // 그림 지우기: MyGraphicView에 구현한 clearShapes() 메소드를 호출
                graphicView.clearShapes();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
