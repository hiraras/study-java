package scanner;
import java.util.Scanner;

public class Test {
    public static int testTry() {
        try {
            return 1;
        } catch (Exception e) {
            return 2;
        } finally {
            return 3;
        }
    }
    public static int testSwitch(String numStr) {
        int x = 0;
        switch(numStr) {
            case "1":
                x = 1;
                break;
            case "2":
                x = 2;
                break;
            default:
                x = -1;
                break;
        }
        return x;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = 0;
        try {
            x = sc.nextInt();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            x = 0;
        }
        if (x > 0) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
        System.out.println(Test.testTry());
        System.out.println(Integer.parseInt("123456456")); // String 类型转 int 类型
        System.out.println(Test.testSwitch("3"));
    }
}
