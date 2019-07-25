package animal;

// 从根目录开始 import test.Test;会找不到
import animal.test.Test;

public class Cat {
    public void say() {
        System.out.println("喵~喵");
    }

    /**
     *
     * @param name 食物名称
     */
    public void eat(String name) {

    }
    public static void main(String[] args) {
        new Dog(1, "dark", 11).bark();
        Dog.bark();
//        System.out.println(new Test().aaaa);
    }
}
