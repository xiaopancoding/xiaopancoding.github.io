package THREad;

/**
 * 线程同步： 假如有三个线程，就是这个三个线程，同时某一个功能
 * 假如 有三个窗口买票， 一共有100张票，正常来讲票号为100的就只能买一张的，也就是只有一张票号为100的票，但是最后可能输入三张票号为100的票号
 * 当然还有可能输出票号为0 -1， 的票， 这里体现的就是线程同步，  这样就体现了多线程存在安全性
 *
 * 为什么会出现这样的结果呢， 这是因为， 一个线程都是有生命周期的
 *
 * 线程的生命周期  有5个阶段，  其中有一个阶段不一定有
 *
 *                  阻塞
 * 新建------>就绪-------->运行--------->死亡     还有一个阻塞， 阻塞应该放在就绪和运行之间，
 *
 * 那为什么会出现上面的情况呢，  这是因为， 当有一个线程能满足条件进入  但是还没有结束，就阻塞了， 之后又有一个线程进入了， 又阻塞了，  最后还有一个进入， 最后三个线程同时一下输出， 这是就是线程同步
 * 这是不安全的
 *
 */


class Thppp implements Runnable {


    private int price = 100;  // 这个就是公用的， 就是三个窗口一起买100中票

    @Override
    public void run() {
        while (true) {


            if (price > 0) {
                // 这里很可能会又线程同步的现象， 就是一旦 来了， 然后阻塞了， 还没有执行--的操作，又有线程进来了，就会线程不安全
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(price);
                price --;
            }else {
                break;
            }
        }
    }
}


public class maipiao {
    public static void main(String[] args) {

        Thppp p = new Thppp();
        Thread t1 = new Thread(p);
        Thread t2 = new Thread(p);
        Thread t3 = new Thread(p);

        // 这里启动了三个线程，
        t1.start();
        t2.start();
        t3.start();


    }

}
