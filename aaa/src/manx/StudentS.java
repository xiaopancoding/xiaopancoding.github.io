package manx;

public class StudentS extends PersonS {  // 这里就是继承的意思， extends  这个就是继承的关键字，说明当前这个类继承了PersonS这个类，
    // 也就是说， 当前这个类拥有PersonS中所有的属性和方法， 当然封装过的属性和方法也是一样被继承了， 但是由于封装性的特点，不能直接调用
    // 但是如果进行了适当的处理， 比如设置了get  set接口， 也是一样能调用的， 被继承的称为 父类，  继承的叫做子类

    long number;

    int math;
    int english;
    int comptuer;
    public StudentS(String n, char s, int a, long k, int m, int e, int c) {
        this.name = n;  // 当前的类里是没有name 这个属性的， 但是能进行赋值， 这就体现了继承了特点， 也就是继承了PersonS这个类的属性，  这个就叫继承
        this.sex = s;
        this.age = a;
        this.english = e;
        this.comptuer = c;
        this.number = k;
        this.math = m;
    }

    // 重写： 子类继承父类以后， 可以对父类中同名同参数的方法， 进行覆盖操作
    //  父类叫  被重写的方法， 只有子类中才叫重写
    // 子类中不能重写父类中 权限为 private 的方法， 不然也是和属性一样， 就不能叫做重写了

    @Override  // 这个就叫方法重写，  重写只有在继承之后才有重写这个功能
    public void eat() {  // new了一个这个类  如果调用这个方法时， 打印的就是“吃火腿”， 重写其实就是对父类中一样的方法进行覆盖
        // 重写的条件： 权限修饰符 只能大于等于 父类的
        // 返回的类型必须一样（除了引用类型， 可以是父类的子类的类型）
        // 方法名  必须一样  参数列表必须要一样，  也就是说  如果直接复制父类的方法就不会错， 只要改变方法体就行了
        System.out.println("吃西瓜！！");
    }
    // 有一点就是属性是没有重写一说的， 也就是说属性是不可以重写的， 就算是类型一样， 变量名一样，也不算是重写，该是什么样就是什么样

}
