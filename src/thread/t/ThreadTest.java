package thread.t;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class MyThread1 extends Thread {
    public void run() {
        System.out.println("this is MyThread1");
    }
}

class MyRunnable1 implements Runnable {
    public void run() {
        System.out.println("this is MyRunnable1");
    }
}

class MyCallAble1 implements Callable {
    public String call() throws Exception {
        System.out.println("this is MyCallAble1");
        return "1";
    }
}

public class ThreadTest {
    public static void createThread() {
        // 多线程其实是多个线程去抢cpu资源，谁能抢到并不一定，即两个线程的run方法不一定谁先执行
        MyThread1 myThread1 = new MyThread1();
        myThread1.start();
        System.out.println("2");
        MyRunnable1 myRunnable1 = new MyRunnable1();
        Thread thread1 = new Thread(myRunnable1);
        thread1.start();
        MyCallAble1 myCallAble1 = new MyCallAble1();
        FutureTask ft = new FutureTask(myCallAble1);
        Thread thread2 = new Thread(ft);
        thread2.start();
    }
    public static void main(String[] args) {
        createThread();
    }
}
