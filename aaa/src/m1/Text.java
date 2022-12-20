package m1;

public class Text {

    int age = 100;
    int id = 11;
    public static void main(String[] args) {
        PERPlo p1 = new Man();

        p1.sleep();
        p1.eat();


        // 多态的使用： 当调用子父类同名同参数的方法是, 实际执行的是子类重写父类的方法 -----  虚拟方法调用
        // 也就是说只会调用  父类中有的方法， 不会调用子类中特有的方法，  比如说这的p1对象  不会调用p1.earn(), 因为这个是子类特有的方法并不是重写的方法
        // 编译看左边， 运行是看右边
        // 多态性的使用前提  类的继承的关系， 也就是右边的继承左边的 (多态性是不适用于属性的，  编译运行都是看左边)

        // 用多态时， 调用只能调用子类进行重写过的方法
        PERPlo p2 = new Woman();

        Woman p = (Woman)p2;   // 这里可以叫做强制类型转换， 但是也不能乱强制转换， 也就是编译能过  但运行过不了

        // 编译能过，运行过不了
//        Man n2 = (Man)p2;   // 因为一开始new 的就是女人， 怎么能转化为男人呢，  所以一般就是要用instanceof  进行判断

        Text m1 = new Text();
        m1.age = 100;
        Text m2 = new Text();
        m2.age = 100;
        if (m1.equals(m2)) {
            System.out.println("11111111111111");
        }
        // 这个和基本类型转化一样的，  从小的向上转  可以自动转，  但是大的转小的  就要强制转化


//        PERPlo p3 = new PERPlo();

        //  instanceof  使用  ：   a instanceof A   判断a是不是属于A类， 如果属于的话， 返回true， 否者返回false
                            // 如果 a instanceof A 同时 a instanceof B 那么B一定是A的父类，  就如果说，a 属于男人  a也属于人，  男人一定是人的子类



        // 这三个就叫多态性
        // 多态性， 可以理解为， 一个事务的多种形态   也可以叫做是    父类的引用指向子类的对象

        // 也就是左边是父类， 然后右边的是子类，  就是定义了  一个父类的对象， 然后是指向子类的对象

        // 也就是右边的要继承左边的类

    }

    public boolean equals(Object obj) {
        if (this == obj) {   //这里是判断两个对象的地址是不是相同的， 如果是相同的话，那么就是属性就一定是相同的， 都是指向同一个位置
            return true;
        }
        if (obj instanceof Text) {
            Text ob = (Text) obj;
            return this.age == ob.age && this.id == ob.id;
        }
        return false;
    }
}
