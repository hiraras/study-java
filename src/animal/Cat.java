package animal;

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
    }
}
