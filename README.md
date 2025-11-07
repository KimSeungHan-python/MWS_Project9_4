# Simple Paint App

![Java](https://img.shields.io/badge/Java-007396?style=flat-square&logo=java&logoColor=white)
![Android](https://img.shields.io/badge/Android-3DDC84?style=flat-square&logo=android&logoColor=white)

This is a basic drawing application for Android, built entirely in Java. It serves as an educational project to demonstrate core concepts of Android development, including custom views, touch event handling, and object-oriented principles.

This project was likely created for a **"Mobile Programming Web Service"** university course

## ✨ Features

* **Multi-Shape Drawing**: Users can choose to draw three different types of shapes:
    * Lines
    * Circles
    * Rectangles
* **Touch Controls**: Draw shapes directly on the screen by touching and dragging.
* **Persistent Canvas**: All drawn shapes are stored in a list and redrawn, allowing multiple shapes to exist on the canvas.
* **Clear Canvas**: A menu option is available to clear all drawn shapes from the screen instantly.

## 🛠️ Technical Stack & Concepts

* **Language**: **Java**
* **Platform**: **Android (Native)**
* **Core Concepts Demonstrated**:
    * **Custom View**: The app uses `MyGraphicView`, a class extending `View`, to create a fully custom drawing canvas.
    * **Canvas API**: Utilizes `onDraw()` and the `Canvas` object with a `Paint` tool to render shapes.
    * **Touch Event Handling**: Implements `onTouchEvent()` to capture user input (`ACTION_DOWN`, `ACTION_MOVE`, `ACTION_UP`) and get coordinates for drawing.
    * **Object-Oriented Programming (OOP)**:
        * **Abstraction**: An `abstract class Shape` defines a common interface (`draw()`) for all shape objects.
        * **Polymorphism**: `Line`, `Circle`, and `RectShape` classes all extend `Shape` and provide their own implementation of the `draw()` method.
        * **Encapsulation**: A `List<Shape>` in `MyGraphicView` holds all shape objects, regardless of their specific type, making them easy to manage and render in a loop.

## 📁 Code Structure

The project's logic is distributed across these key Java files:

* **`MainActivity.java`**:
    * The main entry point of the application.
    * It sets the content view to an instance of `MyGraphicView`.
    * It creates and manages the `OptionsMenu` (top-right menu) to select the current shape type (`curShape`) or clear the canvas.

* **`MyGraphicView.java`**:
    * The **core** of the project. This custom view acts as the drawing canvas.
    * It listens for touch events to get start and stop coordinates.
    * When a touch is released (`ACTION_UP`), it creates a new `Line`, `Circle`, or `RectShape` object (based on `MainActivity.curShape`) and adds it to a `List<Shape>`.
    * The `onDraw()` method iterates through this list and calls the `draw()` method on each `Shape` object, redrawing all shapes every time the view is invalidated.
    * Contains the `clearShapes()` method, which clears the list and refreshes the view.

* **`Shape.java`**:
    * An `abstract` base class that requires all subclasses to implement a `draw(Canvas canvas, Paint paint)` method.

* **`Line.java`**, **`Circle.java`**, **`RectShape.java`**:
    * Concrete classes that extend `Shape`. Each class stores the necessary coordinates (or radius) and implements the `draw()` method using the specific `canvas.draw...()` function for its type.

## 🚀 How to Use

1.  Run the application on an Android device or emulator.
2.  Open the options menu (top-right).
3.  Select a shape to draw. (The menu items are in Korean: "선 추가" - Add Line, "원 추가" - Add Circle, "사각형 추가" - Add Rectangle).
4.  Touch and drag on the screen to draw the selected shape.
5.  To erase everything, open the menu and select "그림 지우기" (Clear Drawing).
