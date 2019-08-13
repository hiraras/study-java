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
        System.out.println(Integer.MAX_VALUE); // 2147483647
        System.out.println(Integer.MIN_VALUE); // -2147483648
        System.out.println(Byte.MAX_VALUE); // 127
        System.out.println(Byte.MIN_VALUE); // -128
        System.out.println(new Student().hashCode()); // 460141958
        System.out.println(new Student().hashCode()); // 1163157884
    }
}
