package collection.t;

import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

class Person {
    private String name;
    private int age;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public Person(){ }
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return "name:" + name + ", age:" + age;
    }
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Person)) {
            return false;
        }
        // obj可能是person的子类实例,故先强转
        Person p = (Person)obj;
        return this.name.equals(p.name) && this.age == p.age;
    }
}

public class CollectionTest {
    public static Collection createNumCollection(int length) {
        Collection list = new ArrayList();
        for (int i = 0; i < length; i += 1) {
            list.add(i);
        }
        return list;
    }

    public static void collectionArrayListTest() {
        // 无序的一个聚集
        // add 直接将元素添加，添加另一个list的时候变成[[],123]这样的格式
        // addAll添加list的时候变成[xx,xx,xx,123]的格式，会自动拆分
        // remove和removeAll同理，同时，removeAll某个list的时候，如果存在该list中的元素，则全部删除
        // 不存在则忽略
        System.out.println("-------collectionArrayListTest-start----------");
        Collection list = new ArrayList();
        Collection list2 = new ArrayList();
        Collection list3 = new ArrayList();
        list.add("java");
        list.add("javascript");
        System.out.println(list); // [java, javascript]
        // 当做一个元素添加
        list2.add(list);
        list2.add("python");
        System.out.println(list2); // [[java, javascript], python]
        list2.remove(list);
        System.out.println(list2); // [python]
        // 返回是否操作成功的结果
        boolean flag = list2.remove("not exist");
        System.out.println(flag); // false
        list2.add("22");
        System.out.println(list2); // [python, 22]
        list2.removeAll(list);
        System.out.println(list2); // [python, 22]
        list3.addAll(list);
        System.out.println(list3); // [java, javascript]
        list3.add("extra");
        // 删除java元素
        list3.remove("java");
        System.out.println(list3); // [javascript, extra]
        // 可以重复
        list3.add("javascript");
        System.out.println(list3); // [javascript, extra, javascript]
        // 删除存在的所有重复的元素，忽略不存在的元素
        list3.removeAll(list);
        System.out.println(list3); // [extra]
        // 判断是否为空列表
        System.out.println(list3.isEmpty()); // false
        // 清除全部元素
        list3.clear();
        System.out.println(list3.isEmpty()); // true
        System.out.println(list3); // []
        Collection list4 = new ArrayList();
        list4.add("java");
        list4.add("php");
        list4.add("nodejs");
        System.out.println(list4); // [java, php, nodejs]
        System.out.println(list4.contains("nodejs")); // true
        System.out.println(list4.contains("c++")); // false
        Collection list5 = new ArrayList();
        list5.addAll(list4);
        System.out.println(list5); // [java, php, nodejs]
        System.out.println(list4.containsAll(list5)); // true
        list5.add("2");
        System.out.println(list4.containsAll(list5)); // false
        list5.remove("2");
        list5.remove("java");
        System.out.println(list5); // [php, nodejs]
        System.out.println(list4.containsAll(list5)); // true
        list5.add("php");
        // 只关心元素存不存在，不关心是否重复
        System.out.println(list4.containsAll(list5)); // true
        System.out.println(list5); // [php, nodejs, php]
        System.out.println(list5.size()); // 3
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println(list instanceof Collection); // true
        // 通过Iterator遍历
        Iterator it = list5.iterator();
        System.out.println("------iterator1--------");
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        Collection list6 = new ArrayList();
        list6 = createNumCollection(3);
        list6.addAll(list6);
        System.out.println(list6); // [0, 1, 2, 0, 1, 2]
        list6.removeAll(list6);
        System.out.println(list6); // []
        list6 = createNumCollection(3);
        // 求两个集合之间的交集
        list6.retainAll(createNumCollection(2));
        System.out.println(list6); // [0, 1]

        Collection list7 = new ArrayList();
        list7.add(1);
        list7.add("123");
        System.out.println(list7); // [1, 123]
        Object[] arr = list7.toArray(); // 返回的数组元素是Object类型，无法相加 arr[1] + arr[0] 会报错
        System.out.println("-------collectionArrayListTest-end----------");
    }

