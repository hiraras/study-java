package collection.t;
import java.util.*;
import utils.Utils;

class Dog <T, D>{
    private T name;
    private D age;
    public Dog(){}
    public Dog(T name, D age){
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return "name:" + this.name + ",age:" + this.age;
    }
    @Override
    public int hashCode() {
        return (Integer)this.age * 64 + 1024;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Dog) {
            Dog other = (Dog)obj;
            return other.name == this.name && other.age == this.age;
        } else {
            return false;
        }
    }
}
class Cat implements Comparable<Cat>{
    private String name;
    private int age;
    public Cat(){}
    public Cat(String name, int age){
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return this.name;
    }
    // 重写后添加新元素的时候也会用该函数比较，返回为0(两者)相等则不添加
    @Override
    public int compareTo(Cat obj) {
        return obj.age - this.age;
    }
    @Override
    public String toString() {
        return "name:" + this.name + ",age:" + this.age;
    }
}
class MyCompare implements Comparator<Cat> {
    // 优先比较名字长度，相等时使用内部compareTo比较
    @Override
    public int compare(Cat o1, Cat o2) {
        int flag = o1.getName().length() - o2.getName().length();
        return flag == 0 ? o1.compareTo(o2) : flag;
    }
}
public class SetTest {
    public static void hashSetTest() {
        System.out.println("----------hashSetTest-start------------");
        // 无序，底层数据结构是哈希表(元素是链表的数组)，依赖于哈希值存储
        List<String> list = Arrays.asList("hi", "java", "pass", "js", "pass");
        Set<String> set = new HashSet<>(list);
        System.out.println(set); // [hi, java, pass, js]
        Iterator<String> it = set.iterator();
        while(it.hasNext()) {
            String elem = it.next();
            System.out.println(elem);
        }
        Set<Dog> set2 = new HashSet<>();
        Dog dog1 = new Dog("haki", 2);
        Dog dog2 = new Dog("siri", 3);
        Dog dog3 = new Dog("haki", 2);
        set2.add(dog1);
        set2.add(dog2);
        set2.add(dog3);
        // hashSet判断元素是否有重复，先比较元素的hashCode()返回值，再比较equals，如果两者都相等，则认为该元素已存在
        // 故自定义元素想要利用set元素无法重复的特性，需要重写hashCode()和equals()方法
        System.out.println(dog1.hashCode());
        System.out.println(dog2.hashCode());
        System.out.println(dog3.hashCode());
        System.out.println(set2); // [name:haki,age:2, name:siri,age:3]

        System.out.println(set); // [hi, java, pass, js]
        set.add("php");
        System.out.println(set); // [hi, java, pass, js, php]
        set.add("js");
        System.out.println(set); // [hi, java, pass, js, php]
        set.remove("pass");
        System.out.println(set); // [hi, java, js, php]
        set.clear();
        System.out.println(set.size()); // 0
        System.out.println(set); // []
        System.out.println("----------hashSetTest-end------------");
    }

    public static void treeSetTest() {
        // 底层数据结构是二叉树、可以排序
        System.out.println("----------treeSetTest-start------------");
        TreeSet<Cat> ts = new TreeSet<>();
        ts.add(new Cat("张三", 23));
        ts.add(new Cat("李四", 13));
        ts.add(new Cat("周七", 13));
        System.out.println(ts); // [name:张三,age:23, name:李四,age:13]
        // 还可以使用比较器进行比较,且既存在比较器又存在compareTo重写的时候，优先使用比较器
        // 将比较器传入构造方法
        TreeSet ts2 = new TreeSet(new MyCompare());
        ts2.add(new Cat("tom", 2));
        ts2.add(new Cat("lucy", 3));
        ts2.add(new Cat("hah", 3));
        ts2.add(new Cat("pac", 2)); // 因为名字长度和tom相等，年龄也相等，所以不会添加
        System.out.println(ts2); // [name:hah,age:3, name:tom,age:2, name:lucy,age:3]
        // 可以用匿名内部类
        TreeSet ts3 = new TreeSet(new Comparator<Cat>() {
            @Override
            public int compare(Cat o1, Cat o2) {
                int flag = o1.getName().length() - o2.getName().length();
                return flag == 0 ? o1.compareTo(o2) : flag;
            }
        });
        System.out.println("----------treeSetTest-end------------");
    }

    public static void linkedHashSetTest() {
        System.out.println("----------linkedHashSetTest-start------------");
        Set<Integer> set = new LinkedHashSet<>();
        set.add(2);
        set.add(4);
        set.add(1);
        set.add(2);
        System.out.println(set); // [2, 4, 1]
        System.out.println("----------linkedHashSetTest-end------------");
    }

    public static void main(String[] args) {
        // set集合的元素内容不重复
//        hashSetTest();
//        treeSetTest();
//        linkedHashSetTest();
        // 去除重复元素
//        removeRepeatElem1();
//        removeRepeatElem2();
//        getNoRepeatList();
    }
    public static void removeRepeatElem1() {
        List<String> list = new ArrayList<>();
        list.add("hi");
        list.add("ab");
        list.add("cl");
        list.add("cl");
        Set set = new HashSet();
        set.addAll(list);
        System.out.println(set); // [hi, ab, cl]
        list.clear();
        list.addAll(set);
        System.out.println(list); // [hi, ab, cl]
    }
    public static void removeRepeatElem2() {
        // 由Arrays.asList转化而来的list，无法使用remove、add等方法。
        // 因为Arrays.asList()返回的是Arrays的内部类ArrayList， 而不是java.util.ArrayList，没有重写这些方法，会导致报错
        String[] strArr = {"hi", "ab", "cl", "cl"};
        List<String> list = Arrays.asList(strArr);
        Set set = new HashSet();
        set.addAll(list);
        List<String> list2 = new ArrayList(set);
        System.out.println(list2); // [hi, ab, cl]
    }
    public static void getNoRepeatList() {
        Set<Integer> set = new HashSet();
        int count = 0;
        while(set.size() <= 10) {
            set.add(Utils.getRandom(0, 10));
            count ++;
        }
        System.out.println(set);
        System.out.println(count);
    }
}
