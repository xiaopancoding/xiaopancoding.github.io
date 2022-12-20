package THREad;

/*
    程序： 为了完成某个任务的代码，是静态的
    进程： 程序的一次执行过程，或正在运行的程序， 是动态的
    线程： 一个代码内部的一条执行路径

 */


/*
    多线程可以理解为，  就比如在一个杀毒软件中， 你可以点击查杀木马，清理垃圾等功能， 这里就是多线程，也就是这个软件是支持多线程的

    线程的创建：
        > 创建一个子类继承Thread类
        > 然后在子类中重写 run() 方法， 这个方法中写， 你想要的功能，把你要的功能写进这个方法中
        > 之后在创建子类的对象
        > 子类对象调用 start() 方法，启动线程

 */


class Threadth extends Thread {  // 创建了一个类，继承了Thread类

    @Override
    public void run() {  // 重写父类中run()方法
        // 打印100以内的偶数
        for (int i = 1; i <= 100; i ++) {
            if (i % 2 == 0) {
//                try {
//                    sleep(1000);  // 这里就是使当前的线程阻塞1秒， 也就是每隔一秒输出一次， 也就是这里会停顿了
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println(getName() + ": " +i);
            }
        }
    }
}
/**
 *
 * 在线程Thread中有一些常用的方法
 * start() 启动线程， 调用当前线程中的run()方法
 * run() 这个方法一般都是重写了Thread中的此方法，就是你想要要的功能可以写在这个方法体中
 * currentThread() 获取当前正在执行代码的线程
 * getName() 获取当前线程的线程名
 * setName() 设置当前线程的线程名
 * yield() 释放当前cpu的执行权， 当然就算你这个当前释放了执行权， 但是也是有可能被它重新抢占回去的
 * join() 在线程a中调用线程b中的join(), 此时线程a就进入阻塞状态， 直到线程b完全执行完以后，线程a才结束阻塞，继续执行
 * stop() 强行结束改线程， 已经不用了 ， 过时了
 * sleep(X)  让当前线程进入睡眠， 你可以让它睡眠多久，单位是ms，  1000ms 就是1秒
 * isAlive() 判断当前的线程是否存活
 *
 */



public class ThreadText {

    public static void main(String[] args) {

        Threadth threadth = new Threadth();  // 创建对象
        // 对象调用start()方法
        // start()方法有两个意思，
            // >  启动线程  > 自动调用改线程的run() 方法


        threadth.start();
        // 这里就是两个线程了，  main方法里的是主线程， 自己造的那个是另外的一个线程
        // 这个运行就是cpu了，就是看这个两个线程，那个抢占cpu更快了， 快的就会先被执行， 当然并不是进入了这个线程就是执行完这个线程，再执行其他线程，而是相互抢占的，交替的

        // 这里就是在主线程中  调用了上面一个线程的join()方法， 就是， 主线程阻塞了， 要等上面的线程完全执行完了之后， 才会执行主线程
        try {
            threadth.join();  // 都是要抛一个异常
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 1; i <= 100; i ++) {
            if (i % 2 != 0)
                System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }


}




