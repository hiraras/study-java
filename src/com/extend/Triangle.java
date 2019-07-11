package com.extend;

public class Triangle extends Shape {
    public Triangle(String name) {
        super(name);
        this.setBorderNum(3);
        System.out.println(super.borderNum);
    }
}
