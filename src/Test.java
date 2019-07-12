class X {
    Y b = new Y();
    X() {
        System.out.print("X");
    }
}

class Y {
    Y() {
        System.out.print("Y");
    }
}

class Z extends X {
    Y y = new Y();
    Z() {
        //super();//默认，供系统底层检查调用，而不具体执行class Z的构造方法
        System.out.print("Z");
    }
}
class Test {
    public static void main(String[] args) {
        new Z();
    }
}