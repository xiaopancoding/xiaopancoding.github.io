package manx;

public class haoll {
    public static void main(String[] args) {
//        PassObject pa = new PassObject();
        Circle circle = new Circle();
        circle.r = 5;
//        pa.printAreas(circle, 5);
    }
}

class PassObjeck {
    public void printAreas(Circle c, int time) {
        for (int i = 1; i <= time; i ++) {
            double ares = 3.14 * i * i;
            System.out.println(ares);
        }
    }
}

class Circle {
    double r = 0.0;
    public double findArea() {
        return 3.14 * r * r;
    }
    // 重载是在同一个类中， 同一个方法名， 但是  参数列表里的， 参数个数或者参数类型不同即可
    public int max(int a, int b) {  // 重载max方法
        if (a > b) return a;
        else return b;
    }
    public  double max(double a, double b) {
        if (a > b) return a;
        else return b;
    }

}
