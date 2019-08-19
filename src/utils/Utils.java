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
}