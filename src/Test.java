/**
 *
 * author: fjma
 */
import java.util.Scanner;
// 抽象类中的main也可以执行
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import utils.Utils;
class Student {

}
public abstract class Test {
    public static void test() {
        String str1 = "12";
        String str2 = "23";
        System.out.println(str1.concat(str2));
    }
    public static void testArgsType(Object obj) {
        System.out.println(obj.getClass());
    }
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE); // 2147483647
        System.out.println(Integer.MIN_VALUE); // -2147483648
        System.out.println(Byte.MAX_VALUE); // 127
        System.out.println(Byte.MIN_VALUE); // -128
        System.out.println(new Student().hashCode()); // 460141958
        System.out.println(new Student().hashCode()); // 1163157884
        test();
        System.out.println(Utils.fibonacci(8));
        System.out.println(Utils.factorial(5));
        Utils.printReverseNum(1561881);
        System.out.println();
        System.out.println(Utils.reverseNum(123456));
        Pattern p = Pattern.compile("[\\u4E00-\\u9FA5]+");
        Matcher matcher = p.matcher("fe家的角度讲");
        System.out.println(matcher.find());
        testArgsType(new Student());
    }
}
