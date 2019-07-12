class A{
    public void show(){
        show2();
    }
    public void show2(){
        System.out.println("1");
    }
}
class B extends A {
    public void show2(){
        System.out.println("2");
    }
}
class C extends B {
    public void show(){
        super.show();
    }

    public void show2(){
        System.out.println("3");
    }
}

class Test {
    public static void main(String[] args) {
        A a = new B();
        a.show();
        B b = new C();
        b.show();
    }
}
