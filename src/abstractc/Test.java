package abstractc;

interface cultivate {
    public static final int t = 2;
    public abstract void jump();
}
interface cultivate2 {
    public abstract void jump();
}
interface t extends cultivate, cultivate2 {

}
abstract class Animal {
    private String name;
    private int age;
    abstract void eat();
    void sleep() {
        System.out.println("sleep...");
    }
    void jump() {

    }
    public Animal() {

    }
    public Animal(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    {
        this.name = "shiro";
    }
}

class Dog extends Animal implements cultivate {
    public Dog(){}
    public Dog(String name) {
        super(name);
    }
    @Override
    public void jump() {
        System.out.println("Dog jump...");
    }
    @Override
    public void eat() {
        System.out.println("Dog eat...");
    }
}

class Cat extends Animal implements cultivate {
    @Override
    public void eat() {
        System.out.println("Cat eat...");
    }
    public void jump() {
        System.out.println("Cat jump...");
    }
}

abstract class Insect extends Animal {
    // 抽象类的子类要么重写父类所有的抽象方法，要么该类是抽象类
}

public class Test {
    public static void main(String[] args) {
        Cat cat1 = new Cat();
        cat1.jump();
        cat1.eat();
        Animal cat2 = new Cat();
        cat2.jump();
        Animal dog1 = new Dog("haki");
        Dog dog2 = new Dog();
        dog2.jump();
        System.out.println(dog1.getName());
        System.out.println(dog2.getName());
        Person c1 = new Chinese(12);
        c1.test(c1);
        int[] bookIds = {1,2,3,4,5};
        String[] bookName = {"java从入门到放弃", "js入门到入土", "mysql从建库到删库跑路"};
        c1.readBook(bookName);
        SichuanRen sichuan1 = new SichuanRen();
        c1.test(sichuan1);
        chila sichuan2 = new SichuanRen();
        c1.test3(sichuan2);
    }
}

interface chila {
    void eatLa();
}

abstract class Person {
    private int age;
    public Person(){}
    public Person(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }
    public abstract void speak();
    public void test(Person p) {
        System.out.println(p.age);
    }
    public Person test2() {
        return new Chinese();
    }
    public void test3(chila p) {
        p.eatLa();
    }
    public void readBook(String[] arr) {
        for (int i = 0; i < arr.length; i += 1) {
            System.out.println(arr[i]);
        }
    }
}

class Chinese extends Person {
    public Chinese() {}
    public Chinese(int age) {
        super(age);
    }
    public void speak() {
        System.out.println("I'm Chinese!");
    }
}

class SichuanRen extends Chinese implements chila {
    public void eatLa() {
        System.out.println("四川人很会吃辣");
    }
}
