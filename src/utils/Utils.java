package utils;

public class Utils {
    // 获取包括min和max在内范围的随机整数
    public static int getRandom(int min, int max) {
        return (int)(Math.floor(Math.random() * (max - min + 1) + min));
    }
}
