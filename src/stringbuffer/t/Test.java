package stringbuffer.t;

// public StringBuffer append(String str)追加数据,可以追加任意类型数据，添加的时候会调用toString()先转为字符串
// public StringBuffer insert(int index, String str)向指定索引位置前插入str,0即为在头部插入
// public StringBuffer delete(int start, int end)删除从开始到结束之间索引的内容，包括start，不包括end
// public StringBuffer deleteCharAt(int index)删除指定位置的字符
// public StringBuffer replace(int start, int end, String str)替换指定位置的字符串
// public StringBuffer reverse()反转字符串
// 截取功能，返回的是String类型，本身没有改变
// public String substring(int start)返回从指定位置开始到末尾的String类型的字符串
// public String substring(int start, int end)返回从指定位置开始到指定位置end的String类型的字符串

public class Test {
    public static void main(String[] args) {
        StringBuffer sb1 = new StringBuffer("javascript");
        StringBuffer sb2 = new StringBuffer("hi");
        String str = "12345";
        sb2.append("tim");
        System.out.println(sb2); // hitim
        sb2.insert(2, ",");
        System.out.println(sb2); // hi,tim
        sb1.delete(2, 4);
        System.out.println(sb1); // jascript
        sb1.deleteCharAt(0);
        System.out.println(sb1); // ascript
        sb1.replace(0, 1, "java"); // javascript
        System.out.println(sb1);
        sb1.replace(0, 0, "hi,");
        System.out.println(sb1); // hi,javascript
        sb1.reverse();
        System.out.println(sb1); // tpircsavaj.ih
        System.out.println(new StringBuffer(str).reverse().toString().equals("54321")); // true
        sb1.reverse();
        System.out.println(sb1); // hi,javascript
        String newStr = sb1.substring(3);
        System.out.println(newStr); // javascript
        System.out.println(sb1); // hi,javascript
        String newStr2 = sb1.substring(3, 7);
        System.out.println(newStr2); // java
        System.out.println(sb1); // hi,javascript
        System.out.println(new String(sb1).equals("hi,javascript")); // true
        // StringBuffer的equals方法比较的就是两个变量指向的地址是否完全相等
        System.out.println(sb1.equals("hi,javascript")); // false
        System.out.println(sb1.equals(new StringBuffer("hi,javascript"))); // false
        StringBuffer sb3 = new StringBuffer('1');
        System.out.println(sb3.capacity()); // 49
        StringBuffer sb4 = new StringBuffer("1");
        System.out.println(sb4); // 1
        sb4.append(true);
        System.out.println(sb4); // 1true
        sb4.append(new Student());
        System.out.println(new Student().toString());
        System.out.println(sb4);
        String str2 = new String("hello");
        String str3 = new String("world");
        change(str2, str3);
        System.out.println(str2 + "---" + str3); // hello---world
        StringBuffer sb5 = new StringBuffer("hello");
        StringBuffer sb6 = new StringBuffer("world");
        System.out.println("---=====----------");
        change(sb5, sb6);
        System.out.println(sb5 + "---" + sb6); // hello---worldworld
        StringBuffer sb7 = new StringBuffer("a");
        System.out.println("length=" + sb7.length()); // length=1
        System.out.println("capacity=" + sb7.capacity()); // capacity=17;
        System.out.println("--------------------");
        // 如果一次添加的内容加上原内容的长度大于capacity小于等于2(capacity + 1)则扩容到两倍的2(capacity + 1)
        // 如果一次添加的内容大于2(capacity + 1)则扩容到新"字符串"总长度,如下:
        String addStr = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        sb7.append(addStr);
        System.out.println(addStr.length()); // 42
        System.out.println("length=" + sb7.length()); // length=43;
        System.out.println("capacity=" + sb7.capacity()); // capacity=43;
    }

    public static void change(StringBuffer sb1, StringBuffer sb2) {
        System.out.println(sb1 + "---" + sb2); // hello---world
        sb1 = sb2;
        sb1.append(sb2); // sb2 == sb1 == worldworld
        System.out.println(sb1 + "---" + sb2);// worldworld---worldworld
    }

    public static void change(String s1, String s2) {
        System.out.println(s1 + "---" + s2);// hello---world
        s1 = s2; // s1=world
        s2 = s1 + s2; // s2=worldworld
        System.out.println(s1 + "---" + s2); // world---worldworld
    }
}

class Student {

}