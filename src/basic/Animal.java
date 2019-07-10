package basic;
import com.time.*;

public class Animal {
    public static void main(String[] args) {
        Animal dog = new Animal("dog", 10);
        System.out.println(dog.swimmingAble);
        dog.doSomething();
        System.out.println(dog.test);
        System.out.println(dog.staticVar);
        System.out.println(new Time().time4);
        System.out.println(Date.Date5);
        System.out.println(new Date().getDate1());
    }
    enum Size { small, middle, large };
    int age; // 不赋值为0
    String name; // 不赋值为null
    Size size; // 不赋值为null
    private Boolean swimmingAble; // 不赋值为null
    boolean test; // 不赋值为false
    // 基础类型有其默认值，其他为null
    static int staticVar = 45;
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
        this.size = Size.small;
    }
    void doSomething() {
        int a = 3; // 局部变量没有默认值，所以局部变量被声明后，必须经过初始化，才可以使用。
        Boolean aaa = true;
        System.out.println(aaa); // true
        System.out.println(a); // 3
        System.out.println(this); // basic.Animal@1b6d3586
        System.out.println("基本类型：byte 二进制位数：" + Byte.SIZE);
        int i =130;
        byte b = (byte)i;
        System.out.println(b);
        int num = 99;
        System.out.println(num + "x");
        System.out.println(staticVar);
        System.out.println(Hello.hi);
        System.out.println(new Hello().hi);
        System.out.println(Hello.staticVar);
        System.out.println(new Hello().hello);
    }
}
