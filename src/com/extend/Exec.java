package com.extend;

public class Exec {
    public static void main(String[] args) {
        Triangle triangle = new Triangle("triangle");
        Rect rect = new Rect("rect");
        triangle.printShapeMsg();
        System.out.println(triangle.getName());
        System.out.println(triangle.getBorderNum());
        System.out.println(rect.getName());
        System.out.println(rect.getBorderNum());
    }
}
