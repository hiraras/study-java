package animal;

public class Dog {
    // 和局部变量不同，会自动初始化，即可以直接使用
    private int age;
    private String name;
    private static int size;
    private final static String[] DIRECT = {"up", "down", "left", "right"};
    public void setAge(int age) {
        System.out.println("set age");
        this.age = age;
    }
    public int getAge() {
        System.out.println("size:" + size);
        return this.age;
    }
    public Dog() {

    }
    public Dog(int age, String name, int size) {
        System.out.println("构造方法执行");
        this.age = age;
        this.name = name;
    }
    {
        // 构造代码块，多个构造方法中相同的代码放在一起，每次调用构造方法都执行，并且在构造方法之前执行
        // 和构造函数的环境好像类似，可以使用this，也可以使用静态变量
        System.out.println("构造代码块执行");
        this.age = 1;
        this.name = "shiro";
        size = 8;
    }
    static {
        // 静态代码块，加载类的时候就执行，故执行一次
        System.out.println("静态代码块执行");
        size = 99;
    }
    // 同包内使用
    static void bark() {
        System.out.println("wang wang!");
        System.out.println(new Dog(1,"temp", 11).getAge());
    }

    public static void main(String[] args) {
        Dog dog1 = new Dog(1, "haki", 12);
        Dog dog2 = new Dog(12, "yaha", 13);
        Dog dog3 = new Dog();
        dog1.setAge(26);
        System.out.println(dog1.getAge());
        System.out.println(dog1.name);
        dog1.bark();
        System.out.println(Dog.size);
        System.out.println(dog1.size);
        System.out.println(dog2.size);
        System.out.println(Math.floor(Math.random()*1000));
        System.out.println(System.currentTimeMillis());
        System.out.println(dog3.age);
        System.out.println(new SmallDog().getAge()); // 该类必须被使用才会去载入该类，才会执行静态代码块的内容
        new SmallDog(); // 看看静态代码块是不是会执行两次 --> 不会
        System.out.println(checkIsTwoDouble(256));
        System.out.println((int)12.33f);
    }

    private static boolean checkIsTwoDouble(int length){
        int x = 9;
        if(x % length == (x & (length - 1))){
            return true;
        }
        return false;
    }
}

class SmallDog {
    static {
        System.out.println("这是静态代码块");
        {
            // 代码块可以嵌套
            int i = 0;
            System.out.println(i);
        }
    }
    private int age = 2;
    int getAge() {
        return age;
    }
    public static void main(String[] args) {
        System.out.println("this is Small Dog");
    }
}
class BigDog {
    private int age = 999;

    public static void main(String[] args) {
        System.out.println("this is Small Dog");
    }
}