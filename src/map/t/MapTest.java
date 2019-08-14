package map.t;

import java.util.*;

class Student {
    private String id;
    private String name;
    private int age;
    public Student() {}
    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public Student(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return "name:" + this.name + ",id:" + this.id + ",age:" + this.age;
    }
    @Override
    public int hashCode() {
        return this.age * 1024;
    }
    @Override
    public boolean equals(Object obj) {
        // return false;
        if (obj.getClass() == this.getClass()) {
            Student other = (Student)obj;
            return this.id == other.id && this.name == other.name && this.age == other.age;
        } else {
            return false;
        }
    }
}
public class MapTest {
    public static void hashMapTest() {
        // 键值可以为任意类型，包括null，但键值唯一，多次添加，后面的覆盖前面的
        System.out.println("----------hashMapTest-start-------------");
        Map map = new HashMap();
        Student s1 = new Student();
        map.put(s1, "小明");
        map.put(1, "hi");
        System.out.println(map); // {1=hi, map.t.Student@1b6d3586=小明}
        System.out.println(s1); // map.t.Student@1b6d3586
        System.out.println(map.size()); // 2
        System.out.println(map.containsKey(s1)); // true
        System.out.println(map.containsValue("hi")); // true
        map.remove(1);
        System.out.println(map); // {map.t.Student@1b6d3586=小明}
        map.clear();
        System.out.println(map); // {}
        System.out.println(map.isEmpty()); // true
        map.put("s1", new Student("1", "小光"));
        map.put("s2", new Student("2", "小明"));
        map.put(new Student("3", "小亮"), "s3");
        System.out.println(map); // {name:小亮,id:3=s3, s1=name:小光,id:1, s2=name:小明,id:2}
        System.out.println(map.get("s1")); // name:小光,id:1
        System.out.println(map.values()); // [s3, name:小光,id:1, name:小明,id:2]  collection类型
        System.out.println(map.keySet()); // [name:小亮,id:3, s1, s2]  collection类型
        // entrySet()这种遍历比keySet()的遍历效率要高
        Set<Map.Entry<String, String>> set = map.entrySet();
        Iterator<Map.Entry<String, String>> it = set.iterator();
        while(it.hasNext()) {
            Map.Entry elem = it.next();
            System.out.println("key:" + elem.getKey() + ",value:" + elem.getValue());
        }
        Set set2 = map.keySet();
        Iterator it2 = set2.iterator();
        while(it2.hasNext()) {
            Object elem = it2.next();
            System.out.println("key:" + elem + ",value:" + map.get(elem));
        }
        System.out.println("----------hashMapTest-end-------------");
    }

    public static void hashTableTest() {
        // hashtable和hashMap类方法和使用方式差不多，但是hashtable线程是安全的，hashMap是不安全的，
        // 并且能够被分享到多个线程，而hashMap不行；还有hashtable不允许存在为null的key和value
        System.out.println("----------hashTableTest-start-------------");
        Hashtable ht = new Hashtable();
        ht.put("1", "hah");
        ht.put("2", "hi");
        ht.put("3", "hello");
        System.out.println(ht); // {3=hello, 2=hi, 1=hah}
        System.out.println(ht.get("1"));
        try {
            // 两者都会报空指针异常
            ht.put("1", null);
            ht.put(null, "1");
        }catch(Exception e) {
            System.out.println(e);
        }
        System.out.println("----------hashTableTest-end-------------");
    }

    public static void linkedHashMapTest() {
        // 可以保证map里的键值是有序的，既可以是插入顺序，也能使访问顺序
        System.out.println("----------linkedHashMapTest-start-------------");
        Map map = new LinkedHashMap();
        map.put("1", "one");
        map.put("2", "two");
        map.put("3", "three");
        iteratorMap(map);
        System.out.println(map.get("6")); // null
        System.out.println("----------linkedHashMapTest-end-------------");
    }

    public static void treeMapTest() {
        // 具有排序功能，默认自然排序
        System.out.println("----------treeMapTest-start-------------");
        // 和TreeSet类似，可以按自己需要排序
        Map map = new TreeMap(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        map.put("1", "one");
        map.put("0", "two");
        map.put("3", "three");
        iteratorMap(map);
        System.out.println("----------treeMapTest-end-------------");
    }

    public static void userDefinedElemTest() {
        // 测试判断键相等的依据
        System.out.println("----------userDefinedElemTest-start-------------");
        Map map = new HashMap();
        Student s1 = new Student("1", "hik", 2);
        Student s2 = new Student("1", "hik", 2);
        // 添加时，会向hashSet一样先检查hashCode()的返回值是否相等
        // 如果相等再检查equals()的值是否相等，都相等则认为是相同元素，覆盖前面的
        map.put(s1, "1");
        map.put(s2, "2");
        System.out.println(map);
        System.out.println("----------userDefinedElemTest-end-------------");
    }

    public static void iterateMapUniteListTest() {
        System.out.println("----------iterateMapUniteListTest-start-------------");
        ArrayList<String> list = new ArrayList<>();
        list.add("马超");
        list.add("赵云");
        list.add("关羽");
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("令狐冲");
        list2.add("林平之");
        ArrayList<String> list3 = new ArrayList<>();
        list3.add("郭靖");
        list3.add("杨过");
        Map<String, ArrayList<String>> map1 = new HashMap<>();
        map1.put("三国", list);
        map1.put("笑傲", list2);
        map1.put("神雕", list3);
        Set<String> set1 = map1.keySet();
        for (String key : set1) {
            List<String> value = map1.get(key);
            System.out.print(key + ":");
            for (String elem : value) {
                System.out.print(elem);
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("------------------------------");
        ArrayList<Map<String, String>> cpList = new ArrayList<>();
        Map<String, String> cpMap1 = new HashMap<>();
        cpMap1.put("周瑜", "小乔");
        cpMap1.put("吕布", "貂蝉");
        Map<String, String> cpMap2 = new HashMap<>();
        cpMap2.put("郭靖", "黄蓉");
        cpMap2.put("杨过", "小龙女");
        Map<String, String> cpMap3 = new HashMap<>();
        cpMap3.put("令狐冲", "任盈盈");
        cpMap3.put("林平之", "岳灵珊");
        cpList.add(cpMap1);
        cpList.add(cpMap2);
        cpList.add(cpMap3);
        Iterator<Map<String, String>> it = cpList.iterator();
//        for (Map elem : cpList) {
//            Set<String> cpSet = elem.keySet();
//            for (String key : cpSet) {
//                System.out.print(key + "&" + elem.get(key));
//                System.out.println();
//            }
//        }
        while(it.hasNext()) {
            Map elem = it.next();
            Set<String> cpSet = elem.keySet();
            for (String key : cpSet) {
                System.out.print(key + "&" + elem.get(key));
                System.out.println();
            }
        }

        System.out.println("----------iterateMapUniteListTest-end-------------");
    }

    public static void main(String[] args) {
//        hashMapTest();
//        hashTableTest();
//        linkedHashMapTest();
//        treeMapTest();
//        userDefinedElemTest();
        iterateMapUniteListTest();

//        getStrCharNum("lwlwlixcvongngrjoirj");
    }
    public static void getStrCharNum(String str) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chs = str.toCharArray();
        for (char ch : chs) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }
        System.out.println(map);
    }
    public static void iteratorMap(Map map) {
        Collection c = map.entrySet();
        Iterator it = c.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
