class X {
    Y b = new Y();
    {
        System.out.println("s");
    }
    X() {
        System.out.print("X");
    }
}
class Y {
    Y() {
        System.out.print("Y");
    }
}
public class Test extends X {
    Y y = new Y();
    Test() {
        System.out.print("Z");
    }
    public static void main(String[] args) {
        new Test();
    }
}
