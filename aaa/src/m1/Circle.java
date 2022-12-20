package m1;

public class Circle extends GeometricObect{

    private double radius;

    public Circle() {
        super();
        this.radius = 1.0;
    }

    public Circle(double radius) {
        super();
        this.radius = radius;
    }

    public Circle(double radius, String color, double weight) {
        super(color, weight);
        this.radius = radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double findArea() {
        return 3.14 * this.radius * this.radius;
    }

    @Override
    public boolean equals(Object obj) {  // 这里都是重写Object中的equals方法
        if (this == obj) {   // 表示当前的对象的地址和  传过来的对象的地址相等的话， 就直接是相等的
            return true;
        }
        if (obj instanceof Circle) {
            Circle ob = (Circle)obj;
            return this.radius == ob.radius;
        }return false;
    }
    @Override
    public String toString() {  // 重写Object中的同toString方法
        return "Circle[radius = " + this.radius + "]";
    }
//    @Text
//    public


}
