package com.time;

public class Test {
    private int varible;
    public Test(int varible) {
        this.varible = varible;
    }
    public void output() {
        System.out.println(varible);
    }
    public static void main(String[] args) {
        char ch = 'c';
        byte a = -126;
        byte b1=3,b2=4,b;
        b=(byte)(b1+b2);
        b=3+4;
        System.out.println(b + a);
        System.out.println((byte)256 == (byte)0); // true
        System.out.println((byte)900);
        System.out.println('a');
        System.out.println('a'+1);
        System.out.println("hello"+'a'+1); // helloa1
        System.out.println('a'+1+"hello"); // 98hello
        System.out.println("a"+1+"hello"); // a1hello
        System.out.println("5+5="+5+5); // 5+5=55
        System.out.println(5+5+"=+5+5"); // 10=+5+5
        System.out.println(5/2); // 整数相除,只能得到整数 2
        System.out.println(5/2.0); // 2.5
        System.out.println(5*1.0/2); // 2.5
        if (1 == 1 & 1 != 2) {
            // true
            System.out.println("this is true");
        }
        System.out.println(0x31 & 0x0f); // 1
        // 当左右都为boolean类型数据时，左右两边不同则返回true
        System.out.println(true ^ true); // false
        System.out.println(false ^ true); // true
        System.out.println(false ^ false); // false
        System.out.println(12 ^ 'a');
        int eNum = 011;
        System.out.println(eNum);

    }
}
