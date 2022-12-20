package manx;


public class dijkstra {

    final int N = 1000;
    int[] h = new int[N];
    int[] ne = new int[N];
    int[] e = new int[N];
    int[] w = new int[N];
    int idx = 0;

    //    int[][] b = new int[N][N];
    public static void main(String[] args) {

        Person p = new Person();  // 这样的叫做构造器， 构造器和类名是相同的
//        p.setAge(10);
//        System.out.println(p.getAge());
//        Person p1 = new Person(9, 2);
//        System.out.println(p1.getAge());
        Person p3 = new Person("panjianmin");
        System.out.println(p3.getAge());
//
    }

    public void add(int a, int b, int c) {
        ne[idx] = h[a];
        e[idx] = b;
        w[idx] = c;
        h[a] = idx++;
    }

}

//  JavaBean 可以理解为  就是一种类 {
        /*
        包含一个类， 这个类中的属性只能用于自己的类中  也就是说， 这个类中的属性是private的，
        要提供  set和get方法接口
         */
//}
class Person {
    private int age;  // 这样就体现封装性， 封装性的特点就是  使属性， 只能类内部自己使用，  然后提供接口方法， 进行赋值， 和获取
    public String name;
    int legs;

    public Person() {

    }
    // this 关键字可以这么理解， 就是  当前对象的XXX， 或者  当前正在创建的对象的XXX
    public Person(int a, int b) {  // 这里的构造器用了重载， 构造器名一样， 但是参数列表不一样
        this.age = a;
        this.legs = b;
    }
    public Person(String str) {
        this(2, 3);
        this.name = str;
    }
    public void setAge(int a) {
        age = a;
    }
    public int getAge() {
        return age;
    }

}