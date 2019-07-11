package com.extend;

public class Shape {
    private String name;
    int borderNum = -1;
    public Shape() {}
    public Shape(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setBorderNum(int num) {
        this.borderNum = num;
    }
    public int getBorderNum() {
        return borderNum;
    }
    public void printShapeMsg() {
        System.out.println("I'm " + name);
    }
}
