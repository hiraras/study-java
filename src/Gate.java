import com.time.*;
import java.util.Date;
import java.util.Scanner;
//import basic.Cat;
import animal.Cat;

public class Gate {
    private static int a = 1;
    private static void change(Time t) {
        t.time4 = 333;
        a = 222;
    }

    private static void stars(int col, int row) {
        String str = "";
        for (int j = 0;j<row;j+=1) {
            str = "";
            for (int i=0;i<col;i+=1) {
                str += "*";
            }
            System.out.println(str);
        }
    }

    private static void stars(int col) {
        String str = "";
        for (int j = 0;j<10;j+=1) {
            str = "";
            for (int i=0;i<col;i+=1) {
                str += "*";
            }
            System.out.println(str);
        }
    }

    private static void yanghuiTriangle(int row) {
        int[][] arr = new int[row][];
        for (int i=0;i<row;i+=1) {
            arr[i] = new int[i+1];
            for (int j=0;j<=i;j+=1) {
                if (j == 0 || j == i) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = arr[i-1][j] + arr[i-1][j - 1];
                }
            }
        }
        String str = "";
        for (int k=0;k<arr.length;k+=1) {
            for (int g=0;g<arr[k].length;g+=1) {
                str += "  " + arr[k][g];
            }
            System.out.println(str);
            str = "";
        }
    }

    public static void main(String[] args) {
        String str = String.valueOf((byte)1);
        System.out.println(str);
        test();
        System.out.println(str.getClass());
        float ff = Float.parseFloat("122151.156156156156156156");
        float ff2 = 0.1561561156161F;
        float ff3 = Float.valueOf("122151.156156156156156156").floatValue();
        double dd = 561651561561561.1561561156161;
        System.out.println(ff);
        System.out.println(ff2);
        System.out.println(dd);
        System.out.println(ff3);
        Cat cat = new Cat();
        cat.say();
    }

    public static void test() {
        int[][] arr = {{1,2,34}};
        int a = 1;
        a++;
        a++;
        a++;
        a++;
        System.out.println(arr);
    }
}


