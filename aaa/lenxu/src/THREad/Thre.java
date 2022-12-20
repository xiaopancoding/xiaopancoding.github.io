package THREad;


/**
 *  除了上一个创建线程的方法之外还有一个方法
 *  利用实现接口的方式去创建
 *
 *  1. 创建一个runnable的实现类
 *  2. 然后实现runnable接口中的run() 方法
 *  3. 创建实现类的对象
 *  4. 创建一个线程的的对象，把这个实现类的对象 作为实参传进去
 *  5. 这个线程的对象调用start()方法启动线程，调用run()方法
 *
 *
 */



// 创建runnable的实现类
class ThreadTT implements Runnable {  // 实现Runnable这个接口，要实现run()这个方法， 也就是相当于上面继承Thread类重写的run()方法一样，
    // 把你要执行的功能写在这个方法中

    private int price = 100;

    // 实现runnable中run抽象的方法
    @Override
    public void run() {
        for (int i = 1; i <= 100; i ++)
            if (i % 2 == 0)
                System.out.println(i);
    }
}

public class Thre {
    public static void main(String[] args) {
        // 创建实现类的对象
        ThreadTT p = new ThreadTT();
        // 创建线程的对象
        Thread t1 = new Thread(p);
        Thread t2 = new Thread(p);
        Thread t3 = new Thread(p);

        // 这里虽然创建了三个线程对象但是实现类的对象只创建了一个，也就是说这个三个线程对象公用一个资源，也就是公用实现类中的资源

        // 调用start()方法
        t1.start();
        t2.start();
        t2.start();
        // 这里启动了三个线程，  但都是不同的线程， 就相当于，打饭，有三个窗口一样，虽然有三个窗口但是里面的东西都是一样的，都是共享的
        // 就比如说这里是共享一个属性price = 100 ，
        // 也就是三个窗口一共用100块，
        //然而这里就会存在线程安全问题， 因为第一次的时候三个窗口都是抢占同一个100元， 这样就会有线程安全问题


    }


}
