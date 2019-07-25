package inner;

interface txt {
    int ss = 11;
    void show();
}

interface Inter { void show(); }

class Outer {
    public static Inter method() {
        return new Inter() {
            public void show() {
                System.out.println("Hello World");
            }
        };
    }
}

class Person implements txt {
    private int age = 10;
    public Person() {}
    public Person(int age) {
        this.age = age;
    }
    public void show() {

    }
    public void exec() {
        InnerClass ic = new InnerClass();
        ic.print();
    }
    class InnerClass {
        private int age = 100;
        public void print() {
            int age = 200;
            System.out.println(age);
            System.out.println(this.age);
            System.out.println(Person.this.age);
            System.out.println(Person.ss);
            class PrintInner {
                public void show() {
                    System.out.println(age);
                }
            }
            new PrintInner().show();
        }
    }
}

public class Test {
    public static void main(String[] args) {
//        new Person(22).exec();
        Person.InnerClass pi = new Person().new InnerClass();
        pi.print();
        Outer.method().show();
        new Person() {
            public void print() {
                System.out.println(11222);
            }
        }.print();
        // 匿名局部类
        System.out.println(new Person() {
            public void print() {
                System.out.println(11222);
            }
        }); // inner.Test$2@1b6d3586
        System.out.println(new Person()); // inner.Person@4554617c
    }
}
