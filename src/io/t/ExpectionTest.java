package io.t;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExpectionTest {
    static void f() throws ExceptionB{
        throw new ExceptionB("exception b");
    }

    static void g() throws ExceptionC {
        try {
            f();
        } catch (ExceptionB e) {
            ExceptionC c = new ExceptionC("exception a");
            c.initCause(e);
            throw c;
        }
    }
    public static void test1() {
        System.out.println("----------------test1-start----------------");
        try {
            g();
        } catch (ExceptionC e) {
            e.printStackTrace();
        }
        System.out.println("----------------test1-end----------------");
    }
    // 可以抛出多个类型
    public static void test2() throws Exception, Error {
        System.out.println("----------------test2-start----------------");
        Exception e = new Exception("this is a new Error");
        System.out.println(e.getMessage());
        System.out.println(e.getCause());
        System.out.println(e.toString());
//            e.printStackTrace();
        System.out.println("----------------test2-end----------------");
        throw e;
    }
    public static void test3() {
        System.out.println("----------------test3-start----------------");
        int a = 10;
        int b = 0;
        int[] arr = { 1, 2, 3 };
        try {
            System.out.println(a / b);
            System.out.println(arr[3]);
            // 这种方式两种异常都能捕获
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println("程序出问题了");
        }
        System.out.println("----------------test3-end----------------");
    }
    public static void test4() {
        System.out.println("----------------test4-start----------------");
        try {
            double num = 1 / 0;
        } catch(ArithmeticException e) {
            System.out.println(e);
        } catch(ArrayIndexOutOfBoundsException e) {
            // 可以有多个catch 但是e的类型要不一样,同时你有了Exception，它的子类也不行，因为它肯定会先被上级给捕获掉，永远走不到下面
            System.out.println(e);
        } catch (Error e) {
            System.out.println(e);
        }
        System.out.println("----------------test4-end----------------");
    }
    public static int test5() {
        System.out.println("----------------test5-start----------------");
        // 不管是在try中还是catch中return一个值，还是会执行finally中的语句，如果finally中有return，
        // 则最后的值为finally中的返回值，否则执行完finally后返回之前return的值
        try {
            System.out.println(10 / 0);
//            return 1;
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return 3;
        } finally {
            System.out.println(11);
//            return 2;
        }
        System.out.println("----------------test5-end----------------");
        return -1;
    }
    public static void test6() throws MyException {
        System.out.println("----------------test6-start----------------");
//        System.out.println(10 / 0);
        throw new MyException("啊哈？");
    }
    public static void main(String[] args) {
        test1(); // 多个catch、异常链
        try {
            test2();
        } catch(Exception e) {
            System.out.println(1); // 1
            System.out.println(e.getCause()); // null
        }
        test3();
        test4();
        int num = test5();
        System.out.println(num);
        try {
            test6();
        } catch(Exception e) {
            System.out.println(e);
        } catch (Error e) {
            System.out.println(e);
        }
        test();
    }
    public static void test() {
    }
}

class ExceptionA extends Exception {
    public ExceptionA(String str) {
        super();
        System.out.println("ExceptionA");
    }
}

class ExceptionB extends ExceptionA {
    public ExceptionB(String str) {
        super(str);
        System.out.println("ExceptionB");
    }
}

class ExceptionC extends ExceptionA {
    public ExceptionC(String str) {
        super(str);
        System.out.println("ExceptionC");
    }
}

class MyException extends Exception {
    public MyException() {
        super();
    }
    public MyException(String message) {
        super(message);
    }
}

class Father {
    public void method1() {

    }
}
class Child extends Father {
    public void method1() {
    }
}
