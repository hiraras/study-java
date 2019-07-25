package integer.t;

public class IntegerTest {
    public static void test() {
        System.out.println("--------test--------");
        Integer i1 = new Integer(127);
        Integer i2 = new Integer(127);
        System.out.println(i1 == i2); // false
        System.out.println(i1 == 127); // true
        System.out.println(i1.equals(i2)); // true

        Integer i3 = new Integer(128);
        Integer i4 = new Integer(128);
        System.out.println(i3 == i4); // false
        System.out.println(i3.equals(i4)); // true

        Integer i5 = 127;
        Integer i6 = 127;
        System.out.println(i5 == i6); // true
        System.out.println(i5.equals(i6)); // true

        System.out.println(i5 == i6); // true
        Integer i7 = 128;
        Integer i8 = 128;
        System.out.println(i7 == i8); // false
        System.out.println(i7.equals(i8)); // true
        System.out.println(i7 == 128); // true
        int i9 = 128;
        int i10 = 128;
        System.out.println(i9 == i10); // true
        Integer i11 = new Integer(127);
        Integer i12 = new Integer(127);
        System.out.println(i11 == i12);
        System.out.println("--------test--------");
    }

    public static void main(String[] args) {
        // char类型会被变成ascii码表对应的数字
        System.out.println(new Integer('1') == 1); // false
        System.out.println(new Integer("1") == 1); // true
        System.out.println(new Integer(123).intValue()); // 123
        String str = "456";
        System.out.println(Integer.parseInt(str) == 456); // true
        System.out.println(Integer.toString(456).equals("456")); // true
        System.out.println(Integer.valueOf(str) == 456); // true
        System.out.println(Integer.valueOf(456) == 456); // true
        try {
            Integer.parseInt("123451aaa");
        }catch(Exception e) {
            System.out.println(e);
        }
        try {
            Integer.valueOf("123451aaa");
        }catch(Exception e) {
            System.out.println(e);
        }
        System.out.println("-------========--------");
        System.out.println("进制转化");
        int num = 20;
        System.out.println(Integer.toBinaryString(num)); // 10进制->2进制, 10100
        System.out.println(Integer.toOctalString(num)); // 10进制->8进制, 24
        System.out.println(Integer.toHexString(num)); // 10进制->16进制, 14
        // 十进制转化为第二个参数所代表的进制
        System.out.println(Integer.toString(num, 2)); // 10100
        System.out.println(Integer.toString(num, 7)); // 26
        // 其他进制到十进制
        String strNum = "30";
        System.out.println(Integer.parseInt(strNum, 8)); // 24
        test();
    }
}
