package utils;

import java.util.*;
public class Utils {
    // 获取包括min和max在内范围的随机整数
    public static int getRandom(int min, int max) {
        return (int)(Math.floor(Math.random() * (max - min + 1) + min));
    }
    // list元素转化为string类型
    public static String[] list2StringArr(List list) {
        String[] arr = new String[list.size()];
        for (int i = 0; i < list.size(); i += 1){
            arr[i] = list.get(i).toString();
        }
        return arr;
    }
    // 斐波那契数列
    public static int fibonacci(int num) {
        if (num == 1 || num == 2) {
            return 1;
        }
        return fibonacci(num - 1) + fibonacci(num - 2);
    }
    // 阶乘
    public static int factorial(int num) {
        if (num == 1) {
            return 1;
        }
        return factorial(num - 1) * num;
    }
    // 倒叙输出一个整数1345 -> 5431
    public static void printReverseNum(int num) {
        System.out.print(num % 10);
        if (num / 10 == 0) {
            return;
        }
        printReverseNum(num / 10);
    }
    public static int reverseNum(int num) {
        StringBuffer sb = new StringBuffer("" + num);
        sb.reverse();
        return Integer.parseInt(sb.toString());
    }
    // 倒序
    public static byte[] reverseArray(byte[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while(start < end) {
            byte temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start ++;
            end --;
        }
        return arr;
    }
}
