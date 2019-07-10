package basic;

public class Hello {
    static String hi = "hi!";
    private String privateVar = "chichichi";
    public static String staticVar = "chichichi2";
    public String hello;
    public static void main(String[] args) {
        // 静态方法里面能直接访问静态局部变量
//        System.out.println(privateVar);
        System.out.println(staticVar);
    }
    public Hello() {
        testStaticVarible();
    }
    public void testStaticVarible() {
        // 非静态方法里既能访问静态变量也能访问非静态变量
        staticVar = "ddd";
        System.out.println(privateVar);
        System.out.println(staticVar);
        System.out.println(Hello.staticVar);
    }
}
