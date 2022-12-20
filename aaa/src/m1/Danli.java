package m1;

public class Danli {

    // 单例模式

}

// 饿汉式 ：  就是先在类外面 new一个对象出来
// 懒汉式：   外面的就先 赋为空，  之后在方法里面创建

// 这两中方式各有  优缺点：饿汉式线程安全   懒汉式 ：线程不安全

class ehan {  // 饿汉式 是线程安全的


    // 1. 首先要有一个  私有的  构造器还是空参的
    private ehan() {

    }
    // 2. 因为单例模式  是只有一个对象的 而且 构造器已经变成私有的  从类的外面是不能 创建对象的了
    // 所以得在类里面创建一个对象
    private static ehan en = new ehan();

    // 3. 提供一个能调用生成对象的接口
    public static ehan getEn() {  // 这里用静态方法，  所以属性也要变成静态属性
        return en;
    }

}

class lanhan {  // 懒汉式  是线程不安全的
    //1 也是要有一个私有构造器
    private lanhan() {

    }
    // 2 创建一个对象
    private static lanhan m1 = null;

    public static lanhan getM1() {
        if (m1 == null) {  // 这里其实也就是创建了一个对象，因为只有一开始才为空， 之后就不为空了， 就不会执行这个语句了
            m1 = new lanhan();
        }
        return m1;
    }
}


