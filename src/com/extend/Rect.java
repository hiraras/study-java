package com.extend;

public class Rect extends Shape {
    public Rect(String name) {
        super(name);
        this.setBorderNum(4);
        System.out.println(super.borderNum);
    }
}
