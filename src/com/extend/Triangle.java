package com.extend;

public class Triangle extends Shape {
    public Triangle() {}
    public Triangle(String name) {
        super(name);
        super.borderNum = 22;
        System.out.println("super.borderNum:" + super.borderNum);
    }
    void introduce() {
        System.out.println("hi I'm Triangle");
    }
    public void setBorderNum(int num) {
        this.borderNum = num;
    }
    public int getBorderNum() {
        return borderNum;
    }
}
