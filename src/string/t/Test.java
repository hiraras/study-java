package string.t;
import java.util.Arrays;

// equals 对比两个字符串类型的值 str1.equals(str2)
// equalsIgnoreCase 对比两个字符串类型的值忽略其大小写 str1.equalsIgnoreCase(str2)
// contains 对比一个字符串是否为另一个字符串的子串，str1.contains(str2),如果str2为null则报错
// startsWith 对比一个字符串是否为另一个字符串的开始部分,str1.startsWith(str2),如果str2为null则报错
// endsWith 对比一个字符串是否为另一个字符串的结束部分,str1.endsWith(str2),如果str2为null则报错
// isEmpty 查看一个字符串是否为空串,str.isEmpty()
// length 获取字符串的长度,str.length()
// charAt 获取字符串指定索引位置的字符,返回值为char类型 str.charAt(num),num范围为0-str.length()
// indexOf 获取字符串在另一字符串中的位置,str1.indexOf(str2, fromIndex),str2可以为char类型或String类型,找不到则返回-1，可以置顶开始查询的位置
// lastIndexOf 获取字符串在另一字符串中的位置，str1.lastIndexOf(str2),与indexOf参数相同，不过查找顺序从后往前查找
// substring 获取字符串的子串，str.substring(startIndex, endIndex),不能超过字符串边界, 后面的数字要大于前面的
// getBytes 将字符串转为byte类型数组
// toCharArray 将字符串转成char类型的数组
// String.valueOf 可以将int类型和char[]类型转为String
// toUpperCase 将字符串中的小写字母转为大写字母
// toLowerCase 将字符串中的大写字母转为小写字母
// concat 拼接两个字符串
// replace 替换字符串中的子串 str.replace(oldStr, newStr), oldStr为空的话则每个单词之间插入新串,也可以用来删除某些字符
// trim 去除字符串前后的空格
// compareTo 对比两个字符串，从头开始一个字符一个字符的对比，直到一个字符不同或结束。相同时返回0，不同时返回正数或负数
// compareToIgnoreCase 同compareTo但不区分大小写
public class Test {
    static void upperFirstWord(String str) {
        System.out.println(str.substring(0, 1).toUpperCase().concat(str.substring(1)));
    }
    static String reverseStr(String str) {
        String newStr = "";
        for(int i = str.length()-1;i>-1;i--){
            newStr = newStr.concat(String.valueOf(str.charAt(i)));
        }
        return newStr;
    }
    static int countStr(String originStr, String target) {
        int num = 0;
        int index = originStr.indexOf(target);
        while(index != -1){
            num ++;
            originStr = originStr.substring(index + 1);
            index = originStr.indexOf(target);
        }
        return num;
    }
    public static void main(String[] args) {
        String str1 = "hello tom";
        System.out.println(str1.replace("ll", ""));
        String str2 = "eid idi  ";
        String str3 = "eifieiei  ";
        String str4 = "eifieiei  ";
        System.out.println(str2.trim());
        System.out.println(str2.compareTo(str3));
        System.out.println(str3.compareTo(str4));
        int[] intArr = {1,2,3};
        System.out.println(Arrays.toString(intArr));
        String str5 = "hirara";
        System.out.println(reverseStr(str5));
        int num = countStr("woaijavawozhenaijavawozhendeaijavawozhendehenaijavaxinbuxinwoaijavagun", "java");
        System.out.println(num);
        System.out.println(str1.substring(0,1) == "h");
        System.out.println(Arrays.toString("s11".getBytes()));
    }
}
