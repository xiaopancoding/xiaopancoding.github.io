package m1;

public class Chou {
    static final int N = 100010;
    static int[] dist = new int[N];  // 也就是说可以用static 定义全局变量
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i ++) {
            dist[i] = i;
        }


        // 这里表示的是 一个匿名类， 其实new后面的就是一个子类， 只不过这个子类，只能用一次，也就是m1 只能用一次
        // 匿名类一般用在有抽象类中， 也就是有其他类继承这个抽象类， 那么就可以这么写


        CMM m1 = new CMM() {
            @Override
            public void min() {

            }
        };

        CMM m3 = new CMM() {
            @Override
            public void min() {

            }
        };

        CMM m2 = new NNMM();  // 这里就是多态
        m2.age = 10;
        System.out.println(m2.age);

    }


}

// 这个就只能被继承， 如果不被继承就没啥软用了,
abstract class CMM {  // 这里就是一个抽象类， 不能进行实例化

    int age;
    String name;
    public CMM() {  

    }

    public abstract void min();  // 这个就是一个抽象方法， 只要有抽象方法， 那么这类就一定是抽象的类， 反之类是抽象类， 但可以没有抽象方法

}

class NNMM extends CMM {  // 继承了 抽象类， 那么当前的类就一定要重写 父类的抽象方法， 不然也要变成抽象类

    @Override
    public void min() {  // 这里必须要重写父类的抽象方法
        System.out.println("吃饭饭啦");
    }


}

// 接口， 用关键字interface修饰
//      接口里面能定义方法， 属性， 抽象方法，
interface jieko {

    public static final int a = 100;  // 这两个是一样的， 只不过下面的省略了  前面的关键字的修饰
    int b = 10;  // 在接口中都是最大权限，静态的， 最终的， 也就是说在接口中的， 变量是不能被改变的，
    // 而且是随着接口的加载而加载
    public abstract void MAXx();  // 这里是和下面一样的， 只不过下面的省略了 关键字的修饰

    void minn();  // 这里就是一个抽象的方法， 只是声明下这个方法  要实现它  还是只有在 实现类中实现，
    // 这里和抽象类很像， 如果接口中有抽象方法时， 那么实现类要么就是重写这个抽象方法， 不然实现类就要变成抽象类， 否则就会报错
    // 实现类也是要重写 接口中所有的抽象方法， 一旦没有重写，如果不想报错， 那么就只有重写， 不然就会报错
    // 如果有其他类继承了 这个实现类，那么子类要重写接口中抽象方法


}

// 这里就是接口继承接口， 那么也就是说接口也是能继承的
// 接口的具体使用体现了多态
interface MANI extends jieko{

    void dist();

    @Override
    void minn();
    // 在接口中除了抽象的放之外， 还有默认的方法， 和静态方法
    // 这里就是默认的方法， 也就是可以在方法体中写功能
    default void DIS() {
        System.out.println("1111");  // 如果这方法， 在实现类中被重写了， 那么调用的任然是重写之后的方法
    }

    // 这里就是静态的方法， 静态的， 也就是随接口的加载而加载， 也就是说只能通过接口去调用
    //
    static void inttt() {
        System.out.println("2222");
    }

}

// 这里是接口的实现类， 用关键字implements修饰interface
// 实现类  继承了接口中所有抽象方法  也就是说就要覆盖所有的方法， 不然 这个类就要变成抽象类

//  接口和抽象类的区别：
    // 接口中没有构造器， 抽象类中有构造器， 都是不能实例化
//  接口都是通过实现类去实现 抽象方法的

// java类能实现多个接口，  也就是说这个类 能有几个接口， 就相当于一个孩子有几个父亲， 但是类对类是不能的， 也就是一个类不能继承多个类， 也就是一个类只有一个父类
//   也就是弥补了 java单继承的局限性
//  格式 class AA extends BB implements CC, DD, EE ...

// 接口和接口也是继承的


class MINe implements jieko, MANI {  // 这里是实现两个接口， 实现多个接口用  “，” 逗号分隔开

    @Override
    public void dist() {

    }

    @Override //  这个实现类 有点像，类中的继承了， 只不过继承是对于类和类而言，  而实现类是对接口和类而言
    public void minn() {

    }

    @Override
    public void MAXx() {
    }
    public static void main(String[] args) {
        MINe m1 = new MINe();
        m1.dist();  // 这里调用的都是重写之后的方法
        m1.DIS();  // 接口中默认方法是能用实现类的对象 调用的
        MANI.inttt();  // 静态的方法只能通过接口名来调用了
    }
}

// 如果没有全部重写接口中的方法， 就只能变成抽象类了
abstract class INN implements jieko {

    @Override  // 只重写一个是不够的
    public void minn() {

    }

}

/*
    内部类：成员内部类和 局部内部类（方法内，代码块内，构造器能）

    既然内部类  也是一个类， 也就是说内部类也是有类的完整结构， 能被继承，能实例化，等等，



 */

