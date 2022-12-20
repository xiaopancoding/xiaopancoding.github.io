package domain;

// 员工类

public class Employee {

    private int age; // 年龄
    private String name;  // 姓名
    private int id;  // ID
    private double salary;  // 工资

    public Employee() {}

    public Employee(int id, String name, int age, double salary) {
        this.age = age;
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }
}
