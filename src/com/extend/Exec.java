package com.extend;

public class Exec {
    private static final void testFinalFunc(final int a) {
        System.out.println(a);
        System.out.println(a);
    }
    public static void main(String[] args) {
        Triangle triangle = new Triangle("triangle");
        Rect rect = new Rect("rect");
        EqualTriangle eTriangle = new EqualTriangle("equal Triangle");
        triangle.printShapeMsg();
        System.out.println(triangle.getName());
        System.out.println(triangle.getBorderNum());
        System.out.println(rect.getName());
        System.out.println(rect.getBorderNum());
        System.out.println(eTriangle.getName());
        System.out.println("eTriangle.getBorderNum(): " + eTriangle.getBorderNum());
        eTriangle.printShapeMsg();
        triangle.introduce();
        triangle.setBorderNum(3);
        System.out.println(triangle.getBorderNum());
        triangle.introduce();
        final int a = 2;
        testFinalFunc(a);
    }
}
