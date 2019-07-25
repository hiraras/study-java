/**
 *
 * author: fjma
 */
import java.util.Scanner;
// 抽象类中的main也可以执行
import java.util.Arrays;

class Student {

}
public abstract class Test {
    public static void test() {

    }
    public static void main(String[] args) {
        int[] arr = {3,2,1,54,2};
        System.out.println(new Integer("1") == 1); // true
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(new Integer("123").intValue() == Integer.valueOf("123"));
        System.out.println(Integer.parseInt("123"));
        System.out.println(Integer.toBinaryString(20));
        System.out.println(Integer.toHexString(20));
        System.out.println(Integer.toString(16, 2));
        System.out.println(Integer.parseInt("1000", 2));
    }
}
