package collection.t;

import java.util.ArrayList;
import java.util.Vector;
import java.util.LinkedList;
import java.util.Iterator;
import collection.t.CollectionTest;
public class VariousList {
    public static void vectorTest() {
        // 线程安全,效率相对较低,底层是数组
        System.out.println("-----------vector-start----------");
        Vector list = new Vector();
        list.add("java");
        list.add("js");
        // 指定位置插入元素
        list.add(1, "php");
        // 创建一个包含另一个集合元素的向量
        Vector list2 = new Vector(list);
        System.out.println(list); // [java, php, js]
        System.out.println(list2); // [java, php, js]
        list2.clear();
        System.out.println(list2); // []
        list2.addAll(list);
        System.out.println(list2); // [java, php, js]
        list2.addAll(1, list);
        System.out.println(list2); // [java, java, php, js, php, js]
        // 添加
        list2.addElement("python");
        System.out.println(list2); // [java, java, php, js, php, js, python]
        System.out.println(list2.capacity()); // 12
        System.out.println(list2.size()); // 7
        // 克隆
        Vector list3 = (Vector)list2.clone();
        System.out.println(list3); // [java, java, php, js, php, js, python]
        list2.remove("java");
        System.out.println(list3); // [java, java, php, js, php, js, python]
        System.out.println(list2); // [java, php, js, php, js, python]
        // 查看是否包括制定集合中的所有元素,只关心元素是否存在，不关心数量
        System.out.println(list2.containsAll(list3)); // true
        // 获取指定索引位置的元素
        System.out.println(list3.elementAt(list3.size() - 1)); // python
        System.out.println(list3.elements()); // 返回向量的枚举
        System.out.println(list2.equals(list3)); // false
        Vector list4 = new Vector(list2);
        System.out.println(list4.equals(list2)); // true
        // 获取指定索引位置的元素
        System.out.println(list3.get(list3.size() - 1)); // python
        // 获取第一个元素
        System.out.println(list3.firstElement()); // java
        System.out.println(list3); // [java, java, php, js, php, js, python]
        // 从指定位置开始查找指定元素,返回索引,没有返回-1
        System.out.println(list3.indexOf("java", 1)); // 1
        list4.clear();
        System.out.println(list4.isEmpty()); // true
        System.out.println(list3.lastElement()); // python
        // 从后往前寻找，其他和indexOf一样
        System.out.println(list3.lastIndexOf("js", list3.size() - 3)); // 3
        list3.remove("java"); // 去除了第一个java就结束了
        System.out.println(list3); // [java, php, js, php, js, python]
        System.out.println(list2); // [java, php, js, php, js, python]
        // 删除全部
        list2.removeAllElements();
        System.out.println(list2.size()); // 0
        Vector list5 = new Vector();
        list5.add("java");
        list5.add("php");
        list5.add("php");
        list3.retainAll(list5);
        System.out.println(list3); // [java, php, php]
        list3.set(2, "c++");
        System.out.println(list3); // [java, php, c++]
        System.out.println("capacity:" + list3.capacity() + " --- size:　" + list3.size()); // capacity:7 --- size:　3
        list3.trimToSize();
        System.out.println("capacity:" + list3.capacity() + " --- size:　" + list3.size()); // capacity:3 --- size:　3
        System.out.println("-----------vector-end----------");
    }
    public static void arrayListTest() {
        // 线程不安全,效率比vector高,底层是数组
        System.out.println("-----------arrayList-start----------");
        ArrayList list = new ArrayList();
        list.add(1);
        list.add(2);
        // 遍历
        for (int i = 0; i < list.size(); i += 1) {
            System.out.println(list.get(i));
        }
        Object[] arr = list.toArray();
        System.out.println(arr[0]); // 1
        System.out.println(arr[0] instanceof Integer); // true
        System.out.println("-----------arrayList-end----------");
    }
    public static void linkedListTest() {
        // 底层数据结构是链表,查询慢,增删快,线程不安全,效率高
        System.out.println("-----------linkedList-start----------");
        LinkedList list = new LinkedList();
        list.add("java");
        list.add("js");
        System.out.println(list); // [java, js]
        list.add(2, "php"); // [java, js, php]
        System.out.println(list);
        // add的位置可以等于长度,但如果大于长度则会报错
        list.add(3, "python");
        System.out.println(list); // [java, js, php, python]
        LinkedList list2 = (LinkedList)list.clone();
        System.out.println(list2); // [java, js, php, python]
        System.out.println(list.get(2)); // php
        list.set(1, "ECMAScript");
        System.out.println(list); // [java, ECMAScript, php, python]
        list2.clear();
        System.out.println(list2); // []
        System.out.println(list2.isEmpty()); // true
        list.remove("php");
        System.out.println(list); // [java, ECMAScript, python]
        Iterator lt = list.iterator();
        while (lt.hasNext()) {
            String str = (String)lt.next();
            System.out.println(str);
        }
        // 添加元素到最前面
        list.addFirst("ts");
        // 添加元素到最后面
        list.addLast("bug");
        System.out.println(list); // [ts, java, ECMAScript, python, bug]
        System.out.println(list.getFirst()); // ts
        System.out.println(list.getLast()); // bug
        // 删除第一个元素
        list.removeFirst();
        // 删除最后一个元素
        list.removeLast();
        System.out.println(list); // [java, ECMAScript, python]
        System.out.println("-----------linkedList-end----------");
    }
    public static void main(String[] args) {
//        vectorTest();
//        arrayListTest();
//        linkedListTest();
        excludeRepeat();
    }
    public static void excludeRepeat() {
        ArrayList list = new ArrayList();
        list = (ArrayList)CollectionTest.createNumCollection(4);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(null);
        list.add(null);
        System.out.println(list);
        for (int i = 0; i < list.size(); i += 1) {
            Integer elem = (Integer)list.get(i);
            if (list.indexOf(elem) != i) {
                list.remove(i);
                i -= 1;
            }
        }
        System.out.println(list);
    }
}
