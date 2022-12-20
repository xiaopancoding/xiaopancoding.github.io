package m1;

public class GeometricObect {
    protected String color;
    protected double weight;

    protected GeometricObect() {
        this.color = "white";
        this.weight = 1.0;
    }

    protected GeometricObect(String color, double weight) {
        this.weight = weight;
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

}