    public static void testCollectionArrayListOverride() {
        System.out.println("-------testCollectionArrayListOverride-start----------");
        Person p = new Person("jack", 8);
        Person p2 = new Person("Frank", 8);
        Person p3 = new Person("tomaku", 33);
        Collection list = new ArrayList();
        Collection list2 = new ArrayList();
        System.out.println(p);
        System.out.println(p.equals(p2));
        list.add(p);
        list.add(p2);
        list2.addAll(list);
        System.out.println(list); // [name:jack, age:8, name:Frank, age:8]
        System.out.println(list.size()); // 2
        System.out.println(list.contains(p)); // true
        System.out.println(list.remove(p)); // true
        System.out.println(list); // [name:Frank, age:8]
        System.out.println("---------iterator---------");
        list2.add(p3);
        System.out.println(list2);
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            Person s = (Person) it.next();
            System.out.println(s.getName() + "---" + s.getAge());
        }
        System.out.println("-------testCollectionArrayListOverride-end----------");
    }

    public static void listArrayListTest() {
        // 有序列表,可通过索引查找
        System.out.println("-------listArrayListTest-start----------");
        List list = new ArrayList();
        List list2 = new ArrayList();
        List list3 = new ArrayList();
        // 添加
        list.add("java");
        list.add("js");
        System.out.println(list); // [java, js]
        // 根据索引获得元素
        System.out.println(list.get(0)); // java
        list2.add(list);
        System.out.println(list2); // [[java, js]]
        // 插入查分后的元素,与Collection相同
        list3.addAll(list);
        System.out.println(list3); // [java, js]
        // 在指定位置插入元素集,返回结果
        System.out.println(list3.addAll(1, list)); // true
        System.out.println(list3); // [java, java, js, js]
        // 删除元素,返回被删除的元素
        System.out.println(list3.remove(3)); // js
        System.out.println(list3); // [java, java, js]
        // 设置元素,并返回被替换的元素
        System.out.println(list3.set(1, "php")); // java
        System.out.println(list3); // [java, php, js]
        System.out.println(list3.indexOf("php")); // 1
        System.out.println(list3.indexOf("python")); // -1
        ListIterator lIt = list3.listIterator();
        System.out.println("---------ListIterator---------");
        while (lIt.hasNext()) {
            System.out.println(lIt.next());
        }
        // 指针会定在结束为止
        System.out.println(lIt.hasNext()); // false
        while (lIt.hasPrevious()) {
            System.out.println(lIt.previous());
        }
        System.out.println(lIt.hasNext()); // true
        System.out.println("-------listArrayListTest-end----------");
    }

    public static void main(String[] args) {
        collectionArrayListTest();
//        testCollectionArrayListOverride();
//        listArrayListTest();
//        test();
    }

    public static void test() {
        List list = new ArrayList();
        list.add("hello");
        list.add("world");
        list.add("java");
        ListIterator lt = list.listIterator();
        while (lt.hasNext()) {
            String ele = (String) lt.next();
            if (ele.equals("world")) {
                // 因为迭代器是针对集合的，所以此时对list进行添加就是一边操作一边遍历，
                // 迭代器没有发生变化，而集合发生了变化，所以会报错。此时可以用ListIterator迭代器来添加
                // 效果为在当前位置添加，注意：Iterator迭代器没有add方法，故无法使用
                // 下面会溢出
                /*
                list.add("android");
                lt = list.iterator();
                */
                // 当前位置添加
                lt.add("android");
            }
        }
        System.out.println(list); // [hello, world, android, java]
        // 或者使用for循环
        for (int i = 0, len = list.size(); i < len; i += 1) {
            String ele = (String) list.get(i);
            if (ele.equals("world")) {
                // 最后面添加
                list.add("hi");
            }
        }
        System.out.println(list); // [hello, world, android, java, hi]
    }
}
