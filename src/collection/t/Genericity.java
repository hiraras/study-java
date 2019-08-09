package collection.t;

import javax.swing.text.html.HTMLDocument;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
// 导入某个类下的所有静态方法及静态属性
import static collection.t.CollectionTest.*;

interface Test<D> {
    D getData();
}
interface Test2<T> {
    T getName();
}
class Data <D, T> implements Test<D>, Test2<String> {
    private D data;
    private T date;
    private String name;
    public Data(){}
    // 泛型变量也有作用域一说
    public static <D> void testStaticMethod(D param) {
        System.out.println(param);
    }
    // 会报错，因为泛型类的泛型变量生成在对象创建时，而static方法创建在实例化对象前
//    public static D testFunction() {}
    public Data(D data, T date, String name) {
        this.data = data;
        this.date = date;
        this.name = name;
    }
    public void setData(D data) {
        this.data = data;
    }
    public D getData() {
        return data;
    }
    public void setDate(T date) {
        this.date = date;
    }
    public T getDate() {
        return date;
    }
    public String getName() {
        return name;
    }
    public void print() {
        System.out.println("data: " + getData());
    }
}
class Build {

}
class ChildrenData extends Data<Integer, String> {
    public ChildrenData() {

    }
    public ChildrenData(Integer data, String date) {
        super(data, date, "children");
    }
}
public class Genericity {
    public static <E> E printArray(E[] arr) {
        for (E elem : arr) {
            System.out.print(elem + " ");
        }
        System.out.println();
        return arr[0];
    }
    public static void printList(List<? extends Number> list) {
        for (int i = 0; i < list.size(); i ++) {
            System.out.println(list.get(i).getClass());
        }
    }
    public static <T> void printClass(Class<T> c) {
        System.out.println(c);
    }
    public static void basicUse() {
        // 基本泛型的应用
        Integer[] intArr = {1, 2, 3, 4, 5, 6};
        String[] stringArr = {"hello", "world", "hi"};
        Character[] charArr = {'a', 'b', 'c', 'd'};
        printArray(intArr); // 1 2 3 4 5 6
        printArray(stringArr); // hello world hi
        printArray(charArr); // a b c d
    }
    public static void dataTest() {
        // Data类相关测试
        Data d = new Data(1, 12315, "data1");
        System.out.println(d.getData().equals(1)); // true
//        Data<String> d2 = new Data<String>(1); // 报错
        Data<String, Integer> d2 = new Data<>("hi", 1, "data2");
        System.out.println(d2.getData().equals("hi")); // true
        // 使用泛型后不需要强制转化
        System.out.println(d2.getData() == "hi"); // true
        System.out.println(d2.getName());
        d2.<Integer>setDate(123);
        // 泛型并不是用来转化数据类型的
        System.out.println(d2.<String>getDate() instanceof Integer); // true
        printClass(Build.class);
        printClass(Data.class);
        System.out.println(Build.class.equals(new Build().getClass())); // true
        Data.testStaticMethod("hahahaha");
        ChildrenData cd = new ChildrenData(2, "");
        cd.setData(2);
    }
    public static void listTest() {
        // list结合泛型的应用;可以知道泛型能让list不需要强转内部元素数据类型,原来内部元素默认都是Object类型的
        List<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(22);
        printList(list);
        List list2 = Arrays.asList(1,2,3,4);
        System.out.println(list2); // [1, 2, 3, 4]
        List list3 = new ArrayList();
        list3.add(2);
        list3.add("dff");
        list3.add(null);
        list3.add("22");
        Iterator it = list3.iterator();
        while(it.hasNext()) {
            // 2  dff  null  22
            System.out.print(it.next() + "  ");
            System.out.println();
//            System.out.println(it.next().getClass()); // 空指针异常
        }
        List<Integer> list4 = new ArrayList<>();
        list4.add(2);
        list4.add(2);
        list4.add(2);
        // 增强类型的for
        // 默认必须使用Object类型，指定了泛型后可以直接使用Integer
        for (Integer e : list4) {
            if (e != null) {
                System.out.println(e);
                System.out.println(e.getClass());
            }
        }
    }
    public static void staticImportTest() {
        // 静态导入
        testStaticImport("haha"); // haha
        System.out.println(myBirthday); // 19960221
    }
    // 可变参数(类似扩展运算符),能接受参数，不能在传递参数的时候使用 test(...arr) 会报错
    public static void expandArgsTest(int num, Integer ...list) {
        System.out.println(num); // 1
        System.out.println(list[0]); // 2
        System.out.println(list.length); // 4
        Integer[] arr = {1,2,3};
        System.out.println(arr.getClass()); // class [Ljava.lang.Integer;
        System.out.println(list.getClass()); // class [Ljava.lang.Integer;
        System.out.println(new Integer(1).getClass()); // class java.lang.Integer
    }
    public static void main(String[] args) {
        basicUse();
        dataTest();
        listTest();
        staticImportTest();
        expandArgsTest(1,2,3,4,5);
        test();
    }
    public static void test() {
        // asList返回一个固定长度的列表，无法再向其中添加元素
        List<String> list = Arrays.asList("hello", "world", "java");
        // 报错
//        list.add("hah");
        System.out.println(list.size());
    }
}
